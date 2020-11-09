package org.ula.servertools.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import static org.ula.servertools.Utils.GUI.createGuiItem;
import static org.ula.servertools.adminUtils.MainG.minv;

public class mitems {


    public static void minitializeItems(){



        ItemStack space1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);

        minv.setItem(0, space1);
        minv.setItem(1, space1);
        minv.setItem(2, space1);
        minv.setItem(3, space1);
        minv.setItem(4, space1);
        minv.setItem(5, space1);
        minv.setItem(6, space1);
        minv.setItem(7, space1);
        minv.setItem(8, space1);
        minv.setItem(9, space1);
        minv.setItem(10,createGuiItem(Material.WOODEN_SHOVEL, ChatColor.GREEN + "" + ChatColor.BOLD + "GAMEMODES", "§b»§f Click Me to switch GAMEMODES"));
        minv.setItem(11, space1);
        minv.setItem(12,createGuiItem(Material.QUARTZ_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "WEATHER", "§b»§f Click Me to switch WEATHER"));
        minv.setItem(13, space1);
        minv.setItem(14,createGuiItem(Material.CLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "TIME", "§b»§f Click Me to switch TIME"));
        minv.setItem(15, space1);
        minv.setItem(16,createGuiItem(Material.WOODEN_AXE, ChatColor.GREEN + "" + ChatColor.BOLD + "VANISH", "§b»§f Click Me to VANISH"));
        minv.setItem(17, space1);
        minv.setItem(18, space1);
        minv.setItem(19, space1);
        minv.setItem(20,createGuiItem(Material.BEDROCK, ChatColor.GREEN + "" + ChatColor.BOLD + "STAFF PARTICLES", "§b»§f Click Me to ADD PARTICLES"));
        minv.setItem(21, space1);
        minv.setItem(22,createGuiItem(Material.REDSTONE_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "MAINTENANCE MODE", "§b»§f Click Me to ENABLE/DISABLE MM"));
        minv.setItem(23, space1);
        minv.setItem(24,createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "QUICK TP", "§b»§f Click Me to QUICK TELEPORT"));
        minv.setItem(25, space1);
        minv.setItem(26, space1);
        minv.setItem(27, space1);
        minv.setItem(28,createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "RELOAD", "§b»§f Click Me to RELOAD SERVER"));
        minv.setItem(29, space1);
        minv.setItem(30,createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "SHUTDOWN", "§b»§f Click Me to SHUTDOWN SERVER"));
        minv.setItem(31, space1);
        minv.setItem(32,createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "RESTART", "§b»§f Click Me to RESTART SERVER"));
        minv.setItem(33, space1);
        minv.setItem(34,createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "SERVER INFO", "§b»§f Click Me to see SERVER INFO"));
        minv.setItem(35, space1);
        minv.setItem(36, space1);
        minv.setItem(37, space1);
        minv.setItem(38, space1);
        minv.setItem(39, space1);
        minv.setItem(40, space1);
        minv.setItem(41, space1);
        minv.setItem(42, space1);
        minv.setItem(43, space1);
        minv.setItem(44, space1);
        minv.setItem(45, space1);
        minv.setItem(46, space1);
        minv.setItem(47, space1);
        minv.setItem(48, space1);
        minv.setItem(49, space1);
        minv.setItem(50, space1);
        minv.setItem(51, space1);
        minv.setItem(52, space1);
        minv.setItem(53, space1);


        // minv.addItem(createGuiItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "Go Back", "§b»§f Back to Player Menu"));


    }
}
