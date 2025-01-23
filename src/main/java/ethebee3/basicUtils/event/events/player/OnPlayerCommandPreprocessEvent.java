package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public interface OnPlayerCommandPreprocessEvent extends listener {
    void onPlayerCommandPreprocessEvent(OnPlayerCommandPreprocessEvent.onPlayerCommandPreprocessEvent event);

    class onPlayerCommandPreprocessEvent extends cancelEvent<OnPlayerCommandPreprocessEvent> {
        private final PlayerCommandPreprocessEvent event;

        public onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
            this.event = event;
        }

        public PlayerCommandPreprocessEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerCommandPreprocessEvent> listeners) {
            for (OnPlayerCommandPreprocessEvent listener : listeners) {
                listener.onPlayerCommandPreprocessEvent(this);
            }
        }

        @Override
        public Class<OnPlayerCommandPreprocessEvent> getListenerType() {
            return OnPlayerCommandPreprocessEvent.class;
        }
    }
}