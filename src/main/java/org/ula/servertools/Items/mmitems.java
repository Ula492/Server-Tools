package org.ula.servertools.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.ula.servertools.Utils.GUI.createGuiItem;
import static org.ula.servertools.adminUtils.mmode.mminv;

public class mmitems {


    public static void mminitializeItems(){

        ItemStack space = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta spacemeta = space.getItemMeta();
        spacemeta.setDisplayName(" ");
        space.setItemMeta(spacemeta);


        mminv.setItem(0, space);
        mminv.setItem(1, space);
        mminv.setItem(2,createGuiItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLE", "§b»§f Click Me to ENABLE MM "));
        mminv.setItem(3, space);
        mminv.setItem(4, space);
        mminv.setItem(5,createGuiItem(Material.REDSTONE_BLOCK, ChatColor.GREEN + "" + ChatColor.BOLD + "DISABLE", "§b»§f Click Me to DISABLE MM "));
        mminv.setItem(6, space);
        mminv.setItem(7, space);
        mminv.setItem(8,createGuiItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "Go Back", "§b»§f Back to Admin Menu"));


    }
}
