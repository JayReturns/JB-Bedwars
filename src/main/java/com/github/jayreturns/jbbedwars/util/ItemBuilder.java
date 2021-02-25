package com.github.jayreturns.jbbedwars.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    private ItemStack item;

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

    public ItemBuilder addEntchantment(Enchantment enchantment, int lvl, boolean ignLVlRestric){
        ItemMeta im = this.item.getItemMeta();
        im.addEnchant(enchantment, lvl, ignLVlRestric);
        this.item.setItemMeta(im);
        return this;
    }
    public ItemBuilder addEntchantment(Enchantment enchantment, int lvl){
        ItemMeta im = this.item.getItemMeta();
        im.addEnchant(enchantment, lvl, false);
        this.item.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(List<String> lore){
        ItemMeta im = this.item.getItemMeta();
        im.setLore(lore);
        this.item.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack(){
        return item;
    }

}
