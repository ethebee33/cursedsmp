package ethebee3.basicUtils.event.eventInit.events;

import ethebee3.basicUtils.event.events.eventManager;
import ethebee3.basicUtils.event.events.random.OnTick;
import ethebee3.basicUtils.event.events.random.OnInit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class random {
    public static void Random(JavaPlugin plugin) {
        fireTickEvent(plugin);
    }

    public static void fireTickEvent(JavaPlugin plugin) {
        OnTick.onTick event = new OnTick.onTick(plugin);
        eventManager.fire(event);
        new BukkitRunnable() {
            @Override
            public void run() {
                fireTickEvent(plugin);
            }
        }.runTaskLater(plugin, 200L);
    }

    public static void fireInitEvent(JavaPlugin plugin) {
        OnInit.onInit event = new OnInit.onInit(plugin);
    }
}
