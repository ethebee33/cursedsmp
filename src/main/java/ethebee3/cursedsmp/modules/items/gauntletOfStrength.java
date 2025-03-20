package ethebee3.cursedsmp.modules.items;

import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.player.OnPlayerMoveEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.event.events.time.OnSecond;
import ethebee3.basicUtils.event.events.time.OnTick;
import ethebee3.basicUtils.utils.randUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class gauntletOfStrength implements OnInit, OnSecond, OnEntityDamageByEntityEvent, OnPlayerMoveEvent {
    public gauntletOfStrength() {}

    public static JavaPlugin Plugin;
    public static NamespacedKey keyt1;
    public static NamespacedKey keyt2;
    public static NamespacedKey keyt3;
    public static Map<Player, Integer> stunMap = new HashMap<>();

    @Override
    public void onInit(onInit event) {
        Plugin = event.getPlugin();
        keyt1 = new NamespacedKey(Plugin, "gauntletofstrengtht1");
        keyt2 = new NamespacedKey(Plugin, "gauntletofstrengtht2");
        keyt3 = new NamespacedKey(Plugin, "gauntletofstrengtht3");
    }

    @Override
    public void onSecond(onSecond event) {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().has(keyt2)
                || player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().has(keyt3)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 22, 1));
            }
        }

        for(Player victim : stunMap.keySet()) {
            if (stunMap.get(victim) > 1) {
                stunMap.replace(victim, stunMap.get(victim) - 1);
            } else {
                stunMap.remove(victim);
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();
        if (event2.getDamager() instanceof Player attacker && event2.getEntity() instanceof Player victim) {
            if (attacker.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().has(keyt1)) {
                event2.setDamage(event2.getDamage() * 1.5);
                stunMap.put(attacker, 1);
            }
            if (attacker.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().has(keyt2)) {
                event2.setDamage(event2.getDamage() * 1.5);
                stunMap.put(attacker, 2);
            }
            if (attacker.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().has(keyt3)) {
                event2.setDamage(event2.getDamage() * 1.5);
                stunMap.put(attacker, 3);
                if (randUtils.generateRandomInt(0, 5) == 0) {
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
                }
            }
        }
    }

    @Override
    public void onPlayerMoveEvent(onPlayerMoveEvent event) {
        PlayerMoveEvent event2 = event.getEvent();
        if (stunMap.containsKey(event2.getPlayer())) {
            event2.setCancelled(true);
        }
    }
}
