package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import java.util.ArrayList;

public interface OnPlayerLevelChangeEvent extends listener {
    void onPlayerLevelChangeEvent(OnPlayerLevelChangeEvent.onPlayerLevelChangeEvent event);

    class onPlayerLevelChangeEvent extends cancelEvent<OnPlayerLevelChangeEvent> {
        private final PlayerLevelChangeEvent event;

        public onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {
            this.event = event;
        }

        public PlayerLevelChangeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerLevelChangeEvent> listeners) {
            for (OnPlayerLevelChangeEvent listener : listeners) {
                listener.onPlayerLevelChangeEvent(this);
            }
        }

        @Override
        public Class<OnPlayerLevelChangeEvent> getListenerType() {
            return OnPlayerLevelChangeEvent.class;
        }
    }
}
