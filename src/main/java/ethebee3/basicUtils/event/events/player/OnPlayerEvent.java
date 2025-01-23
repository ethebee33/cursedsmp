package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerEvent;

import java.util.ArrayList;

public interface OnPlayerEvent extends listener {
    void onPlayerEvent(OnPlayerEvent.onPlayerEvent event);

    class onPlayerEvent extends cancelEvent<OnPlayerEvent> {
        private final PlayerEvent event;

        public onPlayerEvent(PlayerEvent event) {
            this.event = event;
        }

        public PlayerEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerEvent> listeners) {
            for (OnPlayerEvent listener : listeners) {
                listener.onPlayerEvent(this);
            }
        }

        @Override
        public Class<OnPlayerEvent> getListenerType() {
            return OnPlayerEvent.class;
        }
    }
}