package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.shopkeeper.ShopMenu;
import com.github.jayreturns.jbbedwars.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ClickShopkeeperListener implements Listener {
    public ClickShopkeeperListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(PlayerInteractEntityEvent e){
        if(e.getRightClicked() instanceof Villager){
            e.setCancelled(true);
            ShopMenu shop = new ShopMenu();
            shop.Menu().openShop(e.getPlayer());
        }
    }

}
