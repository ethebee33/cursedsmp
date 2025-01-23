package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import java.util.ArrayList;

public interface OnExplosionPrimeEvent extends listener {
    void onExplosionPrimeEvent(onExplosionPrimeEvent event);

    class onExplosionPrimeEvent extends cancelEvent<OnExplosionPrimeEvent> {
        private final ExplosionPrimeEvent event;

        public onExplosionPrimeEvent(ExplosionPrimeEvent event) {
            this.event = event;
        }

        public ExplosionPrimeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnExplosionPrimeEvent> listeners) {
            for (OnExplosionPrimeEvent listener : listeners) {
                listener.onExplosionPrimeEvent(this);
            }
        }

        @Override
        public Class<OnExplosionPrimeEvent> getListenerType() {
            return OnExplosionPrimeEvent.class;
        }
    }
}