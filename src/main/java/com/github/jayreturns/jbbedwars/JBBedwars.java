package com.github.jayreturns.jbbedwars;

import com.github.jayreturns.jbbedwars.game.GameManager;
import com.github.jayreturns.jbbedwars.listener.ClickShopkeeperListener;
import com.github.jayreturns.jbbedwars.listener.PlayerJoinListener;
import com.github.jayreturns.jbbedwars.listener.ShopMenuListener;
import com.github.jayreturns.jbbedwars.shopkeeper.CreateShopkeeper;
import com.github.jayreturns.jbbedwars.map.BedwarsMap;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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
		new PlayerJoinListener(this);
		new ClickShopkeeperListener(this);
		new ShopMenuListener(this);
	}

	private void registerCommands() {
		getCommand("shopkeeper").setExecutor(new CreateShopkeeper());
	}
}
