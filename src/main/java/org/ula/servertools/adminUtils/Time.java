package org.ula.servertools.adminUtils;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.ula.servertools.Items.titems;

public class Time implements Listener {

    static String inv_name = ChatColor.translateAlternateColorCodes('&', "&4&lTIME MENU");

    public static Inventory tinv;

    public static void TimeGUI(Player p) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        tinv = Bukkit.createInventory(null, 9, inv_name);

        // Put the items into the inventory
        titems.tinitializeItems();
        p.openInventory(tinv);
        return;
    }



    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != tinv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        // p.sendMessage("You clicked at slot " + e.getRawSlot());

        if(e.getInventory() == tinv){
            int slot = e.getSlot();
            if(slot == 0){
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setTime(0);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE TIME TO" + ChatColor.GREEN + ChatColor.BOLD + "" + ChatColor.ITALIC + " MORNING");

            }if(slot == 1){
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setTime(6000);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE TIME TO" + ChatColor.GREEN + ChatColor.BOLD + "" + ChatColor.ITALIC + " NOON");


            }  if(slot == 2){
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setTime(12000);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE TIME TO" + ChatColor.GREEN + ChatColor.BOLD + "" + ChatColor.ITALIC + " SUNSET");

            }  if(slot == 3){
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1F,1F);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setTime(18000);
                }
                Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.BOLD + " " + p.getName() + " CHANGED THE TIME TO" + ChatColor.GREEN + ChatColor.BOLD + "" + ChatColor.ITALIC + " NIGHT");


            }
            if(slot == 8){
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
                MainG.mainGUI(p);
            }
        }



    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == tinv) {
            e.setCancelled(true);
        }
    }



}
