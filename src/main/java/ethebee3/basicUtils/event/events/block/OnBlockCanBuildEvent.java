package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockCanBuildEvent;

import java.util.ArrayList;

public interface OnBlockCanBuildEvent extends listener {
    void onBlockCanBuildEvent(onBlockCanBuildEvent event);

    class onBlockCanBuildEvent extends cancelEvent<OnBlockCanBuildEvent> {
        private final BlockCanBuildEvent event;

        public onBlockCanBuildEvent(BlockCanBuildEvent event) {
            this.event = event;
        }

        public BlockCanBuildEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockCanBuildEvent> listeners) {
            for (OnBlockCanBuildEvent listener : listeners) {
                listener.onBlockCanBuildEvent(this);
            }
        }

        @Override
        public Class<OnBlockCanBuildEvent> getListenerType() {
            return OnBlockCanBuildEvent.class;
        }
    }
}