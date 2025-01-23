package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public interface OnEntityDamageEvent extends listener {
    void onEntityDamageEvent(onEntityDamageEvent event);

    class onEntityDamageEvent extends cancelEvent<OnEntityDamageEvent> {
        private final EntityDamageEvent event;

        public onEntityDamageEvent(EntityDamageEvent event) {
            this.event = event;
        }

        public EntityDamageEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityDamageEvent> listeners) {
            for (OnEntityDamageEvent listener : listeners) {
                listener.onEntityDamageEvent(this);
            }
        }

        @Override
        public Class<OnEntityDamageEvent> getListenerType() {
            return OnEntityDamageEvent.class;
        }
    }
}