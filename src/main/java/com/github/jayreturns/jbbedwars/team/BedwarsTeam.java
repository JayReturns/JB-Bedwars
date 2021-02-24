package com.github.jayreturns.jbbedwars.team;

import lombok.Data;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.UUID;

@Data
public class BedwarsTeam {

    private UUID[] members;
    private boolean isAlive;
    @NonNull
    private TeamColor teamColor;
    @NonNull
    private Location bedLocation;

    public boolean isMemberOfTeam(Player player) {
        return Arrays.asList(members).contains(player.getUniqueId());
    }

}
