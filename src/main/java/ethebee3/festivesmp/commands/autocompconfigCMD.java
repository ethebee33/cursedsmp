package ethebee3.festivesmp.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class autocompconfigCMD implements CommandExecutor {

    private final JavaPlugin plugin;
    public static Location spawnLocation;

    public autocompconfigCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    //TODO: finish command later (ethebee3 only)

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String command2, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }

        switch (command2.toLowerCase()) {
            case "input" -> {

            }
            case "output" -> {

            }
            default -> {
                return false;
            }
        }
        return true;
    }
}
