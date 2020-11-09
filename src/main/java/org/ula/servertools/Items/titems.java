package org.ula.servertools.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.ula.servertools.Utils.GUI.createGuiItem;
import static org.ula.servertools.adminUtils.Time.tinv;

public class titems {


    public static void tinitializeItems(){

        ItemStack space = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta spacemeta = space.getItemMeta();
        spacemeta.setDisplayName(" ");
        space.setItemMeta(spacemeta);

        tinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "MORNING", "§b»§f Click Me to SET TO MORNING "));
        tinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "NOON", "§b»§f Click Me to SET TO NOON "));
        tinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "SUNSET", "§b»§f Click Me to SET TO SUNSET "));
        tinv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "NIGHT", "§b»§f Click Me to SET TO NIGHT "));

        tinv.setItem(8,createGuiItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "Go Back", "§b»§f Back to Admin Menu"));

        tinv.setItem(4, space);
        tinv.setItem(5, space);
        tinv.setItem(6, space);
        tinv.setItem(7, space);
        //tinv.setItem(99, space);


    }
}
