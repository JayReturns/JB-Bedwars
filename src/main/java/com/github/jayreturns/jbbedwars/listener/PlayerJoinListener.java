package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.JBBedwars;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGameJoin(PlayerJoinEvent e) {

    }
}
