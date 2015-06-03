package net.stegr.testplugin.registers;

import net.stegr.testplugin.chest.LockedChest;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import java.util.List;

public class ChestRegister
{
    private static JavaPlugin plugin;
    private static List<LockedChest> chests;

    public ChestRegister(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static void registerChest(LockedChest chest) throws NullPointerException
    {
        if(chest == null)
        {
            throw new NullPointerException("Chest cannot be null!!!");
        }

        chests.add(chest);
    }

    public static void unregisterChest(Location locChest) throws NullPointerException
    {
        if(locChest == null)
        {
            throw new NullPointerException("Location cannot be null!!!");
        }

        Iterator<LockedChest> iteratorChests = chests.iterator();
        LockedChest chest;

        while(iteratorChests.hasNext())
        {
            chest = iteratorChests.next();

            if(chest.getLocation().equals(locChest))
            {
                chests.remove(chest);
                return;
            }
        }
    }

    public static boolean isRegistered(Location locChest)
    {
        Iterator<LockedChest> iteratorChests = chests.iterator();
        LockedChest chest;

        while(iteratorChests.hasNext())
        {
            chest = iteratorChests.next();

            if(chest.getLocation().equals(locChest))
            {
                return true;
            }
        }

        return false;
    }
}
