package net.stegr.testplugin;

import net.stegr.testplugin.handlers.CommandHandler;
import net.stegr.testplugin.handlers.ConfigurationHandler;
import net.stegr.testplugin.handlers.FileHandler;
import net.stegr.testplugin.handlers.RecipeHandler;
import net.stegr.testplugin.listeners.PlayerListener;
import net.stegr.testplugin.utils.GroupHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.acl.Group;
import java.util.HashSet;
import java.util.Set;

public class TestPlugin extends JavaPlugin
{
    private Set<Group> groups;

    @Override
    public void onEnable()
    {
        new PlayerListener(this);
        new ConfigurationHandler(this);
        new RecipeHandler(this);
        new CommandHandler(this);
        new FileHandler(this);
        new GroupHelper(this);

        groups = new HashSet<>();

        ConfigurationHandler.load();
        RecipeHandler.loadRecipes();

        Player p;

        getLogger().info("Plugin Loaded");
    }

    @Override
    public void onDisable()
    {
        getLogger().info("Plugin Unloaded");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
    {
        return CommandHandler.handleCommand(sender, cmd, label, args);
    }


}
