package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

public interface OnPlayerDeathEvent extends listener {
    void onPlayerDeathEvent(onPlayerDeathEvent event);

    class onPlayerDeathEvent extends cancelEvent<OnPlayerDeathEvent> {
        private final PlayerDeathEvent event;

        public onPlayerDeathEvent(PlayerDeathEvent event) {
            this.event = event;
        }

        public PlayerDeathEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPlayerDeathEvent> listeners) {
            for (OnPlayerDeathEvent listener : listeners) {
                listener.onPlayerDeathEvent(this);
            }
        }

        @Override
        public Class<OnPlayerDeathEvent> getListenerType() {
            return OnPlayerDeathEvent.class;
        }
    }
}