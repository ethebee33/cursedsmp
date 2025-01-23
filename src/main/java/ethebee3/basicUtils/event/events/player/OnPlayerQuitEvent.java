package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public interface OnPlayerQuitEvent extends listener {
    void onPlayerQuitEvent(OnPlayerQuitEvent.onPlayerQuitEvent event);

    class onPlayerQuitEvent extends cancelEvent<OnPlayerQuitEvent> {
        private final PlayerQuitEvent event;

        public onPlayerQuitEvent(PlayerQuitEvent event) {
            this.event = event;
        }

        public PlayerQuitEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerQuitEvent> listeners) {
            for (OnPlayerQuitEvent listener : listeners) {
                listener.onPlayerQuitEvent(this);
            }
        }

        @Override
        public Class<OnPlayerQuitEvent> getListenerType() {
            return OnPlayerQuitEvent.class;
        }
    }
}