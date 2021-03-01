package com.github.jayreturns.jbbedwars.util;

import com.github.jayreturns.jbbedwars.JBBedwars;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class ConfigManager {

    @Getter
    private FileConfiguration settings;

    private final String FILE_NAME = "settings.yml";

    @SneakyThrows(IOException.class)
    public ConfigManager() {
        if (!JBBedwars.getInstance().getDataFolder().exists()) {
            if (JBBedwars.getInstance().getDataFolder().mkdir()) {
                System.out.println(Messages.CONSOLE_PREFIX + JBBedwars.getInstance().getDataFolder().getPath() + " successfully created!");
            } else {
                System.out.println(Messages.ERROR + "An error occured during creation of " + JBBedwars.getInstance().getDataFolder().getPath());
            }
        }

        File f = new File(JBBedwars.getInstance().getDataFolder(), FILE_NAME);
        if (!f.exists()) {
            f.createNewFile();
        }

        settings = YamlConfiguration.loadConfiguration(f);

        setDefaults();
    }

    @SneakyThrows(IOException.class)
    public void saveSettingsFile() {
        File f = new File(JBBedwars.getInstance().getDataFolder(), FILE_NAME);
        if (!f.exists()) {
            throw new FileNotFoundException(FILE_NAME + " not found!");
        }
        settings.save(f);
    }

    private void setDefaults() {
        settings.options().copyDefaults(true);
        settings.options().header("Change values to alter settings");
        settings.addDefault("spawners.iron", 2);
        settings.addDefault("spawners.gold", 3);
        settings.addDefault("spawners.emerald", 4);
        settings.addDefault("spawners.diamond", 5);
        saveSettingsFile();
    }

}
