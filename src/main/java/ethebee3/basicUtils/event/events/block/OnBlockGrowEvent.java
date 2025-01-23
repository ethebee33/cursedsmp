package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockGrowEvent;

import java.util.ArrayList;

public interface OnBlockGrowEvent extends listener {
    void onBlockGrowEvent(onBlockGrowEvent event);

    class onBlockGrowEvent extends cancelEvent<OnBlockGrowEvent> {
        private final BlockGrowEvent event;

        public onBlockGrowEvent(BlockGrowEvent event) {
            this.event = event;
        }

        public BlockGrowEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockGrowEvent> listeners) {
            for (OnBlockGrowEvent listener : listeners) {
                listener.onBlockGrowEvent(this);
            }
        }

        @Override
        public Class<OnBlockGrowEvent> getListenerType() {
            return OnBlockGrowEvent.class;
        }
    }
}