package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public interface OnPlayerInteractEvent extends listener {
    void onPlayerInteractEvent(OnPlayerInteractEvent.onPlayerInteractEvent event);

    class onPlayerInteractEvent extends cancelEvent<OnPlayerInteractEvent> {
        private final PlayerInteractEvent event;

        public onPlayerInteractEvent(PlayerInteractEvent event) {
            this.event = event;
        }

        public PlayerInteractEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerInteractEvent> listeners) {
            for (OnPlayerInteractEvent listener : listeners) {
                listener.onPlayerInteractEvent(this);
            }
        }

        @Override
        public Class<OnPlayerInteractEvent> getListenerType() {
            return OnPlayerInteractEvent.class;
        }
    }
}