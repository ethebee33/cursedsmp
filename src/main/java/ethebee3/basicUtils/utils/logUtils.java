package ethebee3.basicUtils.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class logUtils {
    private static JavaPlugin plugin;
    public static void registerLogger(JavaPlugin main) {
        plugin = main;
    }

    public static void logInfo(String message) {
        plugin.getLogger().info(message);
    }

    public static void logWarning(String message) {
        plugin.getLogger().warning(message);
    }

    public static void logError(String message) {
        plugin.getLogger().warning("ERROR: "+message);
    }
}
