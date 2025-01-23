package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;

import java.util.ArrayList;

public interface OnEntityDamageByBlockEvent extends listener {
    void onEntityDamageByBlockEvent(onEntityDamageByBlockEvent event);

    class onEntityDamageByBlockEvent extends cancelEvent<OnEntityDamageByBlockEvent> {
        private final EntityDamageByBlockEvent event;

        public onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {
            this.event = event;
        }

        public EntityDamageByBlockEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityDamageByBlockEvent> listeners) {
            for (OnEntityDamageByBlockEvent listener : listeners) {
                listener.onEntityDamageByBlockEvent(this);
            }
        }

        @Override
        public Class<OnEntityDamageByBlockEvent> getListenerType() {
            return OnEntityDamageByBlockEvent.class;
        }
    }
}