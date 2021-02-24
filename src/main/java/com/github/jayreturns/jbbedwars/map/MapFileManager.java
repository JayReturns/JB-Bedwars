package com.github.jayreturns.jbbedwars.map;

import com.github.jayreturns.jbbedwars.JBBedwars;
import com.github.jayreturns.jbbedwars.team.TeamColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

        return new BedwarsMap(name, players, bedLocations, spawnLocations);

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
