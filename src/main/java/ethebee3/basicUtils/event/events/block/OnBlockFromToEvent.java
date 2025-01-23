package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockFromToEvent;

import java.util.ArrayList;

public interface OnBlockFromToEvent extends listener {
    void onBlockFromToEvent(onBlockFromToEvent event);

    class onBlockFromToEvent extends cancelEvent<OnBlockFromToEvent> {
        private final BlockFromToEvent event;

        public onBlockFromToEvent(BlockFromToEvent event) {
            this.event = event;
        }

        public BlockFromToEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockFromToEvent> listeners) {
            for (OnBlockFromToEvent listener : listeners) {
                listener.onBlockFromToEvent(this);
            }
        }

        @Override
        public Class<OnBlockFromToEvent> getListenerType() {
            return OnBlockFromToEvent.class;
        }
    }
}