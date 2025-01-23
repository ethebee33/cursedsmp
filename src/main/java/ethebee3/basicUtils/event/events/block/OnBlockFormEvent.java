package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockFormEvent;

import java.util.ArrayList;

public interface OnBlockFormEvent extends listener {
    void onBlockFormEvent(onBlockFormEvent event);

    class onBlockFormEvent extends cancelEvent<OnBlockFormEvent> {
        private final BlockFormEvent event;

        public onBlockFormEvent(BlockFormEvent event) {
            this.event = event;
        }

        public BlockFormEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockFormEvent> listeners) {
            for (OnBlockFormEvent listener : listeners) {
                listener.onBlockFormEvent(this);
            }
        }

        @Override
        public Class<OnBlockFormEvent> getListenerType() {
            return OnBlockFormEvent.class;
        }
    }
}