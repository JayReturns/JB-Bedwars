package com.github.jayreturns.jbbedwars.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.Material;

@Data
public class Spawner {

    @NonNull private Location location;
    @NonNull private ItemType itemType;

    @AllArgsConstructor
    @Getter
    public enum ItemType {

        IRON(Material.IRON_INGOT),
        GOLD(Material.GOLD_INGOT),
        EMERALD(Material.EMERALD),
        DIAMOND(Material.DIAMOND);

        @NonNull private final Material itemType;

    }

}
