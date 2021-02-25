package com.github.jayreturns.jbbedwars.shopkeeper;

import com.github.jayreturns.jbbedwars.util.ItemBuilder;
import lombok.Data;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@UtilityClass
public class ShopItems {
    //TODO: Give everything a price and setLore() for Items
    @UtilityClass
    public class Blocks{
        ItemStack Wool = new ItemBuilder(Material.WHITE_WOOL, 16).toItemStack();
        ItemStack EndStone = new ItemStack(Material.END_STONE);
        ItemStack Wood = new ItemStack(Material.OAK_PLANKS);
        ItemStack Hard_Clay = new ItemStack(Material.LEGACY_HARD_CLAY);
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
        public class Bows{
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
            ItemStack Invisibility = new ItemBuilder().makePotion(PotionEffectType.INVISIBILITY, 30, 1).toItemStack();
            ItemStack SpeedBoost = new ItemBuilder().makePotion(PotionEffectType.SPEED, 45, 2).toItemStack();
            ItemStack JumpBoost = new ItemBuilder().makePotion(PotionEffectType.JUMP, 45, 5).toItemStack();
    }

    @UtilityClass
    public class Utils{
            ItemStack Fireball = new ItemBuilder(Material.FIRE_CHARGE).setName("§cFireball").toItemStack();
            ItemStack TNT = new ItemStack(Material.TNT);
            ItemStack Golden_Apple = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack Enderperl = new ItemBuilder(Material.ENDER_PEARL).toItemStack();
            ItemStack Water = new ItemBuilder(Material.WATER_BUCKET).toItemStack();
    }
}
