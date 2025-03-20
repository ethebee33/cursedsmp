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

public class setKeyCommand /*implements OnInit, CommandExecutor*/ implements CommandExecutor{
    public setKeyCommand() {}

    //@Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        player.sendMessage(s);
        player.sendMessage(strings);
        switch (strings[0]) {
            case "swordofundying" -> {
                switch (strings[1]) {
                    case "1" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), swordOfUndying.keyt1, "t1");
                    }
                    case "2" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), swordOfUndying.keyt2, "t2");
                    }
                    case "3" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), swordOfUndying.keyt3, "t3");
                    }
                }
            }
            case "helmoffortune" -> {
                switch (strings[1]) {
                    case "1" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), helmOfFortune.keyt1, "t1");
                    }
                    case "2" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), helmOfFortune.keyt2, "t2");
                    }
                    case "3" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), helmOfFortune.keyt3, "t3");
                    }
                }
            }
            case "bowofshadows" -> {
                switch (strings[1]) {
                    case "1" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), bowOfShadows.keyt1, "t1");
                    }
                    case "2" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), bowOfShadows.keyt2, "t2");
                    }
                    case "3" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), bowOfShadows.keyt3, "t3");
                    }
                }
            }
            case "gauntletOfStrength" -> {
                switch (strings[1]) {
                    case "1" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), gauntletOfStrength.keyt1, "t1");
                    }
                    case "2" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), gauntletOfStrength.keyt2, "t2");
                    }
                    case "3" -> {
                        applyKeyToItem(player.getInventory().getItemInMainHand(), gauntletOfStrength.keyt3, "t3");
                    }
                }
            }
        }
        for(String string : strings) {
            player.sendMessage(string);
        }

        return true;
    }

    public void applyKeyToItem(ItemStack item, NamespacedKey key, String teir) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, teir);
        item.setItemMeta(meta);
    }

}
