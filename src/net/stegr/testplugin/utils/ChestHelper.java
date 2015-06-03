package net.stegr.testplugin.utils;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestHelper
{
    JavaPlugin plugin;

    public ChestHelper(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static BlockFace getSecondChest(Location locChest) throws NullPointerException
    {
        if(locChest == null)
        {
            throw new NullPointerException("Location cannot be null!!!");
        }

        Block block = locChest.getBlock();
        boolean trapped = false;

        if (block.getType().equals(Material.CHEST) || block.getType().equals(Material.TRAPPED_CHEST))
        {
            if (block.getType().equals(Material.TRAPPED_CHEST))
            {
                trapped = true;
            }

            Location loc = block.getLocation();
            //event.getPlayer().sendMessage(loc.toString());
            Location temp;

            temp = loc.clone();
            temp.add(0, 0, 1);
            //event.getPlayer().sendMessage(temp.toString());
            if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
            {
                return BlockFace.SOUTH;
            }

            temp = loc.clone();
            temp.add(1, 0, 0);
            //event.getPlayer().sendMessage(temp.toString());
            if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
            {
                return BlockFace.EAST;
            }

            temp = loc.clone();
            temp.add(0, 0, -1);
            //event.getPlayer().sendMessage(temp.toString());
            if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
            {
                return BlockFace.NORTH;
            }

            temp = loc.clone();
            temp.add(-1, 0, 0);
            //event.getPlayer().sendMessage(temp.toString());
            if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
            {
                return BlockFace.WEST;
            }

        }

        return null;
    }
}
