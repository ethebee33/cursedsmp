package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockDispenseEvent;

import java.util.ArrayList;

public interface OnBlockDispenseEvent extends listener {
    void onBlockDispenseEvent(onBlockDispenseEvent event);

    class onBlockDispenseEvent extends cancelEvent<OnBlockDispenseEvent> {
        private final BlockDispenseEvent event;

        public onBlockDispenseEvent(BlockDispenseEvent event) {
            this.event = event;
        }

        public BlockDispenseEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockDispenseEvent> listeners) {
            for (OnBlockDispenseEvent listener : listeners) {
                listener.onBlockDispenseEvent(this);
            }
        }

        @Override
        public Class<OnBlockDispenseEvent> getListenerType() {
            return OnBlockDispenseEvent.class;
        }
    }
}