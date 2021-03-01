package com.github.jayreturns.jbbedwars.team;

import com.github.jayreturns.jbbedwars.game.GameManager;
import com.github.jayreturns.jbbedwars.location.BedLocation;
import com.google.common.collect.Maps;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class TeamManager {

    @Getter @Deprecated
    private static final Map<UUID, BedwarsTeam> teamMembers = Maps.newHashMap();

    @Getter
    private static List<BedwarsTeam> teams;

    public static void initializeTeams() {
        for (int i = 0; i < GameManager.currentMap.getNumberOfTeams(); i++) {
            TeamColor color = GameManager.currentMap.getTeamColors().get(i);
            BedLocation bedLocation = new BedLocation(GameManager.currentMap.getBedLocation(color));
            int id = i;
            BedwarsTeam team = new BedwarsTeam(color, bedLocation, id);
            team.getBedLocation().setOwnerTeam(team);
            teams.add(team);
        }
    }

    public static BedwarsTeam findTeamOfPlayer(Player player) {
        BedwarsTeam playersTeam = null;
        for (BedwarsTeam team : teams) {
            if (team.isMemberOfTeam(player)) {
                playersTeam = team;
            }
        }
        return playersTeam;
    }

    public static boolean isPlayerInTeam(Player player) {
        return findTeamOfPlayer(player) != null;
    }

    public static void addPlayerToTeam(Player player) {
        if (isPlayerInTeam(player)) {
            throw new IllegalArgumentException("Player is already in a team");
        }
        getRandomNonFullTeam().addPlayer(player);
    }

    public static void removePlayerFromTeam(Player player) {
        if (!isPlayerInTeam(player)) {
            throw new IllegalArgumentException("Player is not in a team!");
        }
        findTeamOfPlayer(player).removePlayer(player);
    }

    private static BedwarsTeam getRandomNonFullTeam() {
        BedwarsTeam team;
        do {
            team = teams.get(ThreadLocalRandom.current().nextInt(teams.size()-1));
        } while (team.isFull());
        return team;
    }

}
