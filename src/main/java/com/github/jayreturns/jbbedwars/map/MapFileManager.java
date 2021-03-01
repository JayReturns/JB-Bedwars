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
import java.util.stream.Stream;

public class MapFileManager {

    public static BedwarsMap getMapFromFile(File file) {
        FileConfiguration config = LocationProvider.convertFileToConfig(file);

        int players = config.getInt("players");
        String name = config.getString("name");
        int numberOfTeams = config.getInt("number_of_teams");
        List<Map<TeamColor, Location>> mapList = getLocationList(file);
        Map<TeamColor, Location> spawnLocations = mapList.get(0);
        Map<TeamColor, Location> bedLocations = mapList.get(1);
        List<Spawner> spawners = getSpawnersFromFile(file);
        List<TeamColor> teamColors = getTeamColors(config);

        return new BedwarsMap(name, players, bedLocations, spawnLocations, spawners, numberOfTeams, teamColors);
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

    private static List<TeamColor> getTeamColors(FileConfiguration config) {
        String teams = config.getString("teamcolors");
        if (teams == null) {
            throw new NullPointerException("teamcolors is null");
        }
        String[] splitted = teams.split("\\.");
        List<TeamColor> result = Lists.newArrayList();
        Stream.of(splitted).map(s -> s.trim().toUpperCase())
                .map(TeamColor::valueOf)
                .forEach(result::add);
        return result;
    }

    private static List<Map<TeamColor, Location>> getLocationList(File file) {
        List<Map<TeamColor, Location>> result = Lists.newArrayList();
        try {
            result = LocationProvider.getLocationMaps(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
