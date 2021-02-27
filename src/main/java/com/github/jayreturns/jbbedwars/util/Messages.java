package com.github.jayreturns.jbbedwars.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class Messages {

    public final String PREFIX = ChatColor.YELLOW + "[" + ChatColor.GRAY + "JB-Bedwars" + ChatColor.YELLOW + "] " + ChatColor.RESET;
    public final String CONSOLE_PREFIX = ChatColor.stripColor(PREFIX);
    public final String DEBUG = ChatColor.GRAY + "[" + ChatColor.YELLOW + "DEBUG" + ChatColor.GRAY + "] " + ChatColor.YELLOW;
    public final String ERROR = format("&4[&3Error&4] &r");

    private static String format(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
