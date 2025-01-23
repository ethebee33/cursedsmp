package ethebee3.basicUtils.event.events.random;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;

public interface OnInit extends listener {
    void onInit(onInit event);

    class onInit extends cancelEvent<OnInit> {
        private final JavaPlugin event;

        public onInit(JavaPlugin event) {
            this.event = event;
        }

        public JavaPlugin getPlugin() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnInit> listeners) {
            for (OnInit listener : listeners) {
                listener.onInit(this);
            }
        }

        @Override
        public Class<OnInit> getListenerType() {
            return OnInit.class;
        }
    }
}