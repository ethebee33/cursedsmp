package ethebee3.basicUtils.event.eventInit.events;

import ethebee3.basicUtils.event.events.eventManager;
import ethebee3.basicUtils.event.events.player.*;
import ethebee3.basicUtils.event.events.player.OnTick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class player implements Listener {

    public player() {}

    @EventHandler
    public void onAsyncPlayerChatEvent(org.bukkit.event.player.AsyncPlayerChatEvent event) {
        OnAsyncPlayerChatEvent.onAsyncPlayerChatEvent event2 = new OnAsyncPlayerChatEvent.onAsyncPlayerChatEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerChatTabCompleteEvent(org.bukkit.event.player.PlayerChatTabCompleteEvent event) {
        OnPlayerChatTabCompleteEvent.onPlayerChatTabCompleteEvent event2 = new OnPlayerChatTabCompleteEvent.onPlayerChatTabCompleteEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
        OnPlayerCommandPreprocessEvent.onPlayerCommandPreprocessEvent event2 = new OnPlayerCommandPreprocessEvent.onPlayerCommandPreprocessEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerDropItemEvent(org.bukkit.event.player.PlayerDropItemEvent event) {
        OnPlayerDropItemEvent.onPlayerDropItemEvent event2 = new OnPlayerDropItemEvent.onPlayerDropItemEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerGameModeChangeEvent(org.bukkit.event.player.PlayerGameModeChangeEvent event) {
        OnPlayerGameModeChangeEvent.onPlayerGameModeChangeEvent event2 = new OnPlayerGameModeChangeEvent.onPlayerGameModeChangeEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(org.bukkit.event.player.PlayerInteractEntityEvent event) {
        OnPlayerInteractEntityEvent.onPlayerInteractEntityEvent event2 = new OnPlayerInteractEntityEvent.onPlayerInteractEntityEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerInteractEvent(org.bukkit.event.player.PlayerInteractEvent event) {
        OnPlayerInteractEvent.onPlayerInteractEvent event2 = new OnPlayerInteractEvent.onPlayerInteractEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerItemHeldEvent(org.bukkit.event.player.PlayerItemHeldEvent event) {
        OnPlayerItemHeldEvent.onPlayerItemHeldEvent event2 = new OnPlayerItemHeldEvent.onPlayerItemHeldEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        OnPlayerJoinEvent.onPlayerJoinEvent event2 = new OnPlayerJoinEvent.onPlayerJoinEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerKickEvent(org.bukkit.event.player.PlayerKickEvent event) {
        OnPlayerKickEvent.onPlayerKickEvent event2 = new OnPlayerKickEvent.onPlayerKickEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerLevelChangeEvent(org.bukkit.event.player.PlayerLevelChangeEvent event) {
        OnPlayerLevelChangeEvent.onPlayerLevelChangeEvent event2 = new OnPlayerLevelChangeEvent.onPlayerLevelChangeEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerMoveEvent(org.bukkit.event.player.PlayerMoveEvent event) {
        OnPlayerMoveEvent.onPlayerMoveEvent event2 = new OnPlayerMoveEvent.onPlayerMoveEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerPickupItemEvent(org.bukkit.event.player.PlayerPickupItemEvent event) {
        OnPlayerPickupItemEvent.onPlayerPickupItemEvent event2 = new OnPlayerPickupItemEvent.onPlayerPickupItemEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        OnPlayerQuitEvent.onPlayerQuitEvent event2 = new OnPlayerQuitEvent.onPlayerQuitEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerToggleFlightEvent(org.bukkit.event.player.PlayerToggleFlightEvent event) {
        OnPlayerToggleFlightEvent.onPlayerToggleFlightEvent event2 = new OnPlayerToggleFlightEvent.onPlayerToggleFlightEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerVelocityEvent(org.bukkit.event.player.PlayerVelocityEvent event) {
        OnPlayerVelocityEvent.onPlayerVelocityEvent event2 = new OnPlayerVelocityEvent.onPlayerVelocityEvent(event);
        eventManager.fire(event2);
    }
}
