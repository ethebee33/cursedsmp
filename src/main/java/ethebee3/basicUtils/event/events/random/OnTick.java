package ethebee3.basicUtils.event.events.random;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;

public interface OnTick extends listener {
    void onTick(onTick event);

    class onTick extends cancelEvent<OnTick> {
        private final JavaPlugin event;

        public onTick(JavaPlugin event) {
            this.event = event;
        }

        public JavaPlugin getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnTick> listeners) {
            for (OnTick listener : listeners) {
                listener.onTick(this);
            }
        }

        @Override
        public Class<OnTick> getListenerType() {
            return OnTick.class;
        }
    }
}