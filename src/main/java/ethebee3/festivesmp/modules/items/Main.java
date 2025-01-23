package ethebee3.festivesmp.modules.items;

import ethebee3.basicUtils.event.events.entity.OnEntityDamageByEntityEvent;
import ethebee3.basicUtils.event.events.entity.OnEntityShootBowEvent;
import ethebee3.basicUtils.event.events.random.OnInit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Map;

public class Main implements OnInit, OnEntityShootBowEvent, OnEntityDamageByEntityEvent {
    static JavaPlugin plugin;
    static NamespacedKey key;
    static Map<Entity, Player> arrowmap = (Map<Entity, Player>) new ArrayList<>();
    static Map<Player, Double> healthmap = (Map<Player, Double>) new ArrayList<>();
    static ArrayList<Integer> idmap = new ArrayList<>();
    static int currentid = 0;

    @Override
    public void onInit(onInit event) {
        key = new NamespacedKey(event.getPlugin(), "bowofshadows:t1");
        plugin = event.getPlugin();
    }

    @Override
    public void onEntityShootBowEvent(onEntityShootBowEvent event) {
        EntityShootBowEvent event2 = event.getEvent();
        if (event2.getEntity() instanceof Player player) {
            assert event2.getBow().getItemMeta() != null;
            if (event2.getBow().getItemMeta().getPersistentDataContainer().has(key)) {
                arrowmap.put(event2.getProjectile(), player);
            }
        }
    }

    @Override
    public void onEntityDamageByEntityEvent(OnEntityDamageByEntityEvent.onEntityDamageByEntityEvent event) {
        EntityDamageByEntityEvent event2 = event.getEvent();
        if (event2.getDamageSource() == DamageSource.builder(DamageType.ARROW)) {
            if (arrowmap.containsKey(event2.getDamager())) {
                Player attacker = arrowmap.get(event2.getDamager());
                Player victim = (Player) event2.getEntity();

                Location victimLocation = victim.getLocation();
                Location behindLocation = victimLocation.clone();

                behindLocation.add(behindLocation.getDirection().multiply(-2));
                behindLocation.setYaw(victimLocation.getYaw());
                attacker.teleport(behindLocation);


                double oldhealth = attacker.getMaxHealth();
                attacker.setMaxHealth(oldhealth - 0.5);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (attacker.getMaxHealth() < 20) {
                            attacker.setMaxHealth(attacker.getMaxHealth() + 0.5);
                        }
                    }
                }.runTaskLater(plugin, 5000);
            }
        }
    }
}
