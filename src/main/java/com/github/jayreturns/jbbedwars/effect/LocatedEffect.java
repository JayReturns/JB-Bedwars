package com.github.jayreturns.jbbedwars.effect;

import org.bukkit.Location;

/**
 * Class for effect centered around a specific location
 */
public interface LocatedEffect extends Effect {

    Location getLocation();

}
