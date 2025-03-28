package ethebee3.cursedsmp.modules.items;

import ethebee3.basicUtils.Main2;
import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.entity.OnEntityShootBowEvent;
import ethebee3.basicUtils.event.events.random.OnDeInit;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.utils.randUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bowOfShadows implements OnInit, OnEntityShootBowEvent, OnEntityDamageByEntityEvent, OnDeInit {
    public bowOfShadows() {
        Main2.getEventManager().add(OnInit.class, this);
        Main2.getEventManager().add(OnDeInit.class, this);
        Main2.getEventManager().add(OnEntityShootBowEvent.class, this);
        Main2.getEventManager().add(OnEntityDamageByEntityEvent.class, this);
    }

    // Static variables for the plugin and NamespacedKeys
    static JavaPlugin Plugin;
    public static NamespacedKey keyt1;
    public static NamespacedKey keyt2;
    public static NamespacedKey keyt3;

    // Maps to store relevant data for arrows, key mappings, and health reset mappings
    static Map<Entity, Player> arrowmap = new HashMap<>();
    static Map<Entity, NamespacedKey> keymap = new HashMap<>();
    static ArrayList<Player> resetmap = new ArrayList<>();

    @Override
    public void onInit(onInit event) {
        Plugin = event.getPlugin();
        keyt1 = new NamespacedKey(Plugin, "bowofshadowst1");
        keyt2 = new NamespacedKey(Plugin, "bowofshadowst2");
        keyt3 = new NamespacedKey(Plugin, "bowofshadowst3");
        Bukkit.getLogger().info("Initialized NamespacedKeys: " + keyt1 + ", " + keyt2 + ", " + keyt3);
    }

    @Override
    public void onEntityShootBowEvent(onEntityShootBowEvent event) {
        EntityShootBowEvent event2 = event.getEvent();

        // Check if the entity shooting the bow is a player
        if (event2.getEntity() instanceof Player player) {
            ItemStack bow = event2.getBow();

            // Ensure bow has item meta and check for persistent data keys
            // After, use the function corresponding to the key it has
            if (bow != null && bow.getItemMeta() != null) {
                if (bow.getItemMeta().getPersistentDataContainer().has(keyt1)) {
                    arrowmap.put(event2.getProjectile(), player);
                    keymap.put(event2.getProjectile(), keyt1);
                }
                if (bow.getItemMeta().getPersistentDataContainer().has(keyt2)) {
                    arrowmap.put(event2.getProjectile(), player);
                    keymap.put(event2.getProjectile(), keyt2);
                }
                if (bow.getItemMeta().getPersistentDataContainer().has(keyt3)) {
                    arrowmap.put(event2.getProjectile(), player);
                    keymap.put(event2.getProjectile(), keyt3);
                }
            }
        }
    }

    @Override
    public void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();

        // Check if the damager is an arrow and was shot by a player
        if (arrowmap.containsKey(event2.getDamager())) {
            Player attacker = arrowmap.get(event2.getDamager());
            Player victim = (Player) event2.getEntity();

            // Handle the effects for each key type
            if (keymap.get(event2.getDamager()) == keyt1) {
                handleBowEffectT1(event2, attacker, victim);
            }
            if (keymap.get(event2.getDamager()) == keyt2) {
                handleBowEffectT2(event2, attacker, victim);
            }
            if (keymap.get(event2.getDamager()) == keyt3) {
                handleBowEffectT3(event2, attacker, victim);
            }
        }
    }

    // Handle effect for the first key (T1)
    private void handleBowEffectT1(EntityDamageByEntityEvent event2, Player attacker, Player victim) {
        if (randUtils.generateRandomInt(0, 5) == 0) {
            Location victimLocation = victim.getLocation();
            Location attackerLocation = attacker.getLocation();
            Vector direction = victimLocation.toVector().subtract(attackerLocation.toVector()).normalize();
            Location behindLocation = victimLocation.add(direction.multiply(2));
            behindLocation.setPitch(attackerLocation.getPitch());
            behindLocation.setYaw(attackerLocation.getYaw() + 180);
            if (behindLocation.getBlock().getType() == Material.AIR) {
                attacker.teleport(behindLocation);
                attacker.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 0));
                event2.setDamage(0);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        victim.setVelocity(new Vector(0, 0, 0));
                    }
                }.runTaskLater(Plugin, 1);
            } else {
                if (attacker.isOp()) {
                    attacker.sendMessage("debug: space behind player isn't air");
                }
            }
        }
    }

    // Handle effect for the second key (T2)
    private void handleBowEffectT2(EntityDamageByEntityEvent event2, Player attacker, Player victim) {
        if (randUtils.generateRandomInt(0, 5) == 0) {
            // Calculate the position behind the victim
            Location victimLocation = victim.getLocation();
            Location attackerLocation = attacker.getLocation();
            Vector direction = victimLocation.toVector().subtract(attackerLocation.toVector()).normalize();
            Location behindLocation = victimLocation.add(direction.multiply(2));
            behindLocation.setPitch(attackerLocation.getPitch());
            behindLocation.setYaw(attackerLocation.getYaw() + 180);
            if (behindLocation.getBlock().getType() == Material.AIR) {
                attacker.teleport(behindLocation);
                attacker.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 0));
                event2.setDamage(0);
                applyDamage(4, victim);
                changeAndRegenerateHealth(attacker, -2, 5000);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        victim.setVelocity(new Vector(0, 0, 0));
                    }
                }.runTaskLater(Plugin, 1);
            } else {
                if (attacker.isOp()) {
                    attacker.sendMessage("debug: space behind player isn't air");
                }
            }
        }
    }

    // Handle effect for the third key (T3)
    private void handleBowEffectT3(EntityDamageByEntityEvent event2, Player attacker, Player victim) {
        if (randUtils.generateRandomInt(0, 5) == 0) {
            // Calculate the position behind the victim
            Location victimLocation = victim.getLocation();
            Location attackerLocation = attacker.getLocation();
            Vector direction = victimLocation.toVector().subtract(attackerLocation.toVector()).normalize();
            Location behindLocation = victimLocation.add(direction.multiply(2));
            behindLocation.setPitch(attackerLocation.getPitch());
            behindLocation.setYaw(attackerLocation.getYaw() + 180);
            if (behindLocation.getBlock().getType() == Material.AIR) {
                attacker.teleport(behindLocation);
                attacker.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 0));
                event2.setDamage(0);
                applyDamage(4, victim);
                victim.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 60, 0));
                changeAndRegenerateHealth(attacker, -2, 5000);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        victim.setVelocity(new Vector(0, 0, 0));
                    }
                }.runTaskLater(Plugin, 1);
            } else {
                if (attacker.isOp()) {
                    attacker.sendMessage("debug: space behind player isn't air");
                }
            }
        }
    }

    private void changeAndRegenerateHealth(Player player, double healthChange, long regenerationDelay) {
        resetmap.add(player);
        double oldhealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        double newhealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() + healthChange;
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(newhealth);
        new BukkitRunnable() {
            @Override
            public void run() {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(oldhealth);
            }
        }.runTaskLater(Plugin, regenerationDelay);
    }

    private void applyDamage(int damage, Player player) {
        player.setHealth(player.getHealth() - damage);
    }

    @Override
    public void onDeInit(onDeInit event) {
        for (Player player : resetmap) {
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        }
    }

}
