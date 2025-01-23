package ethebee3.festivesmp.modules.items;

import ethebee3.basicUtils.event.events.block.OnBlockBreakEvent;
import ethebee3.basicUtils.event.events.entity.OnEntityDamageEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import ethebee3.basicUtils.utils.randUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class helmOfFortune implements OnInit, OnBlockBreakEvent, OnEntityDamageEvent {
    public NamespacedKey key;
    public static Map<Player, Double> map = (Map<Player, Double>) new ArrayList<>();

    @Override
    public void onInit(onInit event) {
        key = new NamespacedKey(event.getPlugin(), "helmoffortune");
    }

    @Override
    public void onBlockBreakEvent(onBlockBreakEvent event) {
        BlockBreakEvent event2 = event.getEvent();
        ItemMeta meta = Objects.requireNonNull(event2.getPlayer().getInventory().getHelmet()).getItemMeta();
        assert meta != null;
        if (meta.getPersistentDataContainer().has(key)) {
            handleFortuneBreak(event2);
        }
    }

    public static void handleFortuneBreak(BlockBreakEvent event) {
        Player eventPlayer = event.getPlayer();
        Block eventBlock = event.getBlock();

        if (eventBlock.getType() == Material.DEEPSLATE || eventBlock.getType() == Material.STONE) {
            if (!map.containsKey(eventPlayer)) {

            } else {

            }
        }

    }

    @Override
    public void onEntityDamageEvent(onEntityDamageEvent event) {
        EntityDamageEvent event2 = event.getEvent();
        if (event2.getEntity() instanceof Player player) {

        }
    }
}
/*
ab
ac
ad
bc
bd
cd
*/