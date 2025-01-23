package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockDamageEvent;

import java.util.ArrayList;

public interface OnBlockDamageEvent extends listener {
    void onBlockDamageEvent(onBlockDamageEvent event);

    class onBlockDamageEvent extends cancelEvent<OnBlockDamageEvent> {
        private final BlockDamageEvent event;

        public onBlockDamageEvent(BlockDamageEvent event) {
            this.event = event;
        }

        public BlockDamageEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockDamageEvent> listeners) {
            for (OnBlockDamageEvent listener : listeners) {
                listener.onBlockDamageEvent(this);
            }
        }

        @Override
        public Class<OnBlockDamageEvent> getListenerType() {
            return OnBlockDamageEvent.class;
        }
    }
}
