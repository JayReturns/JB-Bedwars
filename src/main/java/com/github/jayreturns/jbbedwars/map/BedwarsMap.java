package com.github.jayreturns.jbbedwars.map;

import com.github.jayreturns.jbbedwars.team.TeamColor;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.Location;

import java.util.Map;

@Data
public class BedwarsMap {

    @NonNull  private int maxPlayers;
    private Map<TeamColor, Location> bedLocations;
    private Map<TeamColor, Location> spawnLocations;

    public Location getSpawnLocation(TeamColor color) {
        return spawnLocations.get(color);
    }

    public Location getBedLocation(TeamColor color) {
        return bedLocations.get(color);
    }

}
