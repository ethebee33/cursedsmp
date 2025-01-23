package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.ArrayList;

public interface OnEntityShootBowEvent extends listener {
    void onEntityShootBowEvent(onEntityShootBowEvent event);

    class onEntityShootBowEvent extends cancelEvent<OnEntityShootBowEvent> {
        private final EntityShootBowEvent event;

        public onEntityShootBowEvent(EntityShootBowEvent event) {
            this.event = event;
        }

        public EntityShootBowEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityShootBowEvent> listeners) {
            for (OnEntityShootBowEvent listener : listeners) {
                listener.onEntityShootBowEvent(this);
            }
        }

        @Override
        public Class<OnEntityShootBowEvent> getListenerType() {
            return OnEntityShootBowEvent.class;
        }
    }
}
