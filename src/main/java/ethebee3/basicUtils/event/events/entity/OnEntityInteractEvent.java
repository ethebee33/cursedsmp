package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityInteractEvent;

import java.util.ArrayList;

public interface OnEntityInteractEvent extends listener {
    void onEntityInteractEvent(onEntityInteractEvent event);

    class onEntityInteractEvent extends cancelEvent<OnEntityInteractEvent> {
        private final EntityInteractEvent event;

        public onEntityInteractEvent(EntityInteractEvent event) {
            this.event = event;
        }

        public EntityInteractEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityInteractEvent> listeners) {
            for (OnEntityInteractEvent listener : listeners) {
                listener.onEntityInteractEvent(this);
            }
        }

        @Override
        public Class<OnEntityInteractEvent> getListenerType() {
            return OnEntityInteractEvent.class;
        }
    }
}