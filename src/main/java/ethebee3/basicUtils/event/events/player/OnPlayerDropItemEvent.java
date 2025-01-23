package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.ArrayList;

public interface OnPlayerDropItemEvent extends listener {
    void onPlayerDropItemEvent(OnPlayerDropItemEvent.onPlayerDropItemEvent event);

    class onPlayerDropItemEvent extends cancelEvent<OnPlayerDropItemEvent> {
        private final PlayerDropItemEvent event;

        public onPlayerDropItemEvent(PlayerDropItemEvent event) {
            this.event = event;
        }

        public PlayerDropItemEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerDropItemEvent> listeners) {
            for (OnPlayerDropItemEvent listener : listeners) {
                listener.onPlayerDropItemEvent(this);
            }
        }

        @Override
        public Class<OnPlayerDropItemEvent> getListenerType() {
            return OnPlayerDropItemEvent.class;
        }
    }
}