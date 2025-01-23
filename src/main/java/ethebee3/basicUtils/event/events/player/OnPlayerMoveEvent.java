package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public interface OnPlayerMoveEvent extends listener {
    void onPlayerMoveEvent(OnPlayerMoveEvent.onPlayerMoveEvent event);

    class onPlayerMoveEvent extends cancelEvent<OnPlayerMoveEvent> {
        private final PlayerMoveEvent event;

        public onPlayerMoveEvent(PlayerMoveEvent event) {
            this.event = event;
        }

        public PlayerMoveEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerMoveEvent> listeners) {
            for (OnPlayerMoveEvent listener : listeners) {
                listener.onPlayerMoveEvent(this);
            }
        }

        @Override
        public Class<OnPlayerMoveEvent> getListenerType() {
            return OnPlayerMoveEvent.class;
        }
    }
}