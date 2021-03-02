package com.github.jayreturns.jbbedwars.item;

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
