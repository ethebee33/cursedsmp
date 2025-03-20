package ethebee3.basicUtils.event.events.random;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;

public interface OnDeInit extends listener {
    void onDeInit(onDeInit event);

    class onDeInit extends cancelEvent<OnDeInit> {
        private final JavaPlugin event;

        public onDeInit(JavaPlugin event) {
            this.event = event;
        }

        public JavaPlugin getPlugin() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnDeInit> listeners) {
            getPlugin().getLogger().info("fired oninit");
            for (OnDeInit listener : listeners) {
                listener.onDeInit(this);
            }
        }

        @Override
        public Class<OnDeInit> getListenerType() {
            return OnDeInit.class;
        }
    }
}