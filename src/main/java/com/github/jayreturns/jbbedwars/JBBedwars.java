package com.github.jayreturns.jbbedwars;

import com.github.jayreturns.jbbedwars.game.GameManager;
import com.github.jayreturns.jbbedwars.listener.PlayerJoinListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class JBBedwars extends JavaPlugin  {

	@Getter
	private static JBBedwars instance;

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("Plugin activated");
		GameManager.MAX_PLAYERS = 8;
		registerListeners();
	}

	private void registerListeners() {
		new PlayerJoinListener(this);
	}

}
