package ethebee3.basicUtils.event.eventInit.events;

import ethebee3.basicUtils.event.events.eventManager;
import ethebee3.basicUtils.event.events.block.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

public class block implements Listener {

    public block() {}

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        OnBlockBreakEvent.onBlockBreakEvent event2 = new OnBlockBreakEvent.onBlockBreakEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockBurnEvent(BlockBurnEvent event) {
        OnBlockBurnEvent.onBlockBurnEvent event2 = new OnBlockBurnEvent.onBlockBurnEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        OnBlockCanBuildEvent.onBlockCanBuildEvent event2 = new OnBlockCanBuildEvent.onBlockCanBuildEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event) {
        OnBlockDamageEvent.onBlockDamageEvent event2 = new OnBlockDamageEvent.onBlockDamageEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent event) {
        OnBlockDispenseEvent.onBlockDispenseEvent event2 = new OnBlockDispenseEvent.onBlockDispenseEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockEvent(BlockEvent event) {
        OnBlockEvent.onBlockEvent event2 = new OnBlockEvent.onBlockEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent event) {
        OnBlockFadeEvent.onBlockFadeEvent event2 = new OnBlockFadeEvent.onBlockFadeEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockFormEvent(BlockFormEvent event) {
        OnBlockFormEvent.onBlockFormEvent event2 = new OnBlockFormEvent.onBlockFormEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockFromToEvent(BlockFromToEvent event) {
        OnBlockFromToEvent.onBlockFromToEvent event2 = new OnBlockFromToEvent.onBlockFromToEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockGrowEvent(BlockGrowEvent event) {
        OnBlockGrowEvent.onBlockGrowEvent event2 = new OnBlockGrowEvent.onBlockGrowEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockIgniteEvent(BlockIgniteEvent event) {
        OnBlockIgniteEvent.onBlockIgniteEvent event2 = new OnBlockIgniteEvent.onBlockIgniteEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
        OnBlockPhysicsEvent.onBlockPhysicsEvent event2 = new OnBlockPhysicsEvent.onBlockPhysicsEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        OnBlockPlaceEvent.onBlockPlaceEvent event2 = new OnBlockPlaceEvent.onBlockPlaceEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
        OnBlockRedstoneEvent.onBlockRedstoneEvent event2 = new OnBlockRedstoneEvent.onBlockRedstoneEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onSignChangeEvent(SignChangeEvent event) {
        OnSignChangeEvent.onSignChangeEvent event2 = new OnSignChangeEvent.onSignChangeEvent(event);
        eventManager.fire(event2);
    }
}
