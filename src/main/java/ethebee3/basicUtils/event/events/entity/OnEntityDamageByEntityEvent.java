package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;

public interface OnEntityDamageByEntityEvent extends listener {
    void onEntityDamageByEntityEvent(onEntityDamageByEntityEvent event);

    class onEntityDamageByEntityEvent extends cancelEvent<OnEntityDamageByEntityEvent> {
        private final EntityDamageByEntityEvent event;

        public onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
            this.event = event;
        }

        public EntityDamageByEntityEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityDamageByEntityEvent> listeners) {
            for (OnEntityDamageByEntityEvent listener : listeners) {
                listener.onEntityDamageByEntityEvent(this);
            }
        }

        @Override
        public Class<OnEntityDamageByEntityEvent> getListenerType() {
            return OnEntityDamageByEntityEvent.class;
        }
    }
}