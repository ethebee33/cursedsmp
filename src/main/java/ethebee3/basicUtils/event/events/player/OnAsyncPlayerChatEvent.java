package ethebee3.basicUtils.event.events.player;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public interface OnAsyncPlayerChatEvent extends listener {
    void onAsyncPlayerChatEvent(onAsyncPlayerChatEvent event);

    class onAsyncPlayerChatEvent extends cancelEvent<OnAsyncPlayerChatEvent>
    {
        private final AsyncPlayerChatEvent event;

        public onAsyncPlayerChatEvent(AsyncPlayerChatEvent event)
        {
            this.event = event;
        }

        public AsyncPlayerChatEvent getPlayer()
        {
            return event;
        }

        @Override
        public void fire(ArrayList<OnAsyncPlayerChatEvent> listeners)
        {
            for (OnAsyncPlayerChatEvent listener : listeners)
            {
                listener.onAsyncPlayerChatEvent(this);
            }
        }

        @Override
        public Class<OnAsyncPlayerChatEvent> getListenerType()
        {
            return OnAsyncPlayerChatEvent.class;
        }
    }
}
