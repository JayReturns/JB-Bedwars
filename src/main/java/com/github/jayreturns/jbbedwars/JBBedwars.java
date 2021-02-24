package com.github.jayreturns.jbbedwars;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class JBBedwars extends JavaPlugin  {

	@Getter
	private static JBBedwars instance;

	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("Plugin activated");
	}


}
