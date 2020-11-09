package org.ula.servertools.adminUtils;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.ula.servertools.Items.mitems;
import org.ula.servertools.main;

public class MainG implements Listener {

    private final main plugin;
    public MainG(main plugin) {
        this.plugin = plugin;
    }
    private boolean sVanish = false;

    static String inv_name = ChatColor.translateAlternateColorCodes('&', "&4&lSTAFF MENU");

    public static Inventory minv;

    public static void mainGUI(Player p) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        minv = Bukkit.createInventory(null, 54, inv_name);

        // Put the items into the inventory
        mitems.minitializeItems();
        p.openInventory(minv);
        return;
    }



    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != minv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();


        // Using slots click is a best option for your inventory click's
       // p.sendMessage("You clicked at slot " + e.getRawSlot());

        if(e.getInventory() == minv){ //gamemode
            int slot = e.getSlot();
            if(slot == 10){
                gamemode.GameModeGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);

            }if(slot == 12){ //weather
                Weather.wGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);

            }  if(slot == 14){ //time
                Time.TimeGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);


            }  if(slot == 16){ //vanish
                e.setCancelled(true);
                p.closeInventory();
                if (sVanish == false) {
                    Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + " " +  p.getName() + " Has left the game");
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(plugin,p);
                    }
                    p.setCustomName("");
                    p.setPlayerListName("");
                    p.setDisplayName("");
                    p.setCustomNameVisible(false);
                    p.setGameMode(GameMode.CREATIVE);
                    p.setAllowFlight(true);
                    p.hidePlayer(plugin,p);
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1F, 1F);
                    p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + " VANISH MODE " + ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLED");
                    sVanish = true;

                } else if (sVanish == true) {
                    e.setCancelled(true);
                    p.closeInventory();

                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.1F, 0.1F);
                    p.setCustomName(p.getName());
                    p.setPlayerListName(p.getName());
                    p.setDisplayName(p.getName());
                    p.setCustomNameVisible(true);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.showPlayer(plugin,p);
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + " VANISH MODE " + ChatColor.RED + ChatColor.BOLD + "DISABLED");

                        Bukkit.getServer().broadcastMessage(p.getName() + "" + ChatColor.YELLOW + " has joined the game");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(plugin,p);
                        }
                        sVanish = false;

                    }

            }
            if(slot == 20){

            }
            if(slot == 22){
                mmode.MMGUI(p);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
            }
            if(slot == 24){

            }
            if(slot == 28){
                p.closeInventory();
                Bukkit.getServer().reload();
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + " SERVER HAS " + ChatColor.GREEN + ChatColor.BOLD + "RELOADED");
            }
            if(slot == 30){
                p.closeInventory();
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + " SERVER HAS BEEN " + ChatColor.RED + ChatColor.BOLD + "SHUTDOWN");

                new BukkitRunnable() {
                    int countdown = 5; //Seconds to countDown from

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

                            Bukkit.getServer().shutdown();


                            this.cancel();//cancel the task cus 1) The player left or 2) countdown has = 0 and some players were not kicked because they are whitelisted.
                            return;//Always exit the method :p

                        } else if (countdown > 0) {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.1F, 0.1F);
                            p.sendTitle("§4SERVER", "§f§l" + countdown + "s" + " §a§lUNTIL SHUTDOWN", 0, 50, 20);
                            countdown--;
                        }
                    }
                }.runTaskTimer(plugin, 0, 20);//Repeating task with 0 ticks initial delay, run once per 20 ticks (one second).
            }
            if(slot == 32){
                p.closeInventory();
                p.sendMessage(ChatColor.GRAY + "ServerTools " + ChatColor.STRIKETHROUGH + ">>"  + ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + " SERVER HAS BEEN " + ChatColor.RED + ChatColor.BOLD + "RESTARTED");

                new BukkitRunnable() {
                    int countdown = 5; //Seconds to countDown from

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

                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");


                            this.cancel();//cancel the task cus 1) The player left or 2) countdown has = 0 and some players were not kicked because they are whitelisted.
                            return;//Always exit the method :p

                        } else if (countdown > 0) {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.1F, 0.1F);
                            p.sendTitle("§4SERVER", "§f§l" + countdown + "s" + " §a§lUNTIL RESTART", 0, 50, 20);
                            countdown--;
                        }
                    }
                }.runTaskTimer(plugin, 0, 20);//Repeating task with 0 ticks initial delay, run once per 20 ticks (one second).

            }
            if(slot == 34){
                serverinfo.sGUI(p);
            }
        }



    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == minv) {
            e.setCancelled(true);
        }
    }
}

