package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.PotionSplashEvent;

import java.util.ArrayList;

public interface OnPotionSplashEvent extends listener {
    void onPotionSplashEvent(onPotionSplashEvent event);

    class onPotionSplashEvent extends cancelEvent<OnPotionSplashEvent> {
        private final PotionSplashEvent event;

        public onPotionSplashEvent(PotionSplashEvent event) {
            this.event = event;
        }

        public PotionSplashEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnPotionSplashEvent> listeners) {
            for (OnPotionSplashEvent listener : listeners) {
                listener.onPotionSplashEvent(this);
            }
        }

        @Override
        public Class<OnPotionSplashEvent> getListenerType() {
            return OnPotionSplashEvent.class;
        }
    }
}
