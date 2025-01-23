package ethebee3.basicUtils.event.eventInit.events;

import ethebee3.basicUtils.event.events.eventManager;
import ethebee3.basicUtils.event.events.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class entity implements Listener {

    public entity() {}

    @EventHandler
    public void onCreatureSpawnEvent(org.bukkit.event.entity.CreatureSpawnEvent event) {
        OnCreatureSpawnEvent.onCreatureSpawnEvent event2 = new OnCreatureSpawnEvent.onCreatureSpawnEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityChangeBlockEvent(org.bukkit.event.entity.EntityChangeBlockEvent event) {
        OnEntityChangeBlockEvent.onEntityChangeBlockEvent event2 = new OnEntityChangeBlockEvent.onEntityChangeBlockEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityCombustEvent(org.bukkit.event.entity.EntityCombustEvent event) {
        OnEntityCombustEvent.onEntityCombustEvent event2 = new OnEntityCombustEvent.onEntityCombustEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityCreatePortalEvent(org.bukkit.event.entity.EntityCreatePortalEvent event) {
        OnEntityCreatePortalEvent.onEntityCreatePortalEvent event2 = new OnEntityCreatePortalEvent.onEntityCreatePortalEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityDamageByBlockEvent(org.bukkit.event.entity.EntityDamageByBlockEvent event) {
        OnEntityDamageByBlockEvent.onEntityDamageByBlockEvent event2 = new OnEntityDamageByBlockEvent.onEntityDamageByBlockEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(org.bukkit.event.entity.EntityDamageByEntityEvent event) {
        OnEntityDamageByEntityEvent.onEntityDamageByEntityEvent event2 = new OnEntityDamageByEntityEvent.onEntityDamageByEntityEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityDamageEvent(org.bukkit.event.entity.EntityDamageEvent event) {
        OnEntityDamageEvent.onEntityDamageEvent event2 = new OnEntityDamageEvent.onEntityDamageEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityDeathEvent(org.bukkit.event.entity.EntityDeathEvent event) {
        OnEntityDeathEvent.onEntityDeathEvent event2 = new OnEntityDeathEvent.onEntityDeathEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityEvent(org.bukkit.event.entity.EntityEvent event) {
        OnEntityEvent.onEntityEvent event2 = new OnEntityEvent.onEntityEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityExplodeEvent(org.bukkit.event.entity.EntityExplodeEvent event) {
        OnEntityExplodeEvent.onEntityExplodeEvent event2 = new OnEntityExplodeEvent.onEntityExplodeEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityInteractEvent(org.bukkit.event.entity.EntityInteractEvent event) {
        OnEntityInteractEvent.onEntityInteractEvent event2 = new OnEntityInteractEvent.onEntityInteractEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityPortalEnterEvent(org.bukkit.event.entity.EntityPortalEnterEvent event) {
        OnEntityPortalEnterEvent.onEntityPortalEnterEvent event2 = new OnEntityPortalEnterEvent.onEntityPortalEnterEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityShootBowEvent(org.bukkit.event.entity.EntityShootBowEvent event) {
        OnEntityShootBowEvent.onEntityShootBowEvent event2 = new OnEntityShootBowEvent.onEntityShootBowEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityTargetEvent(org.bukkit.event.entity.EntityTargetEvent event) {
        OnEntityTargetEvent.onEntityTargetEvent event2 = new OnEntityTargetEvent.onEntityTargetEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onEntityTargetLivingEntityEvent(org.bukkit.event.entity.EntityTargetLivingEntityEvent event) {
        OnEntityTargetLivingEntityEvent.onEntityTargetLivingEntityEvent event2 = new OnEntityTargetLivingEntityEvent.onEntityTargetLivingEntityEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onExpBottleEvent(org.bukkit.event.entity.ExpBottleEvent event) {
        OnExpBottleEvent.onExpBottleEvent event2 = new OnExpBottleEvent.onExpBottleEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onExplosionPrimeEvent(org.bukkit.event.entity.ExplosionPrimeEvent event) {
        OnExplosionPrimeEvent.onExplosionPrimeEvent event2 = new OnExplosionPrimeEvent.onExplosionPrimeEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onFoodLevelChangeEvent(org.bukkit.event.entity.FoodLevelChangeEvent event) {
        OnFoodLevelChangeEvent.onFoodLevelChangeEvent event2 = new OnFoodLevelChangeEvent.onFoodLevelChangeEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onItemDespawnEvent(org.bukkit.event.entity.ItemDespawnEvent event) {
        OnItemDespawnEvent.onItemDespawnEvent event2 = new OnItemDespawnEvent.onItemDespawnEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPlayerDeathEvent(org.bukkit.event.entity.PlayerDeathEvent event) {
        OnPlayerDeathEvent.onPlayerDeathEvent event2 = new OnPlayerDeathEvent.onPlayerDeathEvent(event);
        eventManager.fire(event2);
    }

    @EventHandler
    public void onPotionSplashEvent(org.bukkit.event.entity.PotionSplashEvent event) {
        OnPotionSplashEvent.onPotionSplashEvent event2 = new OnPotionSplashEvent.onPotionSplashEvent(event);
        eventManager.fire(event2);
    }
}
