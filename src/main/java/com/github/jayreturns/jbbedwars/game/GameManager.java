package com.github.jayreturns.jbbedwars.game;

import com.github.jayreturns.jbbedwars.team.BedwarsTeam;
import com.github.jayreturns.jbbedwars.team.TeamColor;
import org.bukkit.entity.Player;

import java.util.Set;

public class GameManager {

    public static Set<BedwarsTeam> TEAMS;
    //TODO: Make this a map property!
    public static int MAX_PLAYERS;

    public static void setup() {
        int count = 0;
        for (TeamColor color : TeamColor.values()) {
            TEAMS.add(new BedwarsTeam(color, null, count));
            count++;
        }
    }

    /**
     * Get team of player
     * @param player
     * @return Team of player or null if player is in no team (spectator)
     */
    public static BedwarsTeam getTeamOfPlayer(Player player) {
        for (BedwarsTeam team : TEAMS) {
            if (team.isMemberOfTeam(player)) {
                return team;
            }
        }
        return null;
    }

}
