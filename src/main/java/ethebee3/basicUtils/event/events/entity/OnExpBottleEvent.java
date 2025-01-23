package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.ExpBottleEvent;

import java.util.ArrayList;

public interface OnExpBottleEvent extends listener {
    void onExpBottleEvent(onExpBottleEvent event);

    class onExpBottleEvent extends cancelEvent<OnExpBottleEvent> {
        private final ExpBottleEvent event;

        public onExpBottleEvent(ExpBottleEvent event) {
            this.event = event;
        }

        public ExpBottleEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnExpBottleEvent> listeners) {
            for (OnExpBottleEvent listener : listeners) {
                listener.onExpBottleEvent(this);
            }
        }

        @Override
        public Class<OnExpBottleEvent> getListenerType() {
            return OnExpBottleEvent.class;
        }
    }
}