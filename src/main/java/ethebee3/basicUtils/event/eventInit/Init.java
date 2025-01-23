package ethebee3.basicUtils.event.eventInit;

import ethebee3.basicUtils.event.eventInit.events.block;
import ethebee3.basicUtils.event.eventInit.events.entity;
import ethebee3.basicUtils.event.eventInit.events.player;
import ethebee3.basicUtils.event.eventInit.events.random;
import org.bukkit.plugin.java.JavaPlugin;

public class Init {
    public Init(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new block(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new player(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new entity(), plugin);
        random.Random(plugin);
    }
}
