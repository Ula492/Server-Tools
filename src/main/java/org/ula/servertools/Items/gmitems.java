package org.ula.servertools.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;


import static org.ula.servertools.Utils.GUI.createGuiItem;
import static org.ula.servertools.adminUtils.gamemode.ginv;

public class gmitems {


    public static void initializeItems(){
        ginv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "CREATIVE", "§b»§f Click Me to switch to CREATIVE"));
        ginv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "SURVIVAL", "§b»§f Click Me to switch to SURVIVAL"));
        ginv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "SPECTATOR", "§b»§f Click Me to switch to SPECTATOR"));
        ginv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "ADVENTURE", "§b»§f Click Me to switch to ADVENTURE"));
        ginv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "" + ChatColor.BOLD + " ", ""));
        ginv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "  " + ChatColor.BOLD + "", ""));
        ginv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "   " + ChatColor.BOLD + "", ""));
        ginv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "    " + ChatColor.BOLD + "", ""));

        ginv.addItem(createGuiItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "Go Back", "§b»§f Back to Admin Menu"));


    }
}
