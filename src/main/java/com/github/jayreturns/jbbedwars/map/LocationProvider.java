package com.github.jayreturns.jbbedwars.map;

import com.github.jayreturns.jbbedwars.team.TeamColor;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocationProvider {

    /**
     *
     * @param file
     * @return [Map1: SpawnLocations, Map2: BedLocations]
     * @throws FileNotFoundException
     */
    public Map<TeamColor, Location>[] getLocationMaps(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " not found during spawn location scan");
        }

        Map<TeamColor, Location> spawnLocations = new HashMap<>();
        Map<TeamColor, Location> bedLocations = new HashMap<>();


        FileConfiguration config = convertFileToConfig(file);

        for (String key : config.getConfigurationSection("teams").getKeys(false)) {
            TeamColor color = TeamColor.valueOf(key.split(".")[0].toUpperCase());
            if (!config.isLocation("teams." + key)) continue;
            Location loc = config.getLocation("teams." + key);
            if (key.contains("bed")) {
                bedLocations.put(color, loc);
            } else if (key.contains("spawn")) {
                spawnLocations.put(color, loc);
            }
        }

        Map<TeamColor, Location>[] maps = new Map[]{spawnLocations, bedLocations};
        return maps;
    }

    private FileConfiguration convertFileToConfig(File file) {
        FileConfiguration result = new YamlConfiguration();
        try {
            result.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return result;
    }

}
