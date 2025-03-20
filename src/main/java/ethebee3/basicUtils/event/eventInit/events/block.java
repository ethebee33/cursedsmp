package ethebee3.basicUtils.event.eventInit.events;

import ethebee3.basicUtils.event.events.block.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

import static ethebee3.basicUtils.Main2.getEventManager;

public class block implements Listener {

    public block() {}

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        OnBlockBreakEvent.onBlockBreakEvent event2 = new OnBlockBreakEvent.onBlockBreakEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockBurnEvent(BlockBurnEvent event) {
        OnBlockBurnEvent.onBlockBurnEvent event2 = new OnBlockBurnEvent.onBlockBurnEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        OnBlockCanBuildEvent.onBlockCanBuildEvent event2 = new OnBlockCanBuildEvent.onBlockCanBuildEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event) {
        OnBlockDamageEvent.onBlockDamageEvent event2 = new OnBlockDamageEvent.onBlockDamageEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent event) {
        OnBlockDispenseEvent.onBlockDispenseEvent event2 = new OnBlockDispenseEvent.onBlockDispenseEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockFadeEvent(BlockFadeEvent event) {
        OnBlockFadeEvent.onBlockFadeEvent event2 = new OnBlockFadeEvent.onBlockFadeEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockFormEvent(BlockFormEvent event) {
        OnBlockFormEvent.onBlockFormEvent event2 = new OnBlockFormEvent.onBlockFormEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockFromToEvent(BlockFromToEvent event) {
        OnBlockFromToEvent.onBlockFromToEvent event2 = new OnBlockFromToEvent.onBlockFromToEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockGrowEvent(BlockGrowEvent event) {
        OnBlockGrowEvent.onBlockGrowEvent event2 = new OnBlockGrowEvent.onBlockGrowEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockIgniteEvent(BlockIgniteEvent event) {
        OnBlockIgniteEvent.onBlockIgniteEvent event2 = new OnBlockIgniteEvent.onBlockIgniteEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockPhysicsEvent(BlockPhysicsEvent event) {
        OnBlockPhysicsEvent.onBlockPhysicsEvent event2 = new OnBlockPhysicsEvent.onBlockPhysicsEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        OnBlockPlaceEvent.onBlockPlaceEvent event2 = new OnBlockPlaceEvent.onBlockPlaceEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
        OnBlockRedstoneEvent.onBlockRedstoneEvent event2 = new OnBlockRedstoneEvent.onBlockRedstoneEvent(event);
        getEventManager().fire(event2);
    }

    @EventHandler
    public void onSignChangeEvent(SignChangeEvent event) {
        OnSignChangeEvent.onSignChangeEvent event2 = new OnSignChangeEvent.onSignChangeEvent(event);
        getEventManager().fire(event2);
    }
}
