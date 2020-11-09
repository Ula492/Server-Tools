package org.ula.servertools.adminUtils;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.ula.servertools.Items.witems;

public class Weather implements Listener {

    static String inv_name = ChatColor.translateAlternateColorCodes('&', "&4&lWEATHER MENU");

    public static Inventory winv;

    public static void wGUI(Player p) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        winv = Bukkit.createInventory(null, 9, inv_name);

        // Put the items into the inventory
        witems.winitializeItems();
        p.openInventory(winv);
        return;
    }



    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != winv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        // p.sendMessage("You clicked at slot " + e.getRawSlot());

        if(e.getInventory() == winv){
            int slot = e.getSlot();
            if(slot == 0){
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setStorm(false);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE WEATHER TO" + ChatColor.GREEN + ChatColor.BOLD + "" + ChatColor.ITALIC + " CLEAR");
            }if(slot == 1){
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setThundering(false);
                    all.getWorld().setStorm(true);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE WEATHER TO" + ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + " RAIN");

            }  if(slot == 2){
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setThundering(true);
                    all.getWorld().setStorm(true);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE WEATHER TO" + ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + " THUNDER");

            }
            if(slot == 8){
                MainG.mainGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);

            }
        }



    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == winv) {
            e.setCancelled(true);
        }
    }
}
