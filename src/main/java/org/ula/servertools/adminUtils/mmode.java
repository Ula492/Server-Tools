package org.ula.servertools.adminUtils;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.ula.servertools.Items.mitems;
import org.ula.servertools.Items.mmitems;
import org.ula.servertools.main;

public class mmode implements Listener {

    private final main plugin;

    public mmode(main plugin) {
        this.plugin = plugin;
    }

    public static boolean sList = false;

    static String inv_name = ChatColor.translateAlternateColorCodes('&', "&4&lMAINTENANCE MODE");

    public static Inventory mminv;

    public static void MMGUI(Player p) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        mminv = Bukkit.createInventory(null, 9, inv_name);

        // Put the items into the inventory
        mmitems.mminitializeItems();
        p.openInventory(mminv);
        return;
    }



    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != mminv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();


        // Using slots click is a best option for your inventory click's
        //p.sendMessage("You clicked slot " + e.getRawSlot());

        if(e.getInventory() == mminv) { //gamemode
            int slot = e.getSlot();
            if (slot == 2) {
                p.closeInventory();
                if (sList == false) {
                    new BukkitRunnable() {
                        int countdown = plugin.config.getInt("Countdown"); //Seconds to countDown from

                        @Override
                        public void run() {
                            if (countdown <= 0) { //Lets make sure the player is online just in-case this causes lag!
                                ///////////////////////////////////////
                                //Now we add everything that will run after the timer is done;
                                // - Whitelist - Done 1/06/18
                                // - MOTD - Done 1/07/18
                                // - Whitelist Join Message - Done 1/06/18
                                // - Player Count set to 0 - Done 1/07/18
                                // - Config/Custom Messages.
                                ///////////////////////////////////////

                                Bukkit.setWhitelist(true);

                                if (p.isWhitelisted()) {
                                    Bukkit.broadcastMessage(Bukkit.getWhitelistedPlayers().size() + " whitelisted players are allowed to join the server while in Maintenance Mode, make sure that you check the list of players you want to allow to join during this session!");
                                } else {
                                    p.kickPlayer(plugin.config.getString("KickMessage"));
                                }

                                sList = true;

                                this.cancel();//cancel the task cus 1) The player left or 2) countdown has = 0 and some players were not kicked because they are whitelisted.
                                return;//Always exit the method :p

                            } else if (countdown > 0) {
                                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.1F, 0.1F);
                                p.sendTitle("§4MaintenanceMode", "§f§l" + countdown + "s" + " §a§lUntil Maintenance starts", 0, 50, 20);
                                countdown--;
                            }
                        }
                    }.runTaskTimer(plugin, 0, 20);//Repeating task with 0 ticks initial delay, run once per 20 ticks (one second).
                } else {
                    p.closeInventory();
                    p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>" + ChatColor.RESET + "Sir, MaintenanceMode is already enabled!");
                }
            }

            if (slot == 5) {
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    e.setCancelled(true);
                    p.closeInventory();
                    if(sList) {
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.1F, 0.1F);
                        p.sendTitle("§4MaintenanceMode", " §a§lEnded!", 0, 50, 20);
                        Bukkit.setWhitelist(false);
                        sList = false;
                    }else{
                        p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>" + ChatColor.RESET + " Sir, MaintenanceMode is already disabled!");
                    }
            }
            if (slot == 8) {
                MainG.mainGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            }
        }
    }
    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == mminv) {
            e.setCancelled(true);
        }
    }


    }
