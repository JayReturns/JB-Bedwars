package com.github.jayreturns.jbbedwars.map;

import com.github.jayreturns.jbbedwars.team.TeamColor;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class LocationProvider {

    public Map<TeamColor, Location> getSpawnLocationMap(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " not found during spawn location scan");
        }

        FileConfiguration config = convertFileToConfig(file);

        return null;
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
