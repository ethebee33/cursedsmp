package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityCombustEvent;

import java.util.ArrayList;

public interface OnEntityCombustEvent extends listener {
    void onEntityCombustEvent(onEntityCombustEvent event);

    class onEntityCombustEvent extends cancelEvent<OnEntityCombustEvent> {
        private final EntityCombustEvent event;

        public onEntityCombustEvent(EntityCombustEvent event) {
            this.event = event;
        }

        public EntityCombustEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityCombustEvent> listeners) {
            for (OnEntityCombustEvent listener : listeners) {
                listener.onEntityCombustEvent(this);
            }
        }

        @Override
        public Class<OnEntityCombustEvent> getListenerType() {
            return OnEntityCombustEvent.class;
        }
    }
}