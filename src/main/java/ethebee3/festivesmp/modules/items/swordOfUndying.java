package ethebee3.festivesmp.modules.items;

import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.event.events.random.OnTick;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Map;

public class swordOfUndying implements OnInit, OnTick, OnEntityDamageByEntityEvent {
    public NamespacedKey keyt1;
    public NamespacedKey keyt2;
    public NamespacedKey keyt3;
    public static Map<Player, Integer> t1 = (Map<Player, Integer>) new ArrayList<>();
    public static Map<Player, Integer> t2 = (Map<Player, Integer>) new ArrayList<>();
    public static Map<Player, Integer> t3 = (Map<Player, Integer>) new ArrayList<>();

    @Override
    public void onInit(onInit event) {
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
        if (!t1.containsKey(player)) {
            t1.put(player, 0);
        }
        if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 5) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
        }
        if (t1.get(player) == 0) {
            t1.replace(player, 0, 100);
            if (player.getFoodLevel() > 1) {
                player.setFoodLevel(player.getFoodLevel() - 1);
            }
        } else {
            t1.replace(player, t1.get(player), t1.get(player) - 1);
        }
    }

    @Override
    public void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();
        if (event2.getEntity() instanceof Player player1 &&
            event2.getDamager() instanceof Player player2) {
            if (player1.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(keyt2)) {

            }
        }
    }
}
