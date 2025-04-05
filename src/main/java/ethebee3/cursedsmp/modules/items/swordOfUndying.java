package ethebee3.cursedsmp.modules.items;

import ethebee3.basicUtils.Main2;
import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.event.events.time.OnTick;
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

import java.util.HashMap;
import java.util.Map;

public class swordOfUndying implements OnInit, OnTick, OnEntityDamageByEntityEvent{
    public swordOfUndying() {
        Main2.getEventManager().add(OnInit.class, this);
        Main2.getEventManager().add(OnTick.class, this);
        Main2.getEventManager().add(OnEntityDamageByEntityEvent.class, this);
    }

    public static JavaPlugin Plugin;
    public static NamespacedKey keyt1;
    public static NamespacedKey keyt2;
    public static NamespacedKey keyt3;
    public static Map<Player, Integer> t1 = new HashMap<>();
    public static Map<Player, Integer> t2 = new HashMap<>();
    public static Map<Player, Integer> t3 = new HashMap<>();

    @Override
    public void onInit(onInit event) {
        Plugin = event.getPlugin();
        keyt1 = new NamespacedKey(Plugin, "swordofundyingt1");
        keyt2 = new NamespacedKey(Plugin, "swordofundyingt2");
        keyt3 = new NamespacedKey(Plugin, "swordofundyingt3");
        Bukkit.getLogger().info("Initialized NamespacedKeys: " + keyt1 + ", " + keyt2 + ", " + keyt3);
    }

    @Override
    public void onTick(onTick event) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            if (meta != null) {
                if (meta.getPersistentDataContainer().has(keyt1, PersistentDataType.STRING)) {
                    if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 6) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
                    }
                    if (!player.hasPotionEffect(PotionEffectType.HUNGER)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5, 5));
                    }
                    break;
                }

                if (meta.getPersistentDataContainer().has(keyt2, PersistentDataType.STRING)) {
                    if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 6) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
                    }
                    if (!player.hasPotionEffect(PotionEffectType.HUNGER)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5, 7));
                    }
                    break;
                }

                if (meta.getPersistentDataContainer().has(keyt3, PersistentDataType.STRING)) {
                    if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 6) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
                    }
                    if (!player.hasPotionEffect(PotionEffectType.HUNGER)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5, 10));
                    }
                    break;
                }

            }
        }
    }



    @Override
    public void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();

        if (event2.getEntity() instanceof Player player1 &&
            event2.getDamager() instanceof Player player2) {
            if (player1.getInventory().getItemInMainHand().getItemMeta() != null) {
                if (player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt2) || player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt3)) {
                    if (player1.getHealth() < 10) {
                        if (randUtils.generateRandomInt(0, 10) < 1) {
                            player1.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 200, 2));
                        }
                    }
                }
            }
            if (player1.getInventory().getItemInMainHand().getItemMeta() != null) {
                if (player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt3)) {
                    if (randUtils.generateRandomInt(0, 10) < 3) {
                        if (event2.getDamage() > player1.getHealth()) {
                            if (player1.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player1.getInventory().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                                    }
                                }.runTaskLater(Plugin, 1);
                            } else if (player1.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING) {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player1.getInventory().setItemInMainHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                                    }
                                }.runTaskLater(Plugin, 1);
                            } else {
                                ItemStack tempitem = player1.getInventory().getItemInMainHand();
                                player1.setItemInHand(new ItemStack(Material.TOTEM_OF_UNDYING));
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player1.setItemInHand(tempitem);
                                    }
                                }.runTaskLater(Plugin, 1);
                            }
                        }
                    }
                }
            }
        }
    }
}
