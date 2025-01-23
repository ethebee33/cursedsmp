package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;

public interface OnPlayerInteractEntityEvent extends listener {
    void onPlayerInteractEntityEvent(OnPlayerInteractEntityEvent.onPlayerInteractEntityEvent event);

    class onPlayerInteractEntityEvent extends cancelEvent<OnPlayerInteractEntityEvent> {
        private final PlayerInteractEntityEvent event;

        public onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
            this.event = event;
        }

        public PlayerInteractEntityEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerInteractEntityEvent> listeners) {
            for (OnPlayerInteractEntityEvent listener : listeners) {
                listener.onPlayerInteractEntityEvent(this);
            }
        }

        @Override
        public Class<OnPlayerInteractEntityEvent> getListenerType() {
            return OnPlayerInteractEntityEvent.class;
        }
    }
}