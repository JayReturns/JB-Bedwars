package com.github.jayreturns.jbbedwars.map;

import com.github.jayreturns.jbbedwars.JBBedwars;
import com.github.jayreturns.jbbedwars.item.Spawner;
import com.github.jayreturns.jbbedwars.team.TeamColor;
import com.google.common.collect.Lists;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.*;
import java.util.logging.Level;

public class MapFileManager {

    public static BedwarsMap getMapFromFile(File file) {
        FileConfiguration config = LocationProvider.convertFileToConfig(file);
        int players = config.getInt("players");
        String name = config.getString("name");
        Map<TeamColor, Location>[] mapArray = new Map[0];
        try {
            mapArray = LocationProvider.getLocationMaps(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<TeamColor, Location> spawnLocations = mapArray[0];
        Map<TeamColor, Location> bedLocations = mapArray[1];
        List<Spawner> spawners = getSpawnersFromFile(file);

        return new BedwarsMap(name, players, bedLocations, spawnLocations, spawners);
    }

    public static List<Spawner> getSpawnersFromFile(File file) {
        List<Spawner> result = Lists.newArrayList();
        FileConfiguration config = LocationProvider.convertFileToConfig(file);

        ConfigurationSection spawnerSection = config.getConfigurationSection("spawner");
        assert spawnerSection != null;
        spawnerSection.getKeys(false).forEach(key -> {
            String type = key.split("\\.")[1];
            Spawner.ItemType itemType = Spawner.ItemType.valueOf(type.toUpperCase());
            List<String> serializedLocations = config.getStringList("spawner." + key);
            List<Location> deserializedLocations = Lists.newArrayList();
            serializedLocations.forEach(loc -> {
            });
        });

        return null;
    }

    public static List<File> getMapConfigurationFiles(File directory) throws FileNotFoundException {
        if (!directory.exists()) {
            throw new FileNotFoundException("Folder " + directory.getAbsolutePath() + " does not exist!");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("File " + directory.getAbsolutePath() + " is not a directory!");
        }
        if (directory.listFiles() == null) {
            JBBedwars.getInstance().getLogger().log(Level.SEVERE, "Map folder is empty!");
            return null;
        }
        List<File> files = Arrays.asList(Objects.requireNonNull(directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String fileName) {
                return fileName.endsWith(".yml");
            }
        })));
        return null;
    }

    public static List<File> getMapConfigurationFiles() throws FileNotFoundException {
        File file = new File(JBBedwars.getInstance().getDataFolder().getAbsolutePath() + File.separator + "maps");
        return getMapConfigurationFiles(file);
    }

}
