package com.github.jayreturns.jbbedwars.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.WorldMock;
import com.github.jayreturns.jbbedwars.JBBedwars;
import org.bukkit.Location;
import org.bukkit.World;
import org.junit.jupiter.api.*;

import java.util.Locale;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Disabled // TODO: Fix NPE
public class LocationSerializerTest {

    private ServerMock server;
    private JBBedwars plugin;

    @BeforeAll
    public void setup() {
        server = MockBukkit.mock();
        System.out.println(server);
        plugin = (JBBedwars) MockBukkit.load(JBBedwars.class);
    }

    @AfterAll
    public static void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    public void deserializeLocationWithEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LocationSerializer.getLocationFromString("");
        });
        assertEquals("String is null or empty!", exception.getMessage());
    }

    @Test
    public void deserializeLocationWithNullString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LocationSerializer.getLocationFromString(null);
        });
        assertEquals("String is null or empty!", exception.getMessage());
    }

    @Test
    public void deserializeLocation() {
        World world = new WorldMock();
        Location loc = new Location(world, 1, 2, 3, 4, 5);
        String toTest = String.format(Locale.US, "%s:%f:%f:%f:%f:%f", loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(),
                loc.getYaw(), loc.getPitch());
        assertEquals(toTest, LocationSerializer.getStringFromLocation(loc));
    }

    @Test
    public void serializeLocation() {
        WorldMock worldMock = new WorldMock();
        worldMock.setName("World");
        World world = worldMock;

        String s = "World:1.000000:2.000000:3.000000:4.000000:5.000000";
        Location loc = LocationSerializer.getLocationFromString(s);
        Location toTest = new Location(world, 1, 2, 3, 4, 5);
        assertEquals(loc, toTest);
    }


}
