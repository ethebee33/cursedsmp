package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockRedstoneEvent;

import java.util.ArrayList;

public interface OnBlockRedstoneEvent extends listener {
    void onBlockRedstoneEvent(onBlockRedstoneEvent event);

    class onBlockRedstoneEvent extends cancelEvent<OnBlockRedstoneEvent> {
        private final BlockRedstoneEvent event;

        public onBlockRedstoneEvent(BlockRedstoneEvent event) {
            this.event = event;
        }

        public BlockRedstoneEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockRedstoneEvent> listeners) {
            for (OnBlockRedstoneEvent listener : listeners) {
                listener.onBlockRedstoneEvent(this);
            }
        }

        @Override
        public Class<OnBlockRedstoneEvent> getListenerType() {
            return OnBlockRedstoneEvent.class;
        }
    }
}