package org.distantnetwork.powermagecore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.distantnetwork.powermagecore.Classes;
import org.distantnetwork.powermagecore.PowermageCore;
import org.distantnetwork.powermagecore.utils.ItemBuilder;

public class ClassCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (player.hasPermission("powermage.start")) player.openInventory(generateClassSwitcher(player));
        return true;
    }

    public static Inventory generateClassSwitcher(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, String.format("%sChoose your class", ChatColor.RED));
        ItemStack item = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").setItemFlags(ItemFlag.HIDE_ATTRIBUTES).toItem();
        for (int i = 0; i < 26; i++) inventory.setItem(i, item);
        item = new ItemBuilder(Material.IRON_SWORD).setItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.DURABILITY, 1)
                .setName(String.format("%s[Lvl 0]%s%s Warrior", ChatColor.GRAY, PowermageCore.classesEmojis.get(Classes.WARRIOR), ChatColor.RED))
                .setLore(String.format("%s❤ Health: %s100%%", ChatColor.RED, ChatColor.RESET), String.format("%s✦ Base Speed: %s100%%", ChatColor.GOLD, ChatColor.RESET), String.format("%s☄ Base Mana: %s100", ChatColor.LIGHT_PURPLE, ChatColor.RESET), " ", String.format("%sClass Ability: %sCharge", ChatColor.BOLD, ChatColor.GOLD), String.format("%sGives player %s+100 %s✦ Speed %sfor %s10 %sseconds.", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GOLD, ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY), String.format("%sCooldown: %s30 Seconds", ChatColor.DARK_GRAY, ChatColor.GREEN), String.format("%sLeft Click on your menu to activate!", ChatColor.YELLOW), " ", String.format("%s%sCLICK TO SELECT", ChatColor.YELLOW, ChatColor.BOLD))
                .toItem();
        inventory.setItem(10, item);
        item = new ItemBuilder(Material.IRON_CHESTPLATE).setItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.DURABILITY, 1)
                .setName(String.format("%s[Lvl 0] %s%s Tank", ChatColor.GRAY, ChatColor.GREEN, PowermageCore.classesEmojis.get(Classes.TANK)))
                .setLore(String.format("%s❤ Health: %s200%%", ChatColor.RED, ChatColor.RESET), String.format("%s✦ Base Speed: %s50%%", ChatColor.GOLD, ChatColor.RESET), String.format("%s☄ Base Mana: %s100", ChatColor.LIGHT_PURPLE, ChatColor.RESET), " ", String.format("%sClass Ability: %sTurtle Up", ChatColor.BOLD, ChatColor.GOLD), String.format("%sGives player %sResistance 2 %sfor %s1 %sminute", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY), String.format("%sand %sRegen 5 %sfor %s10 seconds.", ChatColor.GRAY, ChatColor.GREEN, ChatColor.GRAY, ChatColor.GREEN), String.format("%sCooldown: %s3 minutes", ChatColor.DARK_GRAY, ChatColor.GREEN), String.format("%sLeft Click on your menu to activate!", ChatColor.YELLOW), " ", String.format("%s%sCLICK TO SELECT", ChatColor.YELLOW, ChatColor.BOLD))
                .toItem();
        inventory.setItem(12, item);
        // arrow rain as secondary ability for archer?
        item = new ItemBuilder(Material.CROSSBOW).setItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.DURABILITY, 1)
                .setName(String.format("%s[Lvl 0] %s%s Archer", ChatColor.GRAY, ChatColor.GREEN, PowermageCore.classesEmojis.get(Classes.ARCHER)))
                .setLore(String.format("%s❤ Health: %s50%%", ChatColor.RED, ChatColor.RESET), String.format("%s✦ Base Speed: %s200%%", ChatColor.GOLD, ChatColor.RESET), String.format("%s☄ Base Mana: %s100", ChatColor.LIGHT_PURPLE, ChatColor.RESET), " ", String.format("%sClass Ability: %sQuickshot", ChatColor.BOLD, ChatColor.GOLD), String.format("%sRapid-fires arrows to where", ChatColor.GRAY), String.format("%sthe player is looking at for %s3 seconds.", ChatColor.GRAY, ChatColor.GREEN), String.format("%sCooldown: %s30 Seconds", ChatColor.DARK_GRAY, ChatColor.GREEN), String.format("%sLeft Click on your menu to activate!", ChatColor.YELLOW), " ", String.format("%s%sCLICK TO SELECT", ChatColor.YELLOW, ChatColor.BOLD))
                .toItem();
        inventory.setItem(14, item);
        item = new ItemBuilder(Material.BLAZE_ROD).setItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.DURABILITY, 1)
                .setName(String.format("%s[Lvl 0] %s%s Wizard", ChatColor.GRAY, ChatColor.GREEN, PowermageCore.classesEmojis.get(Classes.WIZARD)))
                .setLore(String.format("%s❤ Health: %s75%%", ChatColor.RED, ChatColor.RESET), String.format("%s✦ Base Speed: %s80%%", ChatColor.GOLD, ChatColor.RESET), String.format("%s☄ Base Mana: %s300", ChatColor.LIGHT_PURPLE, ChatColor.RESET), " ", String.format("%sClass Ability: %sHeart of Magic", ChatColor.BOLD, ChatColor.GOLD), String.format("%sGives you infinite mana", ChatColor.GRAY), String.format("%sfor an entire %s5 seconds.", ChatColor.GRAY, ChatColor.GREEN), String.format("%sfor %s5 seconds.", ChatColor.GRAY, ChatColor.GREEN), String.format("%sCooldown: %s1 minute", ChatColor.DARK_GRAY, ChatColor.GREEN), String.format("%sLeft Click on your menu to activate!", ChatColor.YELLOW), " ", String.format("%s%sCLICK TO SELECT", ChatColor.YELLOW, ChatColor.BOLD))
                .toItem();
        inventory.setItem(16, item);
        item = new ItemBuilder(Material.ARROW).setName(String.format("%sBack to Main Menu", ChatColor.GRAY)).setItemFlags(ItemFlag.HIDE_ATTRIBUTES).toItem();
        inventory.setItem(18, item);
        item = new ItemBuilder(Material.BARRIER).setName(String.format("%sClose Menu", ChatColor.RED)).setItemFlags(ItemFlag.HIDE_ATTRIBUTES).toItem();
        inventory.setItem(22, item);
        return inventory;
    }
}