package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;

import java.util.ArrayList;

public interface OnEntityPortalEnterEvent extends listener {
    void onEntityPortalEnterEvent(onEntityPortalEnterEvent event);

    class onEntityPortalEnterEvent extends cancelEvent<OnEntityPortalEnterEvent> {
        private final EntityPortalEnterEvent event;

        public onEntityPortalEnterEvent(EntityPortalEnterEvent event) {
            this.event = event;
        }

        public EntityPortalEnterEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityPortalEnterEvent> listeners) {
            for (OnEntityPortalEnterEvent listener : listeners) {
                listener.onEntityPortalEnterEvent(this);
            }
        }

        @Override
        public Class<OnEntityPortalEnterEvent> getListenerType() {
            return OnEntityPortalEnterEvent.class;
        }
    }
}