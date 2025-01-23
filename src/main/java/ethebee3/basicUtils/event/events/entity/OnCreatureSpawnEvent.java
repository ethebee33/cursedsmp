package ethebee3.basicUtils.event.events.entity;

import ethebee3.basicUtils.event.cancelEvent;
import ethebee3.basicUtils.event.listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.ArrayList;

public interface OnCreatureSpawnEvent extends listener {
    void onCreatureSpawnEvent(onCreatureSpawnEvent event);

    class onCreatureSpawnEvent extends cancelEvent<OnCreatureSpawnEvent> {
        private final CreatureSpawnEvent event;

        public onCreatureSpawnEvent(CreatureSpawnEvent event) {
            this.event = event;
        }

        public CreatureSpawnEvent getEvent() {
            return event;
        }

        @Override
        public void fire(ArrayList<OnCreatureSpawnEvent> listeners) {
            for (OnCreatureSpawnEvent listener : listeners) {
                listener.onCreatureSpawnEvent(this);
            }
        }

        @Override
        public Class<OnCreatureSpawnEvent> getListenerType() {
            return OnCreatureSpawnEvent.class;
        }
    }
}
/*
BlockBreakEvent
BlockBurnEvent
BlockCanBuild
BlockDamageEvent
BlockDispenseEvent
BlockEvent
BlockFadeEvent
BlockFormEvent
BlockFromToEvent
BlockGrowEvent
BlockIgniteEvent
BlockPhysicsEvent
BlockPlaceEvent
BlockRedstoneEvent
SignChangeEvent
 */