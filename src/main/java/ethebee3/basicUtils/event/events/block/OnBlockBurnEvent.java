package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;

import java.util.ArrayList;

public interface OnBlockBurnEvent extends listener {
    void onBlockBurnEvent(onBlockBurnEvent event);

    class onBlockBurnEvent extends cancelEvent<OnBlockBurnEvent> {
        private final BlockBurnEvent event;

        public onBlockBurnEvent(BlockBurnEvent event) {
            this.event = event;
        }

        public BlockBurnEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockBurnEvent> listeners) {
            for (OnBlockBurnEvent listener : listeners) {
                listener.onBlockBurnEvent(this);
            }
        }

        @Override
        public Class<OnBlockBurnEvent> getListenerType() {
            return OnBlockBurnEvent.class;
        }
    }
}
