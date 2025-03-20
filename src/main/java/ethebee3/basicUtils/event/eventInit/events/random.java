package ethebee3.basicUtils.event.eventInit.events;

import ethebee3.basicUtils.event.events.time.OnSecond;
import ethebee3.basicUtils.event.events.time.OnTick;
import ethebee3.basicUtils.event.events.random.OnInit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static ethebee3.basicUtils.Main2.getEventManager;

public class random {
    public static void Random(JavaPlugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                fireTickEvent(plugin);
                fireInitEvent(plugin);
            }
        }.runTaskLater(plugin, 1);
        new Time(plugin);
    }

    public static void fireTickEvent(JavaPlugin plugin) {
        OnTick.onTick event = new OnTick.onTick(plugin);
        getEventManager().fire(event);
        new BukkitRunnable() {
            @Override
            public void run() {
                fireTickEvent(plugin);
            }
        }.runTaskLater(plugin, 200L);
    }

    public static void fireInitEvent(JavaPlugin plugin) {
        plugin.getLogger().info("loaded onInit");
        OnInit.onInit event = new OnInit.onInit(plugin);
        getEventManager().fire(event);
    }

    public static class Time implements OnTick {
        JavaPlugin plugin;
        int currentTick = 0;

        public Time(JavaPlugin plugin) {
            this.plugin = plugin;
        }

        @Override
        public void onTick(onTick event) {
            if (currentTick == 20) {
                OnSecond.onSecond event2 = new OnSecond.onSecond(plugin);
                getEventManager().fire(event2);
                currentTick = 0;
            } else {
                currentTick++;
            }
        }
    }
}
