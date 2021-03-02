package com.github.jayreturns.jbbedwars.shopkeeper;

import com.github.jayreturns.jbbedwars.item.Spawner;
import com.github.jayreturns.jbbedwars.util.PriceManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@UtilityClass
public class ItemPrices {

    HashMap<ItemStack, ShopItemPrices> materialPrice = new HashMap<>();
    PriceManager pm = new PriceManager();
    public void setItemPrice(){
        materialPrice.put(ShopItems.Blocks.Wool, ShopItemPrices.WOOL);
        materialPrice.put(ShopItems.Blocks.Terracotta, ShopItemPrices.TERRACOTTA);
        materialPrice.put(ShopItems.Blocks.Wood, ShopItemPrices.WOOD);
        materialPrice.put(ShopItems.Blocks.EndStone, ShopItemPrices.ENDSTONE);

        materialPrice.put(ShopItems.Tools.Melees.Stone_Sword, ShopItemPrices.STONE_SWORD);
        materialPrice.put(ShopItems.Tools.Melees.Iron_Sword, ShopItemPrices.IRON_SWORD);
        materialPrice.put(ShopItems.Tools.Melees.Diamond_Sword, ShopItemPrices.DIAMOND_SWORD);
        materialPrice.put(ShopItems.Tools.Melees.Stick, ShopItemPrices.STICK);


    }

    public ShopItemPrices getItemPrice(ItemStack itemStack){
        setItemPrice();
        return materialPrice.get(itemStack);
    }


    @AllArgsConstructor
    @Getter
    public enum ShopItemPrices {
        WOOL(Material.IRON_INGOT, pm.getPrice().getInt("Blocks.wool")),
        TERRACOTTA(Material.IRON_INGOT, pm.getPrice().getInt("Blocks.terracotta")),
        WOOD(Material.IRON_INGOT, pm.getPrice().getInt("Blocks.wood")),
        ENDSTONE(Material.IRON_INGOT, pm.getPrice().getInt("Blocks.endstone")),

        STONE_SWORD(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Melees.stone_sword")),
        IRON_SWORD(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Melees.iron_sword")),
        DIAMOND_SWORD(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Melees.diamond_sword")),
        STICK(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Melees.stick")),

        WOOD_PICKAXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Pickaxe.wood_pickaxe")),
        IRON_PICKAXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Pickaxe.iron_pickaxe")),
        GOLDEN_PICKAXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Pickaxe.golden_pickaxe")),
        DIAMOND_PICKAXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Pickaxe.diamond_pickaxe")),

        WOOD_AXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Axe.wood_axe")),
        IRON_AXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Axe.iron_axe")),
        GOLDEN_AXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Axe.golden_axe")),
        DIAMOND_AXE(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Axe.diamond_axe")),

        ARROW(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Bows.arrow")),
        BOW(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Bows.bow")),
        PWR_BOW(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Bows.pwr_bow")),
        PWRPUNCH_BOW(Material.IRON_INGOT, pm.getPrice().getInt("Tools.Bows.pwrpunch_bow")),

        SHEAR(Material.IRON_INGOT, pm.getPrice().getInt("Tools.shear")),

        CHAIN_ARMOR(Material.IRON_INGOT, pm.getPrice().getInt("Armor.chain_armor")),
        IRON_ARMOR(Material.IRON_INGOT, pm.getPrice().getInt("Armor.iron_armor")),
        DIAMOND_ARMOR(Material.IRON_INGOT, pm.getPrice().getInt("Armor.diamond_armor")),

        INVISIBILITY(Material.IRON_INGOT, pm.getPrice().getInt("Potions.invisibility")),
        SPEED_BOOST(Material.IRON_INGOT, pm.getPrice().getInt("Potions.speed_boost")),
        JUMP_BOOST(Material.IRON_INGOT, pm.getPrice().getInt("Potions.jump_boost")),

        FIREBALL(Material.IRON_INGOT, pm.getPrice().getInt("Utils.Fireball")),
        TNT(Material.IRON_INGOT, pm.getPrice().getInt("Utils.tnt")),
        GOLDEN_APPLE(Material.IRON_INGOT, pm.getPrice().getInt("Utils.golden_apple")),
        ENDERPERL(Material.IRON_INGOT, pm.getPrice().getInt("Utils.enderperl")),
        WATER(Material.IRON_INGOT, pm.getPrice().getInt("Utils.water"));


       @NonNull private final Material material;
       @NonNull private final int price;
    }

}
