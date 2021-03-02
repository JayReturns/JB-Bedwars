package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.team.TeamManager;
import com.github.jayreturns.jbbedwars.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathListener implements Listener {

    public DeathListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player killer = p.getKiller();

        e.setDeathMessage(Messages.PREFIX + killer.getName() + " killed " + p.getName());
        e.getDrops().clear();

        if (TeamManager.getTeamOfPlayer(p).isBedActive()) {
            p.spigot().respawn();
            if (!p.teleport(TeamManager.getTeamOfPlayer(p).getSpawnLocation())) {
                throw new RuntimeException("Could not teleport player after respawn");
            }
        } else {
            TeamManager.addSpectator(p);
        }
    }

}
