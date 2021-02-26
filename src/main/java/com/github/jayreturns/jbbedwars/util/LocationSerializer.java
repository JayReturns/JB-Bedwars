package com.github.jayreturns.jbbedwars.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Locale;

public class LocationSerializer {

    public static String getStringFromLocation(Location loc) {
        if (loc == null) {
            return "";
        }
        String result = String.format(Locale.US, "%s:%f:%f:%f:%f:%f", loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        return result;
    }

    public static Location getLocationFromString(String s) {
        if (s == null || s.trim().equalsIgnoreCase("")) {
            throw new IllegalArgumentException("String is null or empty!");
        }
        final String[] parts = s.split(":");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Given String doesn't have 6 parts! Parts: " + parts.length);
        }
        World w = Bukkit.getServer().getWorld(parts[0]);
        double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);
        double z = Double.parseDouble(parts[3]);
        float yaw = Float.parseFloat(parts[4]);
        float pitch = Float.parseFloat(parts[5]);
        return  new Location(w, x, y, z, yaw, pitch);
    }


}
