package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerKickEvent;

import java.util.ArrayList;

public interface OnPlayerKickEvent extends listener {
    void onPlayerKickEvent(OnPlayerKickEvent.onPlayerKickEvent event);

    class onPlayerKickEvent extends cancelEvent<OnPlayerKickEvent> {
        private final PlayerKickEvent event;

        public onPlayerKickEvent(PlayerKickEvent event) {
            this.event = event;
        }

        public PlayerKickEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerKickEvent> listeners) {
            for (OnPlayerKickEvent listener : listeners) {
                listener.onPlayerKickEvent(this);
            }
        }

        @Override
        public Class<OnPlayerKickEvent> getListenerType() {
            return OnPlayerKickEvent.class;
        }
    }
}
