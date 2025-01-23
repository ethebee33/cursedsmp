package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public interface OnPlayerJoinEvent extends listener {
    void onPlayerJoinEvent(OnPlayerJoinEvent.onPlayerJoinEvent event);

    class onPlayerJoinEvent extends cancelEvent<OnPlayerJoinEvent> {
        private final PlayerJoinEvent event;

        public onPlayerJoinEvent(PlayerJoinEvent event) {
            this.event = event;
        }

        public PlayerJoinEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerJoinEvent> listeners) {
            for (OnPlayerJoinEvent listener : listeners) {
                listener.onPlayerJoinEvent(this);
            }
        }

        @Override
        public Class<OnPlayerJoinEvent> getListenerType() {
            return OnPlayerJoinEvent.class;
        }
    }
}