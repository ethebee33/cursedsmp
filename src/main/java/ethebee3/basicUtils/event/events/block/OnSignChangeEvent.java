package ethebee3.basicUtils.event.events.block;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.block.SignChangeEvent;

import java.util.ArrayList;

public interface OnSignChangeEvent extends listener {
    void onSignChangeEvent(onSignChangeEvent event);

    class onSignChangeEvent extends cancelEvent<OnSignChangeEvent> {
        private final SignChangeEvent event;

        public onSignChangeEvent(SignChangeEvent event) {
            this.event = event;
        }

        public SignChangeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnSignChangeEvent> listeners) {
            for (OnSignChangeEvent listener : listeners) {
                listener.onSignChangeEvent(this);
            }
        }

        @Override
        public Class<OnSignChangeEvent> getListenerType() {
            return OnSignChangeEvent.class;
        }
    }
}