package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockIgniteEvent;

import java.util.ArrayList;

public interface OnBlockIgniteEvent extends listener {
    void onBlockIgniteEvent(onBlockIgniteEvent event);

    class onBlockIgniteEvent extends cancelEvent<OnBlockIgniteEvent> {
        private final BlockIgniteEvent event;

        public onBlockIgniteEvent(BlockIgniteEvent event) {
            this.event = event;
        }

        public BlockIgniteEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockIgniteEvent> listeners) {
            for (OnBlockIgniteEvent listener : listeners) {
                listener.onBlockIgniteEvent(this);
            }
        }

        @Override
        public Class<OnBlockIgniteEvent> getListenerType() {
            return OnBlockIgniteEvent.class;
        }
    }
}
