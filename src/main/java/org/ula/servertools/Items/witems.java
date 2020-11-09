package org.ula.servertools.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.ula.servertools.Utils.GUI.createGuiItem;
import static org.ula.servertools.adminUtils.Time.tinv;
import static org.ula.servertools.adminUtils.Weather.winv;

public class witems {

    public static void winitializeItems(){


        ItemStack space = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta spacemeta = space.getItemMeta();
        spacemeta.setDisplayName(" ");
        space.setItemMeta(spacemeta);

        winv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "CLEAR", "§b»§f Click Me to CLEAR "));
        winv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "RAIN", "§b»§f Click Me to RAIN "));
        winv.addItem(createGuiItem(Material.PAPER, ChatColor.GREEN + "" + ChatColor.BOLD + "THUNDER", "§b»§f Click Me to THUNDER "));
        winv.setItem(8,createGuiItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "Go Back", "§b»§f Back to Admin Menu"));

        winv.setItem(3, space);
        winv.setItem(4, space);
        winv.setItem(5, space);
        winv.setItem(6, space);
        winv.setItem(7, space);





    }
}
