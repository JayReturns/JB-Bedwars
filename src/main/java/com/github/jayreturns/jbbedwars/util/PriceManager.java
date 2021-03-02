package com.github.jayreturns.jbbedwars.util;

import com.github.jayreturns.jbbedwars.JBBedwars;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PriceManager {

    @Getter
    private FileConfiguration price;

    private final String FILE_NAME = "price.yml";

    @SneakyThrows(IOException.class)
    public PriceManager() {
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

        price = YamlConfiguration.loadConfiguration(f);

        setDefaults();
    }

    @SneakyThrows(IOException.class)
    public void savePriceFile() {
        File f = new File(JBBedwars.getInstance().getDataFolder(), FILE_NAME);
        if (!f.exists()) {
            throw new FileNotFoundException(FILE_NAME + " not found!");
        }
        price.save(f);
    }

    private void setDefaults() {
        price.options().copyDefaults(true);
        price.options().header("Change values to alter price");
        price.addDefault("Blocks.wool", 4);
        price.addDefault("Blocks.terracotta", 8);
        price.addDefault("Blocks.wood", 8);
        price.addDefault("Blocks.endstone", 16);

        price.addDefault("Tools.Melees.wood_sword", 4);
        price.addDefault("Tools.Melees.stone_sword", 8);
        price.addDefault("Tools.Melees.iron_sword", 8);
        price.addDefault("Tools.Melees.diamond_sword", 16);
        price.addDefault("Tools.Melees.stick", 16);

        price.addDefault("Tools.Pickaxe.wood_pickaxe", 4);
        price.addDefault("Tools.Pickaxe.iron_pickaxe", 8);
        price.addDefault("Tools.Pickaxe.golden_pickaxe", 8);
        price.addDefault("Tools.Pickaxe.diamond_pickaxe", 16);

        price.addDefault("Tools.Axe.wood_axe", 4);
        price.addDefault("Tools.Axe.iron_axe", 8);
        price.addDefault("Tools.Axe.golden_axe", 8);
        price.addDefault("Tools.Axe.diamond_axe", 16);

        price.addDefault("Tools.Bows.arrow", 4);
        price.addDefault("Tools.Bows.bow", 8);
        price.addDefault("Tools.Bows.pwr_bow", 8);
        price.addDefault("Tools.Bows.pwrpunch_bow", 16);

        price.addDefault("Tools.shear", 4);

        price.addDefault("Armor.chain_armor", 4);
        price.addDefault("Armor.iron_armor", 8);
        price.addDefault("Armor.golden_armor", 8);
        price.addDefault("Armor.diamond_armor", 16);

        price.addDefault("Potions.invisibility", 4);
        price.addDefault("Potions.speed_boost", 8);
        price.addDefault("Potions.jump_boost", 8);

        price.addDefault("Utils.Fireball", 4);
        price.addDefault("Utils.tnt", 8);
        price.addDefault("Utils.golden_apple", 8);
        price.addDefault("Utils.enderperl", 16);
        price.addDefault("Utils.water", 16);

        savePriceFile();
    }

}
