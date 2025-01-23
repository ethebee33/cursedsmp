package ethebee3.basicUtils.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class playerUtils {
    public static Player getPlayerByName(String name) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) return player;
            if (player.getDisplayName().equalsIgnoreCase(name)) return player;
        }
        return null;
    }
}
