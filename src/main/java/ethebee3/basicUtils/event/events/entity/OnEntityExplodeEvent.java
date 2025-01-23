package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;

public interface OnEntityExplodeEvent extends listener {
    void onEntityExplodeEvent(onEntityExplodeEvent event);

    class onEntityExplodeEvent extends cancelEvent<OnEntityExplodeEvent> {
        private final EntityExplodeEvent event;

        public onEntityExplodeEvent(EntityExplodeEvent event) {
            this.event = event;
        }

        public EntityExplodeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityExplodeEvent> listeners) {
            for (OnEntityExplodeEvent listener : listeners) {
                listener.onEntityExplodeEvent(this);
            }
        }

        @Override
        public Class<OnEntityExplodeEvent> getListenerType() {
            return OnEntityExplodeEvent.class;
        }
    }
}
