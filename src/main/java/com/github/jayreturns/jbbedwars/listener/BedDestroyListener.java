package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.effect.BedDestroyEffect;
import com.github.jayreturns.jbbedwars.location.BedLocation;
import com.github.jayreturns.jbbedwars.team.BedwarsTeam;
import com.github.jayreturns.jbbedwars.team.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.stream.Collectors;

public class BedDestroyListener implements Listener {

    public BedDestroyListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBedDestroy(BlockBreakEvent e) {
        if (e.getBlock().getType() != Material.ACACIA_BOAT) {
            return;
        }
        Location bedLoc = e.getBlock().getLocation();
        List<BedLocation> locs = TeamManager.getTeams().stream()
                .map(BedwarsTeam::getBedLocation)
                .collect(Collectors.toList());
        for (BedLocation loc : locs) {
            if (loc.isBed(bedLoc)) {
                loc.getOwnerTeam().setBedActive(false);
                new BedDestroyEffect().activateEffect();
            }
        }
    }

}
