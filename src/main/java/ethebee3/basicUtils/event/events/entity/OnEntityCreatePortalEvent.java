package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;

import java.util.ArrayList;

public interface OnEntityCreatePortalEvent extends listener {
    void onEntityCreatePortalEvent(onEntityCreatePortalEvent event);

    class onEntityCreatePortalEvent extends cancelEvent<OnEntityCreatePortalEvent> {
        private final EntityCreatePortalEvent event;

        public onEntityCreatePortalEvent(EntityCreatePortalEvent event) {
            this.event = event;
        }

        public EntityCreatePortalEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityCreatePortalEvent> listeners) {
            for (OnEntityCreatePortalEvent listener : listeners) {
                listener.onEntityCreatePortalEvent(this);
            }
        }

        @Override
        public Class<OnEntityCreatePortalEvent> getListenerType() {
            return OnEntityCreatePortalEvent.class;
        }
    }
}