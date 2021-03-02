package com.github.jayreturns.jbbedwars.shopkeeper;

import com.github.jayreturns.jbbedwars.util.ItemBuilder;
import lombok.experimental.UtilityClass;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;


@UtilityClass
public class ShopItems {
    //TODO: Give everything a price and setLore() for Items

    @UtilityClass
    public class Blocks{
        ItemStack Wool = new ItemBuilder(Material.WHITE_WOOL, 16).setLore(ShopItemDescription.WOOL.getLore()).toItemStack();
        ItemStack EndStone = new ItemStack(Material.END_STONE);
        ItemStack Wood = new ItemStack(Material.OAK_PLANKS);
        ItemStack Terracotta = new ItemStack(Material.TERRACOTTA);
    }

    @UtilityClass
    public class Tools{

        @UtilityClass
        public class Melees {
            ItemStack Wood_Sword = new ItemStack(Material.WOODEN_SWORD);
            ItemStack Stone_Sword = new ItemStack(Material.STONE_SWORD);
            ItemStack Iron_Sword = new ItemStack(Material.IRON_SWORD);
            ItemStack Diamond_Sword = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack Stick = new ItemBuilder(Material.STICK).addEntchantment(Enchantment.KNOCKBACK, 1).toItemStack();
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
            ItemStack Wood_Axe = new ItemBuilder(Material.WOODEN_AXE).toItemStack();
            ItemStack Iron_Axe = new ItemBuilder(Material.IRON_AXE).addEntchantment(Enchantment.DIG_SPEED, 1).toItemStack();
            ItemStack Golden_Axe = new ItemBuilder(Material.GOLDEN_AXE).addEntchantment(Enchantment.DIG_SPEED, 2).toItemStack();
            ItemStack Diamond_Axe = new ItemBuilder(Material.DIAMOND_AXE).addEntchantment(Enchantment.DIG_SPEED, 3).toItemStack();
        }

        @UtilityClass
        public class Bows {
            ItemStack Bow = new ItemBuilder(Material.BOW).toItemStack();
            ItemStack PwrBow = new ItemBuilder(Material.BOW).addEntchantment(Enchantment.ARROW_DAMAGE, 1).toItemStack();
            ItemStack PwrPunchBow = new ItemBuilder(Material.BOW).addEntchantment(Enchantment.ARROW_DAMAGE, 1).addEntchantment(Enchantment.ARROW_KNOCKBACK, 1).toItemStack();
            ItemStack Arrow = new ItemBuilder(Material.ARROW, 8).toItemStack();
        }

        ItemStack Shear = new ItemStack(Material.SHEARS);

    }
    @UtilityClass
    public class Armor{
        @UtilityClass
        public class Leggings{
            ItemStack Chain_Leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemStack Iron_Leggings = new ItemStack(Material.IRON_LEGGINGS);
            ItemStack Golden_Leggings = new ItemStack(Material.GOLDEN_LEGGINGS);
            ItemStack Diamond_Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        }

        @UtilityClass
        public class Boots{
            ItemStack Chain_Boots = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemStack Iron_Boots = new ItemStack(Material.IRON_BOOTS);
            ItemStack Golden_Boots = new ItemStack(Material.GOLDEN_BOOTS);
            ItemStack Diamond_Boots = new ItemStack(Material.DIAMOND_BOOTS);
        }
    }

    @UtilityClass
    public class Potions{
            ItemStack Invisibility = new ItemBuilder().setName("Invisibility").makePotion(PotionEffectType.INVISIBILITY, 30, 1, Color.GRAY).toItemStack();
            ItemStack SpeedBoost = new ItemBuilder().setName("SpeedBoost").makePotion(PotionEffectType.SPEED, 45, 2, Color.SILVER).toItemStack();
            ItemStack JumpBoost = new ItemBuilder().setName("JumpBoost").makePotion(PotionEffectType.JUMP, 45, 5, Color.LIME).toItemStack();
    }

    @UtilityClass
    public class Utils{

            ItemStack Fireball = new ItemBuilder(Material.FIRE_CHARGE).setName("§cFireball").toItemStack();
            ItemStack TNT = new ItemStack(Material.TNT);
            ItemStack Golden_Apple = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack Enderperl = new ItemBuilder(Material.ENDER_PEARL).toItemStack();
            ItemStack Water = new ItemBuilder(Material.WATER_BUCKET).toItemStack();
    }

    public ArrayList getItems(){
        ArrayList<ItemStack> items = new ArrayList<>();
        items.add(Blocks.EndStone);
        items.add(Blocks.Wool);
        items.add(Blocks.Wood);
        items.add(Blocks.Terracotta);

        items.add(Tools.PickAxe.Wood_Pickaxe);
        items.add(Tools.PickAxe.Diamond_Pickaxe);
        items.add(Tools.PickAxe.Golden_Pickaxe);
        items.add(Tools.PickAxe.Iron_Pickaxe);

        items.add(Tools.Bows.Arrow);
        items.add(Tools.Bows.Bow);
        items.add(Tools.Bows.PwrBow);
        items.add(Tools.Bows.PwrPunchBow);

        items.add(Tools.Melees.Diamond_Sword);
        items.add(Tools.Melees.Iron_Sword);
        items.add(Tools.Melees.Stone_Sword);
        items.add(Tools.Melees.Wood_Sword);
        items.add(Tools.Melees.Stick);

        items.add(Tools.Axe.Wood_Axe);
        items.add(Tools.Axe.Diamond_Axe);
        items.add(Tools.Axe.Golden_Axe);
        items.add(Tools.Axe.Iron_Axe);


        items.add(Tools.Shear);

        items.add(Utils.Golden_Apple);
        items.add(Utils.Enderperl);
        items.add(Utils.TNT);
        items.add(Utils.Fireball);
        items.add(Utils.Water);

        items.add(Potions.Invisibility);
        items.add(Potions.JumpBoost);
        items.add(Potions.SpeedBoost);

        items.add(Armor.Boots.Chain_Boots);
        items.add(Armor.Boots.Iron_Boots);
        items.add(Armor.Boots.Golden_Boots);
        items.add(Armor.Boots.Diamond_Boots);

        return items;
    }
}
