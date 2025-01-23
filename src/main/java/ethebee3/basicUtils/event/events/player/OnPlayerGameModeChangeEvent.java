package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import java.util.ArrayList;

public interface OnPlayerGameModeChangeEvent extends listener {
    void onPlayerGameModeChangeEvent(OnPlayerGameModeChangeEvent.onPlayerGameModeChangeEvent event);

    class onPlayerGameModeChangeEvent extends cancelEvent<OnPlayerGameModeChangeEvent> {
        private final PlayerGameModeChangeEvent event;

        public onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event) {
            this.event = event;
        }

        public PlayerGameModeChangeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerGameModeChangeEvent> listeners) {
            for (OnPlayerGameModeChangeEvent listener : listeners) {
                listener.onPlayerGameModeChangeEvent(this);
            }
        }

        @Override
        public Class<OnPlayerGameModeChangeEvent> getListenerType() {
            return OnPlayerGameModeChangeEvent.class;
        }
    }
}