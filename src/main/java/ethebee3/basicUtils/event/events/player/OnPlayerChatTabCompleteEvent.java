package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

import java.util.ArrayList;

public interface OnPlayerChatTabCompleteEvent extends listener {
    void onPlayerChatTabCompleteEvent(OnPlayerChatTabCompleteEvent.onPlayerChatTabCompleteEvent event);

    class onPlayerChatTabCompleteEvent extends cancelEvent<OnPlayerChatTabCompleteEvent> {
        private final PlayerChatTabCompleteEvent event;

        public onPlayerChatTabCompleteEvent(PlayerChatTabCompleteEvent event) {
            this.event = event;
        }

        public PlayerChatTabCompleteEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerChatTabCompleteEvent> listeners) {
            for (OnPlayerChatTabCompleteEvent listener : listeners) {
                listener.onPlayerChatTabCompleteEvent(this);
            }
        }

        @Override
        public Class<OnPlayerChatTabCompleteEvent> getListenerType() {
            return OnPlayerChatTabCompleteEvent.class;
        }
    }
}
