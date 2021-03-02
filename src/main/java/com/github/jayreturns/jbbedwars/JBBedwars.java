package com.github.jayreturns.jbbedwars;

import com.github.jayreturns.jbbedwars.listener.BedDestroyListener;
import com.github.jayreturns.jbbedwars.listener.ClickShopkeeperListener;
import com.github.jayreturns.jbbedwars.listener.PlayerConnectionListener;
import com.github.jayreturns.jbbedwars.listener.ShopMenuListener;
import com.github.jayreturns.jbbedwars.shopkeeper.CreateShopkeeper;
import lombok.Getter;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class JBBedwars extends JavaPlugin {

	@Getter
	private static JBBedwars instance;

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("Plugin activated");
		//GameManager.maxPlayers = 8;
		registerListeners();
		registerCommands();
	}

	private void registerListeners() {
		new PlayerConnectionListener(this);
		new BedDestroyListener(this);

		new ClickShopkeeperListener(this);
		new ShopMenuListener(this);
	}

	private void registerCommands() {
		getCommand("shopkeeper").setExecutor(new CreateShopkeeper());
	}


	// For Testing

	public JBBedwars() {
		super();
	}

	protected JBBedwars(JavaPluginLoader loader, PluginDescriptionFile descriptionFile, File dataFolder, File file) {
		super(loader, descriptionFile, dataFolder, file);
	}

}
