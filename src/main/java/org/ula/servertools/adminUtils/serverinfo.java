package org.ula.servertools.adminUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.ula.servertools.Items.mmitems;
import org.ula.servertools.Items.sitems;
import org.ula.servertools.main;

public class serverinfo implements Listener {


    static String inv_name = ChatColor.translateAlternateColorCodes('&', "&4&lSERVER INFO");

    public static Inventory sinv;

    public static void sGUI(Player p) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        sinv = Bukkit.createInventory(null, 9, inv_name);

        // Put the items into the inventory
        sitems.sinitializeItems();
        p.openInventory(sinv);
        return;
    }



    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != sinv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();


        // Using slots click is a best option for your inventory click's
       // p.sendMessage("You clicked slot " + e.getRawSlot());

        if(e.getInventory() == sinv) { //gamemode
            int slot = e.getSlot();
            if (slot == 8) {
                MainG.mainGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            }
        }
    }
    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == sinv) {
            e.setCancelled(true);
        }
    }
}
