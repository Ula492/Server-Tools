package org.ula.servertools;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.ula.servertools.adminUtils.*;

public final class main extends JavaPlugin {


    private static main instance;

    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
        init();
        cfg();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void cfg(){
        config.addDefault("Countdown", 5);
        config.addDefault("MOTDOn", " - MaintenanceMode ON  -");
        config.addDefault("KickMessage", " §4§lServer has begun its Maintenance Mode, try re-joining later!");
        config.addDefault("FakePlayersON", 0);
        config.addDefault("FakePlayersOFF", 10000);
        config.options().copyDefaults(true);
        saveConfig();

    }

    private void init(){
        instance = this;

        registerCommands();
        registerListeners();

        System.out.println(
                "\n" +
                "=- []=====[Enabling ServerTools]=====[]\n" +
                "| Information:\n" +
                "|   Name: ServerTools\n" +
                "|   Developer: Ula\n" +
                "|   Version: 1.0-RELEASE\n" +
                "| Support:\n" +
                "|   Discord: https://discord.gg/7hJYet\n" +
                "[]================================[] -=");



    }


    private void registerCommands(){
        getCommand("a").setExecutor(new ServerToolCommand());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new gamemode(), this);
        getServer().getPluginManager().registerEvents(new MainG(this), this);
        getServer().getPluginManager().registerEvents(new Weather(),this);
        getServer().getPluginManager().registerEvents(new Time(), this);
        getServer().getPluginManager().registerEvents(new mmode(this), this);
        getServer().getPluginManager().registerEvents(new serverinfo(), this);

    }
}
