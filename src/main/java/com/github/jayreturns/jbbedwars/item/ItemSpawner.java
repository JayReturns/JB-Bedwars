package com.github.jayreturns.jbbedwars.item;

import com.github.jayreturns.jbbedwars.JBBedwars;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ItemSpawner {

    private static List<Spawner> spawners;
    private static BukkitTask task;

    public static void startSpawners() {
        if (task != null) {
            throw new RuntimeException("Task is already started!");
        }
        AtomicLong seconds = new AtomicLong(0);
        task = Bukkit.getScheduler().runTaskTimer(JBBedwars.getInstance(), new Runnable() {
            @Override
            public void run() {
                spawners.forEach(spawner -> {
                    if (seconds.get() % spawner.getSecondsToSpawn() == 0) {
                        spawner.spawnItem();
                    }
                });
                seconds.incrementAndGet();
            }
        }, 0, 20);
    }

    public static boolean areSpawnersActive() {
        return task != null;
    }

    public static void stopSpawners() {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

}
