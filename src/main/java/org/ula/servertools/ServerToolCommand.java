package org.ula.servertools;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ula.servertools.adminUtils.MainG;
import org.ula.servertools.adminUtils.Weather;

public class ServerToolCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender cs, Command cmd, String label, final String[] args) {

        if (cs instanceof Player) {
            Player p = (Player) cs;
            if(cmd.getName().equalsIgnoreCase("a")){
                if(p.hasPermission("admin.servertools")){
                    MainG.mainGUI(p);
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5F,4F);
                }else{
                    p.sendMessage("You must be a Staff member to run this command!");
                    p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_LAND,1F,1F);
                }
            }
        }
        return true;
    }




}
