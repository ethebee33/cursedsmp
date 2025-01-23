package ethebee3.festivesmp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ethebee3.basicUtils.data.playerData;


public class pvpCMD implements CommandExecutor {

    private final JavaPlugin plugin;

    public pvpCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String command2, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }

        YamlConfiguration playerdata = playerData.getDataForPlayer(player.getUniqueId());

        if (playerdata.getBoolean("pvp")) {
            playerdata.set("pvp", false);
        } else {
            playerdata.set("pvp", true);
        }

        return true;
    }
}
