package com.github.jayreturns.jbbedwars.util;

import org.bukkit.Material;
import org.bukkit.block.data.type.TNT;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(){ this.item = new ItemStack(Material.STONE);}

    public ItemBuilder(ItemStack item){
        this.item = item;
    }

    public ItemBuilder(Material material){
        item = new ItemStack(material, 1);
    }

    public ItemBuilder(Material material, int amount){
        item = new ItemStack(material, amount);
    }
    public ItemBuilder(Material material, int amount, byte durability){
        item = new ItemStack(material, amount, durability);
    }

    public ItemBuilder clone(){
        return new ItemBuilder(item);
    }

    public ItemBuilder setName(String name){
        ItemMeta im = this.item.getItemMeta();
        im.setDisplayName(name);
        this.item.setItemMeta(im);
        return this;
    }


    public ItemBuilder addEntchantment(Enchantment enchantment, int lvl){
        ItemMeta im = this.item.getItemMeta();
        im.addEnchant(enchantment, lvl, false);
        this.item.setItemMeta(im);
        return this;
    }

    public ItemBuilder addEntchantment(Enchantment enchantment, int lvl, boolean showEnchFlag){
        ItemMeta im = this.item.getItemMeta();
        im.addEnchant(enchantment, lvl, false);
        if(!showEnchFlag){im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);}
        this.item.setItemMeta(im);
        return this;
    }

    public ItemBuilder addEntchantment(Enchantment enchantment, int lvl,boolean showEnchFlag, boolean ignLVlRestric){
        ItemMeta im = this.item.getItemMeta();
        im.addEnchant(enchantment, lvl, ignLVlRestric);
        if(!showEnchFlag){im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);}
        this.item.setItemMeta(im);
        return this;
    }

    public ItemBuilder makePotion(PotionEffectType potionEffectType, int duration, int lvl){
        item = new ItemStack(Material.POTION);
        PotionMeta pm = (PotionMeta) item.getItemMeta();
        pm.addCustomEffect(new PotionEffect(potionEffectType, duration, lvl), true);
        item.setItemMeta(pm);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        ItemMeta im = this.item.getItemMeta();
        im.setLore(Arrays.asList(lore.clone()));
        this.item.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack(){
        return item;
    }

}
