package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.ArrayList;

public interface OnEntityTargetEvent extends listener {
    void onEntityTargetEvent(onEntityTargetEvent event);

    class onEntityTargetEvent extends cancelEvent<OnEntityTargetEvent> {
        private final EntityTargetEvent event;

        public onEntityTargetEvent(EntityTargetEvent event) {
            this.event = event;
        }

        public EntityTargetEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityTargetEvent> listeners) {
            for (OnEntityTargetEvent listener : listeners) {
                listener.onEntityTargetEvent(this);
            }
        }

        @Override
        public Class<OnEntityTargetEvent> getListenerType() {
            return OnEntityTargetEvent.class;
        }
    }
}