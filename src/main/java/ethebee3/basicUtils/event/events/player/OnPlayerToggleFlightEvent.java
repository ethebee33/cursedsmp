package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.ArrayList;

public interface OnPlayerToggleFlightEvent extends listener {
    void onPlayerToggleFlightEvent(OnPlayerToggleFlightEvent.onPlayerToggleFlightEvent event);

    class onPlayerToggleFlightEvent extends cancelEvent<OnPlayerToggleFlightEvent> {
        private final PlayerToggleFlightEvent event;

        public onPlayerToggleFlightEvent(PlayerToggleFlightEvent event) {
            this.event = event;
        }

        public PlayerToggleFlightEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerToggleFlightEvent> listeners) {
            for (OnPlayerToggleFlightEvent listener : listeners) {
                listener.onPlayerToggleFlightEvent(this);
            }
        }

        @Override
        public Class<OnPlayerToggleFlightEvent> getListenerType() {
            return OnPlayerToggleFlightEvent.class;
        }
    }
}