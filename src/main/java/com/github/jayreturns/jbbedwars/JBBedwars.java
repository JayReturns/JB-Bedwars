package com.github.jayreturns.jbbedwars;

import com.github.jayreturns.jbbedwars.game.GameManager;
import com.github.jayreturns.jbbedwars.listener.ClickShopkeeperListener;
import com.github.jayreturns.jbbedwars.listener.PlayerJoinListener;
import com.github.jayreturns.jbbedwars.listener.ShopMenuListener;
import com.github.jayreturns.jbbedwars.shopkeeper.CreateShopkeeper;
import com.github.jayreturns.jbbedwars.map.BedwarsMap;
import com.github.jayreturns.jbbedwars.util.ConfigManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class JBBedwars extends JavaPlugin {

	@Getter
	private static JBBedwars instance;

	private static ConfigManager configManager;

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("Plugin activated");
		//GameManager.maxPlayers = 8;
		registerListeners();
		registerCommands();
	}

	private void registerListeners() {
		new PlayerJoinListener(this);
		new ClickShopkeeperListener(this);
		new ShopMenuListener(this);
	}

	private void registerCommands() {
		getCommand("shopkeeper").setExecutor(new CreateShopkeeper());
	}

	public static ConfigManager getConfigManager() {
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}

	// For Testing

	public JBBedwars() {
		super();
	}

	protected JBBedwars(JavaPluginLoader loader, PluginDescriptionFile descriptionFile, File dataFolder, File file) {
		super(loader, descriptionFile, dataFolder, file);
	}

}
