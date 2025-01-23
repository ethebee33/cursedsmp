package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.ArrayList;

public interface OnEntityChangeBlockEvent extends listener {
    void onEntityChangeBlockEvent(onEntityChangeBlockEvent event);

    class onEntityChangeBlockEvent extends cancelEvent<OnEntityChangeBlockEvent> {
        private final EntityChangeBlockEvent event;

        public onEntityChangeBlockEvent(EntityChangeBlockEvent event) {
            this.event = event;
        }

        public EntityChangeBlockEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityChangeBlockEvent> listeners) {
            for (OnEntityChangeBlockEvent listener : listeners) {
                listener.onEntityChangeBlockEvent(this);
            }
        }

        @Override
        public Class<OnEntityChangeBlockEvent> getListenerType() {
            return OnEntityChangeBlockEvent.class;
        }
    }
}