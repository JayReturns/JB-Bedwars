package com.github.jayreturns.jbbedwars.shopkeeper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.ChatColor;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public enum ShopItemDescription {

    WOOL("&7Cost: &f4 Iron; ;&7DESCRIPTION");





    private final String lore;

    public String[] getLore() {
        String[] arrayList;
        String colorLore;
        colorLore = ChatColor.translateAlternateColorCodes('&', lore);
        arrayList = colorLore.split(";");
        return arrayList;
    }
}
