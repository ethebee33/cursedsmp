package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public interface OnPlayerItemHeldEvent extends listener {
    void onPlayerItemHeldEvent(OnPlayerItemHeldEvent.onPlayerItemHeldEvent event);

    class onPlayerItemHeldEvent extends cancelEvent<OnPlayerItemHeldEvent> {
        private final PlayerItemHeldEvent event;

        public onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
            this.event = event;
        }

        public PlayerItemHeldEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerItemHeldEvent> listeners) {
            for (OnPlayerItemHeldEvent listener : listeners) {
                listener.onPlayerItemHeldEvent(this);
            }
        }

        @Override
        public Class<OnPlayerItemHeldEvent> getListenerType() {
            return OnPlayerItemHeldEvent.class;
        }
    }
}