package ethebee3.basicUtils;

import ethebee3.basicUtils.event.events.eventManager;
import ethebee3.basicUtils.event.eventInit.Init;
import ethebee3.basicUtils.event.events.random.OnDeInit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main2 {
    private static eventManager manager;

    public static void init(JavaPlugin main) {
        manager = new eventManager();
        new Init(main);
    }

    public static void deinit(JavaPlugin main) {
        OnDeInit.onDeInit event = new OnDeInit.onDeInit(main);
        getEventManager().fire(event);
    }

    public static eventManager getEventManager() {
        return manager;
    }
}
