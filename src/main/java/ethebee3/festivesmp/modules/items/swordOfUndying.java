package ethebee3.festivesmp.modules.items;

import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.event.events.random.OnTick;
import ethebee3.basicUtils.utils.randUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Map;

public class swordOfUndying implements OnInit, OnTick, OnEntityDamageByEntityEvent {
    public static JavaPlugin plugin;
    public NamespacedKey keyt1;
    public NamespacedKey keyt2;
    public NamespacedKey keyt3;
    public static Map<Player, Integer> t1 = (Map<Player, Integer>) new ArrayList<>();
    public static Map<Player, Integer> t2 = (Map<Player, Integer>) new ArrayList<>();
    public static Map<Player, Integer> t3 = (Map<Player, Integer>) new ArrayList<>();

    @Override
    public void onInit(onInit event) {
        plugin = event.getPlugin();
        keyt1 = new NamespacedKey(event.getPlugin(), "swordofundying:t1");
    }

    @Override
    public void onTick(onTick event) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            assert meta != null;
            if (meta.getPersistentDataContainer().has(keyt1, PersistentDataType.STRING) ) {
                handleSwordTickT1(player);
            }

            if (meta.getPersistentDataContainer().has(keyt2, PersistentDataType.STRING) ) {
                handleSwordTickT2(player);
            }

            if (meta.getPersistentDataContainer().has(keyt3, PersistentDataType.STRING) ) {
                handleSwordTickT3(player);
            }
        }
    }

    public static void handleSwordTickT1(Player player) {
        if (!t1.containsKey(player)) {
            t1.put(player, 0);
        }
        if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 5) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
        }
        if (t1.get(player) == 0) {
            t1.replace(player, 0, 200);
            if (player.getFoodLevel() > 1) {
                player.setFoodLevel(player.getFoodLevel() - 1);
            }
        } else {
            t1.replace(player, t1.get(player), t1.get(player) - 1);
        }
    }

    public static void handleSwordTickT2(Player player) {
        if (!t2.containsKey(player)) {
            t2.put(player, 0);
        }
        if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 5) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
        }
        if (t2.get(player) == 0) {
            t2.replace(player, 0, 100);
            if (player.getFoodLevel() > 1) {
                player.setFoodLevel(player.getFoodLevel() - 1);
            }
        } else {
            t2.replace(player, t2.get(player), t2.get(player) - 1);
        }
    }

    public static void handleSwordTickT3(Player player) {
        if (!t3.containsKey(player)) {
            t2.put(player, 0);
        }
        if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 5) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
        }
        if (t3.get(player) == 0) {
            t3.replace(player, 0, 100);
            if (player.getFoodLevel() > 1) {
                player.setFoodLevel(player.getFoodLevel() - 1);
            }
        } else {
            t3.replace(player, t3.get(player), t3.get(player) - 1);
        }
    }

    @Override
    public void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();

        if (event2.getEntity() instanceof Player player1 &&
            event2.getDamager() instanceof Player player2) {
            assert player1.getInventory().getItemInMainHand().getItemMeta() != null;
            if (player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt2) || player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt3)) {
                if (player1.getHealth() < 10) {
                    if (randUtils.generateRandomInt(0, 10) < 1) {
                        player1.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 200, 2));
                    }
                }
            }
            assert player1.getInventory().getItemInMainHand().getItemMeta() != null;
            if (player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt3)) {
                if (randUtils.generateRandomInt(0, 10) < 3) {
                    if (event2.getDamage() > player1.getHealth()) {
                        if (player1.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player1.getInventory().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                                }
                            }.runTaskLater(plugin, 1);
                        } else if (player1.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player1.getInventory().setItemInMainHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                                }
                            }.runTaskLater(plugin, 1);
                        } else {
                            ItemStack tempitem = player1.getInventory().getItemInMainHand();
                            player1.setItemInHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player1.setItemInHand(tempitem);
                                }
                            }.runTaskLater(plugin, 1);
                        }
                    }
                }
            }
        }
    }
}
