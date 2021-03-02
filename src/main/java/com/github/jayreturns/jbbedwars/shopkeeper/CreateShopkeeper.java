package com.github.jayreturns.jbbedwars.shopkeeper;

import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

public class CreateShopkeeper implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.getTargetBlockExact(5) != null) {

                Location ShopkeeperLoc = player.getTargetBlockExact(5).getLocation().clone().add(0.5, 1, 0.5);
                LivingEntity shopkeeper = (LivingEntity) player.getWorld().spawnEntity(ShopkeeperLoc, EntityType.VILLAGER);

                Attributable att = (Attributable) shopkeeper;
                att.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1D);
                att.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(10000000D);
                shopkeeper.setGravity(false);
                shopkeeper.setCustomName("Shopkeeper");
                shopkeeper.setCustomNameVisible(false);
                shopkeeper.setInvulnerable(true);
                shopkeeper.setCollidable(false);

            }

        }
        return false;
    }

}
