package com.github.jayreturns.jbbedwars.game;

import com.github.jayreturns.jbbedwars.map.BedwarsMap;
import com.github.jayreturns.jbbedwars.map.MapFileManager;
import com.github.jayreturns.jbbedwars.team.BedwarsTeam;
import com.github.jayreturns.jbbedwars.team.TeamColor;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class GameManager {

    public static Set<BedwarsTeam> teams;
    public static Set<BedwarsMap> maps;
    public static BedwarsMap currentMap;
    //TODO: Make this a map property!
    public static int maxPlayers = currentMap.getMaxPlayers();

    public static void setup() throws FileNotFoundException {
        for (File file : MapFileManager.getMapConfigurationFiles()) {
            maps.add(MapFileManager.getMapFromFile(file));
        }
        int count = 0;
        for (TeamColor color : TeamColor.values()) {
            teams.add(new BedwarsTeam(color, null, count));
            count++;
            if (count > maxPlayers) break;
        }
    }

    /**
     * Get team of player
     * @param player
     * @return Team of player or null if player is in no team (spectator)
     */
    public static BedwarsTeam getTeamOfPlayer(Player player) {
        for (BedwarsTeam team : teams) {
            if (team.isMemberOfTeam(player)) {
                return team;
            }
        }
        return null;
    }

}
