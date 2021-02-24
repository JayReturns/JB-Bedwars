package com.github.jayreturns.jbbedwars.team;

import com.github.jayreturns.jbbedwars.game.GameManager;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

@Data
public class BedwarsTeam {

    private Set<UUID> members;
    private boolean isAlive;
    @NonNull
    private TeamColor teamColor;
    @NonNull
    private Location bedLocation;
    @NonNull
    private int id;

    public boolean isMemberOfTeam(Player player) {
        return members.contains(player.getUniqueId());
    }

    public boolean isFull() {
        return members.size() >= GameManager.MAX_PLAYERS;
    }

    public boolean isEmpty() {
        return members.size() == 0;
    }

    public void removePlayer(Player player) {
        members.remove(player.getUniqueId());
    }

    public void addPlayer(Player player) {
        members.remove(player.getUniqueId());
    }

}
