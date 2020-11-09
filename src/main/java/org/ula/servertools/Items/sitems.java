package org.ula.servertools.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.ula.servertools.adminUtils.mmode;

import static org.ula.servertools.Utils.GUI.createGuiItem;
import static org.ula.servertools.adminUtils.serverinfo.sinv;

public class sitems {



    public static void sinitializeItems(){
        String Version = Bukkit.getServer().getVersion();

        int Online = Bukkit.getServer().getOnlinePlayers().size();
        int total = Bukkit.getServer().getMaxPlayers();
        String OnT = Online + "/" + total;

        Runtime r = Runtime.getRuntime();
        long memUsed = (r.totalMemory() - r.freeMemory()) / 1048576;
        long totalmem = r.totalMemory()/204875;

        long availableproc = Runtime.getRuntime().availableProcessors();


        sinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "RAM", "§b»§f " + memUsed + "MB/" + totalmem + "MB"));
        sinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "PLAYERS ONLINE", "§b»§f " + OnT));
        sinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "PROCESSORS", "§b»§f " + availableproc));
        sinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "VERSION", "§b»§f " + Bukkit.getServer().getVersion()));
        if(mmode.sList == true){
            sinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "MAINTENANCE MODE", "§b»§f ON"));
        }else if(mmode.sList == false){
            sinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "MAINTENANCE MODE", "§b»§f OFF"));
        }
        sinv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "  " + ChatColor.BOLD + "", ""));
        sinv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "   " + ChatColor.BOLD + "", ""));
        sinv.addItem(createGuiItem(Material.ORANGE_STAINED_GLASS_PANE, ChatColor.GREEN + "    " + ChatColor.BOLD + "", ""));

        sinv.addItem(createGuiItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "Go Back", "§b»§f Back to Admin Menu"));


    }

}
