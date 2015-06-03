package net.stegr.testplugin.chest;

import com.sun.istack.internal.NotNull;
import net.stegr.testplugin.group.Group;
import net.stegr.testplugin.group.Member;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public class LockedChest
{
    private Location location;
    private ChestLockType lockType;
    private Group lockGroup;
    private Member owner;
    private boolean doubleChest;
    private BlockFace secondLocation;

    public LockedChest(Location loc, Member owner, Group lockGroup, ChestLockType lockType)
    {
        this.location = loc;
        this.owner = owner;
        this.lockType = lockType;
        this.lockGroup = lockGroup;
    }

    public void setLockType(ChestLockType lockType)
    {
        this.lockType = lockType;
    }

    public ChestLockType getLockType()
    {
        return this.lockType;
    }

    public boolean getLocked()
    {
        return this.lockType != ChestLockType.Public;
    }

    public Member getOwner()
    {
        return this.owner;
    }

    public Group getLockGroup()
    {
        return lockGroup;
    }

    public void setLockGroup(Group lockGroup)
    {
        this.lockGroup = lockGroup;
    }

    public void setDoubleChest(boolean isDoubleChest, BlockFace secondChest)
    {
        this.doubleChest = isDoubleChest;
        this.secondLocation = secondChest;
    }

    public boolean isDoubleChest()
    {
        return this.doubleChest;
    }

    public BlockFace secondChest()
    {
        return this.secondLocation;
    }

    public Location getLocation()
    {
        return this.location;
    }
}
