package net.stegr.testplugin.listeners;

import net.stegr.testplugin.TestPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
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

    }
}
