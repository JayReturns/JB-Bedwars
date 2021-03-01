package com.github.jayreturns.jbbedwars.team;

import lombok.Data;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

@Data
public class SpectatorTeam {

    private Set<UUID> members;

    public boolean isPlayerInTeam(Player player) {
        return members.contains(player.getUniqueId());
    }

    public void addPlayer(Player player) {
        members.add(player.getUniqueId());
    }

}
