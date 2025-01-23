package ethebee3.festivesmp.modules.items;

import ethebee3.basicUtils.event.events.entity.OnEntityDamageEvent;
import ethebee3.basicUtils.event.events.entity.OnEntityShootBowEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.ArrayList;
import java.util.Map;

public class bowofshadows implements OnInit, OnEntityShootBowEvent, OnEntityDamageEvent {
    public NamespacedKey key;
    public static Map<Player, Double> map = (Map<Player, Double>) new ArrayList<>();

    @Override
    public void onInit(onInit event) {
        key = new NamespacedKey(event.getPlugin(), "bowofshadows");
    }

    @Override
    public void onEntityShootBowEvent(onEntityShootBowEvent event) {
        EntityShootBowEvent event2 = event.getEvent();
        
    }

    @Override
    public void onEntityDamageEvent(onEntityDamageEvent event) {
        EntityDamageEvent event2 = event.getEvent();
        if (event2.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {

        }
    }
}
