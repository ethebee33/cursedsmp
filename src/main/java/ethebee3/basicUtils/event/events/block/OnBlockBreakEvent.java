package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;

public interface OnBlockBreakEvent extends listener {
    void onBlockBreakEvent(onBlockBreakEvent event);

    class onBlockBreakEvent extends cancelEvent<OnBlockBreakEvent> {
        private final BlockBreakEvent event;

        public onBlockBreakEvent(BlockBreakEvent event) {
            this.event = event;
        }

        public BlockBreakEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockBreakEvent> listeners) {
            for (OnBlockBreakEvent listener : listeners) {
                listener.onBlockBreakEvent(this);
            }
        }

        @Override
        public Class<OnBlockBreakEvent> getListenerType() {
            return OnBlockBreakEvent.class;
        }
    }
}
