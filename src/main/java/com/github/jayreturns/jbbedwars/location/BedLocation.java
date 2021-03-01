package com.github.jayreturns.jbbedwars.location;

import com.github.jayreturns.jbbedwars.team.BedwarsTeam;
import com.github.jayreturns.jbbedwars.util.UnitPair;
import lombok.Data;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Bed;

@Data
public class BedLocation {

    private Block bedBlock;
    private UnitPair<Location> locations;
    private BedwarsTeam ownerTeam;

    public BedLocation(Location location) {
        Block b = location.getBlock();
        if (!b.getType().toString().contains("BED")) {
            throw new IllegalArgumentException("Location doesn't include a bed");
        }
        bedBlock = b;
        BlockData bData = b.getBlockData();
        Bed bed = (Bed) bData;
        Location second = location.getBlock().getRelative(bed.getFacing(), 1).getLocation();
        locations = new UnitPair<>(location, second);
    }

    public boolean isBed(Location location) {
        return locations.contains(location);
    }

}
