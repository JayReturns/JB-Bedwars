package com.github.jayreturns.jbbedwars.shopkeeper;

import com.github.jayreturns.jbbedwars.util.ItemBuilder;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShopMenu {
    private Inventory shop = Bukkit.createInventory(null, 9*6, "Shop");

    public ShopMenu(){
        shop.clear();
//      QuickBuy
//      shop.setItem(0, new ItemBuilder(Material.NETHER_STAR).setName("§bQuickBuy").setLore(" ").toItemStack());
        shop.setItem(1, new ItemBuilder(Material.TERRACOTTA).setName("§eBlocks").setLore("§aClick to Buy").toItemStack());
        shop.setItem(2, new ItemBuilder(Material.STONE_SWORD).setName("§eMelees").setLore("§aClick to Buy").toItemStack());
        shop.setItem(3, new ItemBuilder(Material.IRON_BOOTS).setName("§eArmor").setLore("§aClick to Buy").toItemStack());
        shop.setItem(4, new ItemBuilder(Material.GOLDEN_PICKAXE).setName("§eTools").setLore("§aClick to Buy").toItemStack());
        shop.setItem(5, new ItemBuilder(Material.BOW).setName("§eBows").setLore("§aClick to Buy").toItemStack());
        shop.setItem(6, new ItemBuilder(Material.BREWING_STAND).setName("§ePotions").setLore("§aClick to Buy").toItemStack());
        shop.setItem(7, new ItemBuilder(Material.TNT).setName("§eUtils").setLore("§aClick to Buy").toItemStack());

        for(int a = 9; a < 18; a++){

            shop.setItem(a, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());
        }
    }

    public ShopMenu Menu(){
        shop.setItem(9, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Utils.Fireball);
        shop.setItem(1+9*3, ShopItems.Utils.Golden_Apple);
        shop.setItem(1+9*4, ShopItems.Tools.PickAxe.Wood_Pickaxe);

        shop.setItem(2+9*2, ShopItems.Tools.Melees.Stone_Sword);
        shop.setItem(2+9*3, ShopItems.Tools.Melees.Iron_Sword);
        shop.setItem(2+9*4, ShopItems.Tools.Melees.Diamond_Sword);

        shop.setItem(3+9*2, ShopItems.Armor.Boots.Chain_Boots);
        shop.setItem(3+9*3, ShopItems.Armor.Boots.Iron_Boots);
        shop.setItem(3+9*4, ShopItems.Armor.Boots.Diamond_Boots);

        shop.setItem(4+9*2, ShopItems.Blocks.Wool);
        shop.setItem(4+9*3, ShopItems.Tools.Shear);
        shop.setItem(4+9*4, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§cEmpty").toItemStack());

        shop.setItem(5+9*2, ShopItems.Tools.Bows.Bow);
        shop.setItem(5+9*3, ShopItems.Tools.Bows.Arrow);
        shop.setItem(5+9*4, ShopItems.Tools.Axe.Wood_Axe);

        shop.setItem(6+9*2, ShopItems.Potions.Invisibility);
        shop.setItem(6+9*3, ShopItems.Potions.SpeedBoost);
        shop.setItem(6+9*4, ShopItems.Potions.JumpBoost);

        shop.setItem(7+9*2, ShopItems.Utils.TNT);
        shop.setItem(7+9*3, ShopItems.Utils.Water);
        shop.setItem(7+9*4, ShopItems.Utils.Enderperl);

        return this;
    }

    public ShopMenu Blocks(){
        shop.setItem(10, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Blocks.Wool);
        shop.setItem(2+9*2, ShopItems.Blocks.Terracotta);
        shop.setItem(3+9*2, ShopItems.Blocks.Wood);
        shop.setItem(4+9*2, ShopItems.Blocks.EndStone);
        return this;
    }

    public ShopMenu Melees(){
        shop.setItem(11, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Tools.Melees.Stone_Sword);
        shop.setItem(2+9*2, ShopItems.Tools.Melees.Iron_Sword);
        shop.setItem(3+9*2, ShopItems.Tools.Melees.Diamond_Sword);
        shop.setItem(4+9*2, ShopItems.Tools.Melees.Stick);

        return this;
    }

    public ShopMenu Armor(){
        shop.setItem(12, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Armor.Boots.Chain_Boots);
        shop.setItem(2+9*2, ShopItems.Armor.Boots.Iron_Boots);
        shop.setItem(3+9*2, ShopItems.Armor.Boots.Diamond_Boots);

        return this;
    }

    public ShopMenu Tools(){
        shop.setItem(13, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Tools.Shear);
        shop.setItem(2+9*2, ShopItems.Tools.PickAxe.Wood_Pickaxe);
        shop.setItem(3+9*2, ShopItems.Tools.Axe.Wood_Axe);

        return this;
    }

    public ShopMenu Bows(){
        shop.setItem(14, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Tools.Bows.Arrow);
        shop.setItem(2+9*2, ShopItems.Tools.Bows.Bow);
        shop.setItem(3+9*2, ShopItems.Tools.Bows.PwrBow);
        shop.setItem(4+9*2, ShopItems.Tools.Bows.PwrPunchBow);

        return this;
    }

    public ShopMenu Potions(){
        shop.setItem(15, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());

        shop.setItem(1+9*2, ShopItems.Potions.Invisibility);
        shop.setItem(2+9*2, ShopItems.Potions.SpeedBoost);
        shop.setItem(3+9*2, ShopItems.Potions.JumpBoost);

        return this;
    }

    public ShopMenu Utils(){
        shop.setItem(16, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§f\u2191Categories").setLore("§f\u2193Items").toItemStack());



        return this;
    }

    public ShopMenu clone(){
        return new ShopMenu();
    }

    public void openShop(Player player){
        player.openInventory(shop);
    }

    public Inventory toInventory(){
        return shop;
    }
}
