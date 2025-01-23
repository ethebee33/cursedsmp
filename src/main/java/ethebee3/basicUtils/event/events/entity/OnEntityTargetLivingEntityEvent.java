package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.util.ArrayList;

public interface OnEntityTargetLivingEntityEvent extends listener {
    void onEntityTargetLivingEntityEvent(onEntityTargetLivingEntityEvent event);

    class onEntityTargetLivingEntityEvent extends cancelEvent<OnEntityTargetLivingEntityEvent> {
        private final EntityTargetLivingEntityEvent event;

        public onEntityTargetLivingEntityEvent(EntityTargetLivingEntityEvent event) {
            this.event = event;
        }

        public EntityTargetLivingEntityEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnEntityTargetLivingEntityEvent> listeners) {
            for (OnEntityTargetLivingEntityEvent listener : listeners) {
                listener.onEntityTargetLivingEntityEvent(this);
            }
        }

        @Override
        public Class<OnEntityTargetLivingEntityEvent> getListenerType() {
            return OnEntityTargetLivingEntityEvent.class;
        }
    }
}