package net.stegr.testplugin.handlers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class FileHandler
{
    private static JavaPlugin plugin;

    public FileHandler(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static FileConfiguration ReloadGroupFile()
    {
        File file;

        file = new File(plugin.getDataFolder(), "groups.yml");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return YamlConfiguration.loadConfiguration(file);
    }

    public static void SaveGroupFile(FileConfiguration configFile)
    {
        File file;

        file = new File(plugin.getDataFolder(), "groups.yml");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            configFile.save(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
