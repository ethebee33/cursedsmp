package ethebee3.basicUtils;

import ethebee3.basicUtils.event.events.eventManager;
import ethebee3.basicUtils.event.eventInit.Init;
import org.bukkit.plugin.java.JavaPlugin;

public class Main2 {
    public static void init(JavaPlugin main) {
        new eventManager();
        new Init(main);
    }
}
