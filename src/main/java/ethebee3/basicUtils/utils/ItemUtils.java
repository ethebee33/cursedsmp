package ethebee3.basicUtils.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimPattern;

import java.util.*;

public class ItemUtils {
    public static int hasEnchant(ItemStack item, Enchantment enchant) {
        int enchant2 = -1;
        try {
            enchant2 = item.getEnchantments().get(enchant);
        } catch (NullPointerException e) {
            return 0;
        }
        if (enchant2 == -1) {return enchant2;}
        return 0;
    }

    public static String convertItemToString(ItemStack item) {
        Material material = item.getType();
        int amount = item.getAmount();
        StringBuilder itemString = new StringBuilder(material.name() + ":" + amount);
        Map<Enchantment, Integer> enchantments = item.getEnchantments();
        if (!enchantments.isEmpty()) {
            for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                Enchantment enchantment = entry.getKey();
                int level = entry.getValue();
                itemString.append(";").append(enchantment.getKey().getKey()).append("=").append(level);
            }
        }

        return itemString.toString();
    }

    public static ItemStack convertStringtoItem(String string) {
        String[] parts = string.split(";");
        String[] baseParts = parts[0].split(":");
        Material material = Material.getMaterial(baseParts[0]);
        int amount = Integer.parseInt(baseParts[1]);
        ItemStack item = new ItemStack(material, amount);
        for (int i = 1; i < parts.length; i++) {
            String[] enchantParts = parts[i].split("=");
            Enchantment enchantment = Enchantment.getByKey(org.bukkit.NamespacedKey.minecraft(enchantParts[0]));
            int level = Integer.parseInt(enchantParts[1]);
            item.addEnchantment(enchantment, level);
        }

        return item;
    }

    public static ItemStack getSmeltedItem(ItemStack item) {
        FurnaceRecipe smeltingRecipe = getSmeltingRecipe(item);
        if (smeltingRecipe != null) {
            return smeltingRecipe.getResult();
        }
        return null;
    }

    public static FurnaceRecipe getSmeltingRecipe(ItemStack item) {
        NamespacedKey key = new NamespacedKey("minecraft", "smelting/" + item.getType().name().toLowerCase());
        return (FurnaceRecipe) Bukkit.getRecipe(key);
    }

    public static Collection<ItemStack> maxTools = new ArrayList<ItemStack>() {{
        add(new ItemStack(Material.NETHERITE_SWORD));
        add(new ItemStack(Material.NETHERITE_PICKAXE));
        add(new ItemStack(Material.NETHERITE_AXE));
        add(new ItemStack(Material.NETHERITE_SHOVEL));
        add(new ItemStack(Material.NETHERITE_HOE));
    }};

    public static Material getOptimalTool(Block block) {
        int e = -1;
        BlockData data = block.getBlockData();
        if (data.requiresCorrectToolForDrops()) {
            for(ItemStack item : maxTools) {
                if (block.isPreferredTool(item)) return item.getType();
            }
        } else {
            return Material.AIR;
        }
        return null;
    }

    public static boolean hasMatchingTrims(Player player) {
        if (player.getInventory().getHelmet() == null) return false;
        if (player.getInventory().getChestplate() == null) return false;
        if (player.getInventory().getLeggings() == null) return false;
        if (player.getInventory().getBoots() == null) return false;

        ArmorMeta[] armorMeta = {
                (ArmorMeta) player.getInventory().getHelmet().getItemMeta(),
                (ArmorMeta) player.getInventory().getChestplate().getItemMeta(),
                (ArmorMeta) player.getInventory().getLeggings().getItemMeta(),
                (ArmorMeta) player.getInventory().getBoots().getItemMeta()
        };

        if (Arrays.stream(armorMeta).allMatch(meta -> meta != null && meta.hasTrim())) {
            ArmorTrim firstTrim = armorMeta[0].getTrim();
            if (Arrays.stream(armorMeta).allMatch(meta -> Objects.equals(meta.getTrim(), firstTrim))) {
                return true;
            }
        }

        return false;
    }

    public static ArmorTrim getTrim(Player player) {
        ArmorMeta meta = (ArmorMeta) Objects.requireNonNull(player.getInventory().getBoots()).getItemMeta();
        assert meta != null;
        return meta.getTrim();
    }

    public static TrimPattern getTrim2(Player player) {
        ArmorMeta meta = (ArmorMeta) Objects.requireNonNull(player.getInventory().getBoots()).getItemMeta();
        assert meta != null;
        return meta.getTrim().getPattern();
    }

}


