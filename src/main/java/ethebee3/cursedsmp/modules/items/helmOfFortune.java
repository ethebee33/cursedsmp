package ethebee3.cursedsmp.modules.items;

import ethebee3.basicUtils.Main2;
import ethebee3.basicUtils.event.events.block.OnBlockBreakEvent;
import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.entity.OnEntityDamageEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.utils.randUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class helmOfFortune implements OnInit, OnBlockBreakEvent, OnEntityDamageByEntityEvent, OnEntityDamageEvent {
    public helmOfFortune() {
        Main2.getEventManager().add(OnBlockBreakEvent.class, this);
        Main2.getEventManager().add(OnEntityDamageByEntityEvent.class, this);
        Main2.getEventManager().add(OnEntityDamageEvent.class, this);
        Main2.getEventManager().add(OnInit.class, this);
    }
    // Plugin and NamespacedKeys
    public static JavaPlugin Plugin;
    public static NamespacedKey keyt1;
    public static NamespacedKey keyt2;
    public static NamespacedKey keyt3;
    public static NamespacedKey healthChangeKey;

    // Maps for tracking damage changes and item drops
    public static Map<Player, Double> map = new HashMap<>();
    public static Map<Integer, ItemStack> itemmap = new HashMap<>();

    @Override
    public void onInit(onInit event) {
        // Initialize plugin and NamespacedKeys
        Plugin = event.getPlugin();
        keyt1 = new NamespacedKey(Plugin, "helmoffortune1");
        keyt2 = new NamespacedKey(Plugin, "helmoffortune2");
        keyt3 = new NamespacedKey(Plugin, "helmoffortune3");
        healthChangeKey = new NamespacedKey(Plugin, "healthChangeKey");

        // Initialize itemmap with predefined materials
        itemmap.put(0, new ItemStack(Material.DIAMOND));
        itemmap.put(1, new ItemStack(Material.EMERALD));
        itemmap.put(2, new ItemStack(Material.GOLD_INGOT));
        itemmap.put(3, new ItemStack(Material.IRON_INGOT));

        Bukkit.getLogger().info("Initialized NamespacedKeys: " + keyt1 + ", " + keyt2 + ", " + keyt3);
    }

    // Handle block break event to apply fortune-related effects
    @Override
    public void onBlockBreakEvent(onBlockBreakEvent event) {
        BlockBreakEvent event2 = event.getEvent();
        Player player = event2.getPlayer();
        if (player.getInventory().getHelmet() != null) {
            ItemMeta meta = player.getInventory().getHelmet().getItemMeta();
            if (meta != null) {
                // Check which type of Helm of Fortune the player has equipped
                if (meta.getPersistentDataContainer().has(keyt1)) {
                    handleFortuneBreakT1(event2);
                }
                if (meta.getPersistentDataContainer().has(keyt2)) {
                    handleFortuneBreakT2(event2);
                }
                if (meta.getPersistentDataContainer().has(keyt3)) {
                    handleFortuneBreakT3(event2);
                }
            }
        }
    }

    // Handle Fortune effect for T1 helmet
    public static void handleFortuneBreakT1(BlockBreakEvent event) {
        Player eventPlayer = event.getPlayer();
        Block eventBlock = event.getBlock();
        if (eventBlock.getType() == Material.DEEPSLATE || eventBlock.getType() == Material.STONE) {
            if (randUtils.generateRandomInt(0, 10) == 0) {
                if (damageChangeUp(eventPlayer, 0.2)) {
                    handleDrops(event);
                }
            }
        }
    }

    // Handle Fortune effect for T2 helmet
    public static void handleFortuneBreakT2(BlockBreakEvent event) {
        Player eventPlayer = event.getPlayer();
        Block eventBlock = event.getBlock();
        if (eventBlock.getType() == Material.DEEPSLATE || eventBlock.getType() == Material.STONE) {
            if (randUtils.generateRandomInt(0, 9) == 0) {
                if (damageChangeUp(eventPlayer, 0.2)) {
                    handleDrops(event);
                }
            }
        }
    }

    // Handle Fortune effect for T3 helmet
    public static void handleFortuneBreakT3(BlockBreakEvent event) {
        Player eventPlayer = event.getPlayer();
        Block eventBlock = event.getBlock();
        if (eventBlock.getType() == Material.DEEPSLATE || eventBlock.getType() == Material.STONE) {
            if (randUtils.generateRandomInt(0, 8) == 0) {
                if (damageChangeUp(eventPlayer, 0.2)) {
                    handleDrops(event);
                }
            }
        }
    }

    // Handle dropping additional items when block is broken
    public static void handleDrops(BlockBreakEvent event) {
        List<ItemStack> drops = (List<ItemStack>) event.getBlock().getDrops();
        drops.add(itemmap.get(randUtils.generateRandomInt(0, 3)));
        event.setDropItems(false);
        for (ItemStack drop : drops) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), drop);
        }
    }

    // Handle damage multiplier increase for player
    public static boolean damageChangeUp(Player player, double amount) {
        if (map.containsKey(player)) {
            double oldAmount = map.get(player);
            double newAmount = map.get(player) + amount;
            newAmount = Math.round(newAmount * 10.0) / 10.0;
            if (newAmount > 2) {
                player.sendMessage("damage dealt to you is now " + oldAmount + "x the regular amount");
                player.sendMessage("damage multiplier reached, you will not get the extra drops until it goes down.");
                return false;
            }
            map.replace(player, map.get(player), newAmount);
            player.sendMessage("damage dealt to you is now " + newAmount + "x the regular amount");
            new BukkitRunnable() {
                @Override
                public void run() {
                    damageChangeDown(player, amount);
                }
            }.runTaskLater(Plugin, 10000);
        } else {
            map.put(player, amount + 1);
            player.sendMessage("damage dealt to you is now " + (amount + 1) + "x the regular amount");
            new BukkitRunnable() {
                @Override
                public void run() {
                    damageChangeDown(player, amount);
                }
            }.runTaskLater(Plugin, 10000);
        }
        return true;
    }

    // Handle damage multiplier decrease for player
    public static void damageChangeDown(Player player, double amount) {
        if (map.containsKey(player)) {
            double newAmount = map.get(player) - amount;
            newAmount = Math.round(newAmount * 10.0) / 10.0;
            if (newAmount >= 1) {
                map.replace(player, map.get(player), newAmount);
                player.sendMessage("damage dealt to you is now " + newAmount + "x the regular amount");
            } else {
                map.replace(player, map.get(player), 1.0);
                player.sendMessage("error with damage multiplier calculation, please report this, failure to do so could result in a ban");
            }
        } else {
            map.put(player, 1.0);
            player.sendMessage("damage dealt to you is now " + 1 + "x the regular amount");
        }
    }

    // Handle entity damage by another entity
    @Override
    public void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();

        // Player being damaged
        if (event2.getEntity() instanceof Player player) {
            ItemMeta meta = Objects.requireNonNull(player.getInventory().getHelmet()).getItemMeta();
            if (meta != null && meta.getPersistentDataContainer().has(keyt3)) {
                if (randUtils.generateRandomInt(0, 99) < 15) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 1));
                }
            }
        }

        // Player dealing damage
        if (event2.getDamager() instanceof Player player) {
            ItemMeta meta = Objects.requireNonNull(player.getInventory().getHelmet()).getItemMeta();
            if (meta != null) {
                if (meta.getPersistentDataContainer().has(keyt2) || meta.getPersistentDataContainer().has(keyt3)) {
                    if (randUtils.generateRandomInt(0, 4) == 0) {
                        event2.setDamage(event2.getDamage() * 1.3);
                    }
                }
            }
        }
    }

    // Handle generic entity damage event (for damage multiplier)
    @Override
    public void onEntityDamageEvent(onEntityDamageEvent event) {
        EntityDamageEvent event2 = event.getEvent();
        if (event2.getEntity() instanceof Player player) {
            if (map.containsKey(player)) {
                event2.setDamage(event2.getDamage() * map.get(player));
            }
        }
    }
}
