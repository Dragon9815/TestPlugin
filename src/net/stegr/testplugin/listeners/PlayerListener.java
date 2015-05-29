package net.stegr.testplugin.listeners;

import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.stegr.testplugin.TestPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerListener implements Listener
{
    private final JavaPlugin plugin;

    public PlayerListener(TestPlugin plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event)
    {
        if(event.getPlayer().getItemInHand().getType().equals(Material.BUCKET) && event.getPlayer().getItemInHand().containsEnchantment(Enchantment.ARROW_INFINITE))
        {
            event.getItemStack().setType(Material.BUCKET);
            event.getItemStack().addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

            ItemMeta meta = event.getItemStack().getItemMeta();
            meta.setDisplayName("Unendlich leerer Eimer");

            event.getItemStack().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event)
    {
        if(event.getPlayer().getItemInHand().getType().equals(Material.WATER_BUCKET) && event.getPlayer().getItemInHand().containsEnchantment(Enchantment.ARROW_INFINITE))
        {
            event.getItemStack().setType(Material.WATER_BUCKET);
            event.getItemStack().addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

            ItemMeta meta = event.getItemStack().getItemMeta();
            meta.setDisplayName("Unendlicher Wassereimer");

            event.getItemStack().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        boolean trapped = false;
        Block b;

        b = event.getClickedBlock();

        if(event.getPlayer().isSneaking())
        {
            if (b.getType().equals(Material.CHEST) || b.getType().equals(Material.TRAPPED_CHEST))
            {
                if (b.getType().equals(Material.TRAPPED_CHEST))
                {
                    trapped = true;
                }

                Location loc = b.getLocation();
                //event.getPlayer().sendMessage(loc.toString());
                Location temp;

                temp = loc.clone();
                temp.add(0, 0, 1);
                //event.getPlayer().sendMessage(temp.toString());
                if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
                {
                    event.getPlayer().sendMessage("Double Chest!!!!");
                }

                temp = loc.clone();
                temp.add(1, 0, 0);
                //event.getPlayer().sendMessage(temp.toString());
                if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
                {
                    event.getPlayer().sendMessage("Double Chest!!!!");
                }

                temp = loc.clone();
                temp.add(0, 0, -1);
                //event.getPlayer().sendMessage(temp.toString());
                if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
                {
                    event.getPlayer().sendMessage("Double Chest!!!!");
                }

                temp = loc.clone();
                temp.add(-1, 0, 0);
                //event.getPlayer().sendMessage(temp.toString());
                if ((temp.getBlock().getType().equals(Material.CHEST) && !trapped) || (temp.getBlock().getType().equals(Material.TRAPPED_CHEST) && trapped))
                {
                    event.getPlayer().sendMessage("Double Chest!!!!");
                }

            }
            event.getPlayer().sendMessage(event.getClickedBlock().getType().name());
        }
    }
}
