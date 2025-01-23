package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.ItemDespawnEvent;

import java.util.ArrayList;

public interface OnItemDespawnEvent extends listener {
    void onItemDespawnEvent(onItemDespawnEvent event);

    class onItemDespawnEvent extends cancelEvent<OnItemDespawnEvent> {
        private final ItemDespawnEvent event;

        public onItemDespawnEvent(ItemDespawnEvent event) {
            this.event = event;
        }

        public ItemDespawnEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnItemDespawnEvent> listeners) {
            for (OnItemDespawnEvent listener : listeners) {
                listener.onItemDespawnEvent(this);
            }
        }

        @Override
        public Class<OnItemDespawnEvent> getListenerType() {
            return OnItemDespawnEvent.class;
        }
    }
}