package com.github.jayreturns.jbbedwars.team;

import org.bukkit.Material;

public enum TeamColor {

    WHITE(),
    ORANGE(),
    MAGENTA(),
    LIGHT_BLUE(),
    YELLOW(),
    LIME(),
    PINK(),
    GRAY(),
    LIGHT_GRAY(),
    CYAN(),
    PURPLE(),
    BLUE(),
    BROWN(),
    GREEN(),
    RED(),
    BLACK();

    public Material getMaterial() {
        return Material.valueOf(this + "_WOOL");
    }

    public Material getBedMaterial() {
        return Material.valueOf(this + "_BED");
    }

}
