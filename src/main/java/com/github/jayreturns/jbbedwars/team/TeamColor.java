package com.github.jayreturns.jbbedwars.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;

@AllArgsConstructor
@Getter
public enum TeamColor {

    WHITE(Material.WHITE_WOOL),
    ORANGE(Material.ORANGE_WOOL),
    MAGENTA(Material.MAGENTA_WOOL),
    LIGHT_BLUE(Material.LIGHT_BLUE_WOOL),
    YELLOW(Material.YELLOW_WOOL),
    LIME(Material.LIME_WOOL),
    PINK(Material.PINK_WOOL),
    GRAY(Material.GRAY_WOOL),
    LIGHT_GRAY(Material.LIGHT_GRAY_WOOL),
    CYAN(Material.CYAN_WOOL),
    PURPLE(Material.PURPLE_WOOL),
    BLUE(Material.BLUE_WOOL),
    BROWN(Material.BROWN_WOOL),
    GREEN(Material.GREEN_WOOL),
    RED(Material.RED_WOOL),
    BLACK(Material.BLACK_WOOL);

    public Material material;

}
