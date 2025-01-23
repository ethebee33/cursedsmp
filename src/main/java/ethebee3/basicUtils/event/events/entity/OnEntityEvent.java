package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityEvent;

import java.util.ArrayList;

public interface OnEntityEvent extends listener {
    void onEntityEvent(onEntityEvent event);

    class onEntityEvent extends cancelEvent<OnEntityEvent> {
        private final EntityEvent event;

        public onEntityEvent(EntityEvent event) {
            this.event = event;
        }

        public EntityEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityEvent> listeners) {
            for (OnEntityEvent listener : listeners) {
                listener.onEntityEvent(this);
            }
        }

        @Override
        public Class<OnEntityEvent> getListenerType() {
            return OnEntityEvent.class;
        }
    }
}