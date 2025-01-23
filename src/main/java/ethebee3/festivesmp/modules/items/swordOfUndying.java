package ethebee3.festivesmp.modules.items;

import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.event.events.random.OnTick;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Map;


public class swordOfUndying implements OnInit, OnTick {
    public NamespacedKey key;
    public static Map<Player, Integer> map = (Map<Player, Integer>) new ArrayList<>();

    @Override
    public void onInit(onInit event) {
        key = new NamespacedKey(event.getPlugin(), "swordofundying");
    }

    @Override
    public void onTick(onTick event) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            assert meta != null;
            if (meta.getPersistentDataContainer().has(key, PersistentDataType.STRING) ) {
                handleSwordTick(player);
            }
            ItemMeta meta2 = player.getInventory().getItemInOffHand().getItemMeta();
            assert meta2 != null;
            if (meta2.getPersistentDataContainer().has(key, PersistentDataType.STRING) ) {
                handleSwordTick(player);
            }
        }
    }

    public static void handleSwordTick(Player player) {
        if (!map.containsKey(player)) {
            map.put(player, 0);
        }
        if (!player.hasPotionEffect(PotionEffectType.REGENERATION) && player.getHealth() < 5) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 3));
        }
        if (map.get(player) == 0) {
            map.replace(player, 0, 200);
            if (player.getFoodLevel() > 1) {
                player.setFoodLevel(player.getFoodLevel() - 1);
            }
        } else {
            map.replace(player, map.get(player), map.get(player) - 1);
        }
    }
}
