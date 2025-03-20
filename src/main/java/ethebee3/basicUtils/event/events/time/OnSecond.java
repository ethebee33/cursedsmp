package ethebee3.basicUtils.event.events.time;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;

public interface OnSecond extends listener {
    void onSecond(onSecond event);

    class onSecond extends cancelEvent<OnSecond> {
        private final JavaPlugin event;

        public onSecond(JavaPlugin event) {
            this.event = event;
        }

        public JavaPlugin getPlugin() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnSecond> listeners) {
            for (OnSecond listener : listeners) {
                listener.onSecond(this);
            }
        }

        @Override
        public Class<OnSecond> getListenerType() {
            return OnSecond.class;
        }
    }
}