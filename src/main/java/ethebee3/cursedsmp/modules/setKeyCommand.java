package ethebee3.cursedsmp.modules;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import ethebee3.cursedsmp.modules.items.*;

import java.util.Arrays;

public class setKeyCommand implements CommandExecutor{
    public setKeyCommand() {}

    //@Override
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        player.sendMessage(Arrays.toString(strings)); // String representation of the array

        if (strings.length < 2) {
            player.sendMessage("Usage: /setkey <item> <tier>");
            return false;
        }

        String item = strings[0];
        String tier = strings[1];

        switch (item.toLowerCase()) {
            case "swordofundying":
                if (tier.equals("1")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), swordOfUndying.keyt1, "t1");
                } else if (tier.equals("2")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), swordOfUndying.keyt2, "t2");
                } else if (tier.equals("3")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), swordOfUndying.keyt3, "t3");
                }
                break;

            case "helmoffortune":
                if (tier.equals("1")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), helmOfFortune.keyt1, "t1");
                } else if (tier.equals("2")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), helmOfFortune.keyt2, "t2");
                } else if (tier.equals("3")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), helmOfFortune.keyt3, "t3");
                }
                break;

            case "bowofshadows":
                if (tier.equals("1")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), bowOfShadows.keyt1, "t1");
                } else if (tier.equals("2")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), bowOfShadows.keyt2, "t2");
                } else if (tier.equals("3")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), bowOfShadows.keyt3, "t3");
                }
                break;

            case "gauntletofstrength":
                if (tier.equals("1")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), gauntletOfStrength.keyt1, "t1");
                } else if (tier.equals("2")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), gauntletOfStrength.keyt2, "t2");
                } else if (tier.equals("3")) {
                    applyKeyToItem(player.getInventory().getItemInMainHand(), gauntletOfStrength.keyt3, "t3");
                }
                break;

            default:
                player.sendMessage("Invalid item type.");
                return false;
        }
        return true;
    }


    public void applyKeyToItem(ItemStack item, NamespacedKey key, String teir) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, teir);
        item.setItemMeta(meta);
    }
}
