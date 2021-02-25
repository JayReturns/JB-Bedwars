package com.github.jayreturns.jbbedwars.shopkeeper;

import com.github.jayreturns.jbbedwars.util.ItemBuilder;
import lombok.Data;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class ShopItems {

    @UtilityClass
    public class Blocks{
        ItemStack Wool = new ItemStack(Material.WHITE_WOOL);
        ItemStack EndStone = new ItemStack(Material.END_STONE);
        ItemStack Wood = new ItemStack(Material.OAK_PLANKS);
        ItemStack Hard_Clay = new ItemStack(Material.LEGACY_HARD_CLAY);
    }

    @UtilityClass
    public class Tools{

        @UtilityClass
        public class Sword {
            ItemStack Wood_Sword = new ItemStack(Material.WOODEN_SWORD);
            ItemStack Stone_Sword = new ItemStack(Material.STONE_SWORD);
            ItemStack Iron_Sword = new ItemStack(Material.IRON_SWORD);
            ItemStack Diamond_Sword = new ItemStack(Material.DIAMOND_SWORD);
        }

        @UtilityClass
        public class PickAxe {
            ItemStack Wood_Pickaxe = new ItemBuilder(Material.WOODEN_PICKAXE).addEntchantment(Enchantment.DIG_SPEED, 1).toItemStack();
            ItemStack Iron_Pickaxe = new ItemBuilder(Material.IRON_PICKAXE).addEntchantment(Enchantment.DIG_SPEED, 2).toItemStack();
            ItemStack Golden_Pickaxe = new ItemBuilder(Material.GOLDEN_PICKAXE).addEntchantment(Enchantment.DIG_SPEED, 3).toItemStack();
            ItemStack Diamond_Pickaxe = new ItemBuilder(Material.DIAMOND_PICKAXE).addEntchantment(Enchantment.DIG_SPEED, 4).toItemStack();
        }

        @UtilityClass
        public class Axe {
            ItemStack Wood_Axe = new ItemBuilder(Material.WOODEN_AXE).addEntchantment(Enchantment.DIG_SPEED, 1).toItemStack();
            ItemStack Iron_Axe = new ItemBuilder(Material.IRON_AXE).addEntchantment(Enchantment.DIG_SPEED, 2).toItemStack();
            ItemStack Golden_Axe = new ItemBuilder(Material.GOLDEN_AXE).addEntchantment(Enchantment.DIG_SPEED, 3).toItemStack();
            ItemStack Diamond_Axe = new ItemBuilder(Material.DIAMOND_AXE).addEntchantment(Enchantment.DIG_SPEED, 4).toItemStack();
        }

    }

    @UtilityClass
    public class Utils{
            ItemStack Fireball = new ItemBuilder(Material.FIRE_CHARGE).setName("Fireball").toItemStack();
    }
}
