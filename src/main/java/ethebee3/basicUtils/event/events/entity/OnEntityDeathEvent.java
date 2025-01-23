package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;

public interface OnEntityDeathEvent extends listener {
    void onEntityDeathEvent(onEntityDeathEvent event);

    class onEntityDeathEvent extends cancelEvent<OnEntityDeathEvent> {
        private final EntityDeathEvent event;

        public onEntityDeathEvent(EntityDeathEvent event) {
            this.event = event;
        }

        public EntityDeathEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityDeathEvent> listeners) {
            for (OnEntityDeathEvent listener : listeners) {
                listener.onEntityDeathEvent(this);
            }
        }

        @Override
        public Class<OnEntityDeathEvent> getListenerType() {
            return OnEntityDeathEvent.class;
        }
    }
}
