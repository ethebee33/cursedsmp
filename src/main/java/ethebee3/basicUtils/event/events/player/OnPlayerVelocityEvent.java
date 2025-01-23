package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerVelocityEvent;

import java.util.ArrayList;

public interface OnPlayerVelocityEvent extends listener {
    void onPlayerVelocityEvent(onPlayerVelocityEvent event);

    class onPlayerVelocityEvent extends cancelEvent<OnPlayerVelocityEvent> {
        private final PlayerVelocityEvent event;

        public onPlayerVelocityEvent(PlayerVelocityEvent event) {
            this.event = event;
        }

        public PlayerVelocityEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerVelocityEvent> listeners) {
            for (OnPlayerVelocityEvent listener : listeners) {
                listener.onPlayerVelocityEvent(this);
            }
        }

        @Override
        public Class<OnPlayerVelocityEvent> getListenerType() {
            return OnPlayerVelocityEvent.class;
        }
    }
}