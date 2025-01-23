package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.ArrayList;

public interface OnPlayerPickupItemEvent extends listener {
    void onPlayerPickupItemEvent(OnPlayerPickupItemEvent.onPlayerPickupItemEvent event);

    class onPlayerPickupItemEvent extends cancelEvent<OnPlayerPickupItemEvent> {
        private final PlayerPickupItemEvent event;

        public onPlayerPickupItemEvent(PlayerPickupItemEvent event) {
            this.event = event;
        }

        public PlayerPickupItemEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerPickupItemEvent> listeners) {
            for (OnPlayerPickupItemEvent listener : listeners) {
                listener.onPlayerPickupItemEvent(this);
            }
        }

        @Override
        public Class<OnPlayerPickupItemEvent> getListenerType() {
            return OnPlayerPickupItemEvent.class;
        }
    }
}