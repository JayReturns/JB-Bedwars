package com.github.jayreturns.jbbedwars.shopkeeper;

import com.github.jayreturns.jbbedwars.team.BedwarsTeam;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CreateShopkeeper implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Entity shopkeeper = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.ENDERMAN);

            shopkeeper.setGravity(false);
            shopkeeper.setCustomName("Shopkeeper");
            shopkeeper.setCustomNameVisible(false);


        }
        return false;
    }
}
