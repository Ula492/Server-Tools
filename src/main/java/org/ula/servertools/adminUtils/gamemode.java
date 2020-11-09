package org.ula.servertools.adminUtils;

import org.bukkit.*;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ula.servertools.Items.gmitems;

import java.util.Arrays;


public class gamemode implements Listener {

    static String inv_name = ChatColor.translateAlternateColorCodes('&', "&4&lSTAFF GAMEMODE");

    public static Inventory ginv;

    public static void GameModeGUI(Player p) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        ginv = Bukkit.createInventory(null, 9, inv_name);

        // Put the items into the inventory
        gmitems.initializeItems();
        p.openInventory(ginv);
        return;
    }



    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != ginv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        //p.sendMessage("You clicked at slot " + e.getRawSlot());
        if(e.getInventory() == ginv){
            int slot = e.getSlot();
            if(slot == 0){
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>" + ChatColor.WHITE + "" + ChatColor.BOLD + " GAMEMODE SET TO" + ChatColor.GREEN + "" + ChatColor.BOLD + ChatColor.ITALIC + " CREATIVE");
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
                p.closeInventory();

            }if(slot == 1){
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>" + ChatColor.WHITE + "" + ChatColor.BOLD + " GAMEMODE SET TO" + ChatColor.GREEN + "" + ChatColor.BOLD + ChatColor.ITALIC + " SURVIVAL");
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
                p.closeInventory();

            }  if(slot == 2){
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>" + ChatColor.WHITE + "" + ChatColor.BOLD + " GAMEMODE SET TO" + ChatColor.GREEN + "" + ChatColor.BOLD + ChatColor.ITALIC + " SPECTATOR");
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
                p.closeInventory();

            }  if(slot == 3){
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>" + ChatColor.WHITE + "" + ChatColor.BOLD + " GAMEMODE SET TO" + ChatColor.GREEN + "" + ChatColor.BOLD + ChatColor.ITALIC + " ADVENTURE");
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
                p.closeInventory();

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
        if (e.getInventory() == ginv) {
            e.setCancelled(true);
        }
    }
}
