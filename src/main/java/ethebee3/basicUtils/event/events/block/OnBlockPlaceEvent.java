package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public interface OnBlockPlaceEvent extends listener {
    void onBlockPlaceEvent(onBlockPlaceEvent event);

    class onBlockPlaceEvent extends cancelEvent<OnBlockPlaceEvent> {
        private final BlockPlaceEvent event;

        public onBlockPlaceEvent(BlockPlaceEvent event) {
            this.event = event;
        }

        public BlockPlaceEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockPlaceEvent> listeners) {
            for (OnBlockPlaceEvent listener : listeners) {
                listener.onBlockPlaceEvent(this);
            }
        }

        @Override
        public Class<OnBlockPlaceEvent> getListenerType() {
            return OnBlockPlaceEvent.class;
        }
    }
}