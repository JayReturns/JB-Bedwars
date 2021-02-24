package com.github.jayreturns.jbbedwars.team;

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

    public boolean isMemberOfTeam(Player player) {
        return members.contains(player.getUniqueId());
    }

}
