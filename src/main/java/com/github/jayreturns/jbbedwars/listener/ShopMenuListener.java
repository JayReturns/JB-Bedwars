package com.github.jayreturns.jbbedwars.listener;

import com.github.jayreturns.jbbedwars.JBBedwars;
import com.github.jayreturns.jbbedwars.shopkeeper.ItemPrices;
import com.github.jayreturns.jbbedwars.shopkeeper.ShopItems;
import com.github.jayreturns.jbbedwars.shopkeeper.ShopMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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

            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
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

            if(ShopItems.getItems().contains(e.getCurrentItem())) {
                Material value = ItemPrices.getItemPrice(e.getCurrentItem()).getMaterial();
                Integer price = ItemPrices.getItemPrice(e.getCurrentItem()).getPrice();
                ItemStack cost = new ItemStack(value, price);



                if (player.getInventory().containsAtLeast(cost, price)) {
                    player.getInventory().removeItem(cost);

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            ItemStack item = e.getCurrentItem();
                            ItemMeta im = item.getItemMeta();
                            im.setLore(null);
                            item.setItemMeta(im);
                            player.getInventory().addItem(item);
                        }
                    }.runTaskLater(JBBedwars.getInstance(), 2);
                }else{
                    String text = ChatColor.translateAlternateColorCodes('&', "&cYou can´t purchase that, u need " + price.toString() + " " + value.name());
                    text = text.replace("IRON_INGOT", "Iron");
                    text = text.replace("GOLDEN_INGOT", "Gold");
                    text = text.replace("EMERALD", "Emerald");

                    player.sendMessage(text);
                }
            }
        }
    }
}
