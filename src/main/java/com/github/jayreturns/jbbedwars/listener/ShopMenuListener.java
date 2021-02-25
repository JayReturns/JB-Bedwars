package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.shopkeeper.ShopMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopMenuListener implements Listener {

    public ShopMenuListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase("Shop")){
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            ShopMenu shop = new ShopMenu();

            switch (e.getCurrentItem().getItemMeta().getDisplayName()){
                case "§bQuickBuy":
                    shop.Menu().openShop(player);
                    break;
                case "§eBlocks":
                    shop.Blocks().openShop(player);
                    break;
                case "§eMelees":
                    shop.Melees().openShop(player);
                    break;
                case "§eArmor":
                    shop.Armor().openShop(player);
                    break;
                case "§eTools":
                    shop.Tools().openShop(player);
                    break;
                case "§eBows":
                    shop.Bows().openShop(player);
                    break;
                case "§ePotions":
                    shop.Potions().openShop(player);
                    break;
                case "§eUtils":
                    shop.Utils().openShop(player);
                    break;

            }
        }
    }
}
