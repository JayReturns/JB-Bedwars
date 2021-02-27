package com.github.jayreturns.jbbedwars.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Data
public class Spawner {

    @NonNull private Location location;
    @NonNull private ItemType itemType;
    @NonNull private int secondsToSpawn;

    public void spawnItem() {
        location.getWorld().dropItemNaturally(location, getItemStack());
    }

    private ItemStack getItemStack() {
        return new ItemStack(this.getItemType().getMaterial());
    }

    @AllArgsConstructor
    @Getter
    public enum ItemType {

        IRON(Material.IRON_INGOT),
        GOLD(Material.GOLD_INGOT),
        EMERALD(Material.EMERALD),
        DIAMOND(Material.DIAMOND);

        @NonNull private final Material material;

    }

}
