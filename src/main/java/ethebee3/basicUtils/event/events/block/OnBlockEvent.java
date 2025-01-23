package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockEvent;

import java.util.ArrayList;

public interface OnBlockEvent extends listener {
    void onBlockEvent(onBlockEvent event);

    class onBlockEvent extends cancelEvent<OnBlockEvent> {
        private final BlockEvent event;

        public onBlockEvent(BlockEvent event) {
            this.event = event;
        }

        public BlockEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockEvent> listeners) {
            for (OnBlockEvent listener : listeners) {
                listener.onBlockEvent(this);
            }
        }

        @Override
        public Class<OnBlockEvent> getListenerType() {
            return OnBlockEvent.class;
        }
    }
}