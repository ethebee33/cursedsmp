package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.ArrayList;

public interface OnFoodLevelChangeEvent extends listener {
    void onFoodLevelChangeEvent(onFoodLevelChangeEvent event);

    class onFoodLevelChangeEvent extends cancelEvent<OnFoodLevelChangeEvent> {
        private final FoodLevelChangeEvent event;

        public onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
            this.event = event;
        }

        public FoodLevelChangeEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnFoodLevelChangeEvent> listeners) {
            for (OnFoodLevelChangeEvent listener : listeners) {
                listener.onFoodLevelChangeEvent(this);
            }
        }

        @Override
        public Class<OnFoodLevelChangeEvent> getListenerType() {
            return OnFoodLevelChangeEvent.class;
        }
    }
}