package net.stegr.testplugin.handlers;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigurationHandler
{
    private static JavaPlugin plugin;
    //-------- SQL --------------------------------
    public static boolean UseSQL = false;
    public static String SQLIP = "localhost";
    public static int SQLPort= 3306;
    public static String SQLUser = "";
    public static String SQLPassword = "";
    // --------------------------------------------


    public ConfigurationHandler(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static void load()
    {
        plugin.getConfig().addDefault("general.UseSQL", UseSQL);

        plugin.getConfig().addDefault("SQL.IP", SQLIP);
        plugin.getConfig().addDefault("SQL.Port", SQLPort);
        plugin.getConfig().addDefault("SQL.User", SQLUser);
        plugin.getConfig().addDefault("SQL.Password", SQLPassword);

        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();

        UseSQL = plugin.getConfig().getBoolean("general.UseSQL");
        SQLIP = plugin.getConfig().getString("SQL.IP");
        SQLPort = plugin.getConfig().getInt("SQL.Port");
        SQLUser = plugin.getConfig().getString("SQL.User");
        SQLPassword = plugin.getConfig().getString("SQL.Password");
    }
}
