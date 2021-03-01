package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.JBBedwars;
import com.github.jayreturns.jbbedwars.game.GameManager;
import com.github.jayreturns.jbbedwars.team.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerConnectionListener implements Listener {

    public PlayerConnectionListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGameJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        TeamManager.addPlayerToTeam(p);
    }

    @EventHandler
    public void onGameLeave(PlayerQuitEvent e) {
        if (TeamManager.isPlayerInTeam(e.getPlayer())) {
            TeamManager.removePlayerFromTeam(e.getPlayer());
        }
    }

}
