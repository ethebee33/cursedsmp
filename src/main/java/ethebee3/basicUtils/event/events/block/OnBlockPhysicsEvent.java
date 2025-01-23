package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.BlockPhysicsEvent;

import java.util.ArrayList;

public interface OnBlockPhysicsEvent extends listener {
    void onBlockPhysicsEvent(onBlockPhysicsEvent event);

    class onBlockPhysicsEvent extends cancelEvent<OnBlockPhysicsEvent> {
        private final BlockPhysicsEvent event;

        public onBlockPhysicsEvent(BlockPhysicsEvent event) {
            this.event = event;
        }

        public BlockPhysicsEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnBlockPhysicsEvent> listeners) {
            for (OnBlockPhysicsEvent listener : listeners) {
                listener.onBlockPhysicsEvent(this);
            }
        }

        @Override
        public Class<OnBlockPhysicsEvent> getListenerType() {
            return OnBlockPhysicsEvent.class;
        }
    }
}