package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockFadeEvent;

import java.util.ArrayList;

public interface OnBlockFadeEvent extends listener {
    void onBlockFadeEvent(onBlockFadeEvent event);

    class onBlockFadeEvent extends cancelEvent<OnBlockFadeEvent> {
        private final BlockFadeEvent event;

        public onBlockFadeEvent(BlockFadeEvent event) {
            this.event = event;
        }

        public BlockFadeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockFadeEvent> listeners) {
            for (OnBlockFadeEvent listener : listeners) {
                listener.onBlockFadeEvent(this);
            }
        }

        @Override
        public Class<OnBlockFadeEvent> getListenerType() {
            return OnBlockFadeEvent.class;
        }
    }
}