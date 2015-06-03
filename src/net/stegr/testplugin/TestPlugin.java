package net.stegr.testplugin;

import net.stegr.testplugin.handlers.CommandHandler;
import net.stegr.testplugin.handlers.ConfigurationHandler;
import net.stegr.testplugin.handlers.FileHandler;
import net.stegr.testplugin.handlers.RecipeHandler;
import net.stegr.testplugin.listeners.PlayerListener;
import net.stegr.testplugin.registers.ChestRegister;
import net.stegr.testplugin.registers.GroupRegister;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        new PlayerListener(this);
        new ConfigurationHandler(this);
        new RecipeHandler(this);
        new CommandHandler(this);
        new FileHandler(this);
        new GroupRegister(this);
        new ChestRegister(this);

        ConfigurationHandler.load();
        RecipeHandler.loadRecipes();

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
