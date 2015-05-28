package net.stegr.testplugin.handlers;

import com.sun.javafx.scene.layout.region.Margins;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import sun.plugin2.message.Conversation;

import java.security.Principal;
import java.security.acl.Group;
import java.util.*;

public class CommandHandler
{
    private static JavaPlugin plugin;

    public CommandHandler(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static boolean handleCommand(CommandSender sender, Command cmd, String label, String args[])
    {
        Player p = null;
        if(sender instanceof Player)
            p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("test"))
        {
            if(p != null)
            {
                if(args.length > 0)
                {
                    if(args[0].equalsIgnoreCase("load"))
                    {
                        Set<Group> groups = new HashSet<>();
                        Group group;
                        Enumeration<? extends Principal> members;
                        Principal member;


                        //FileHandler.getGroups(groups);


                        Iterator<Group> it = groups.iterator();
                        while (it.hasNext())
                        {
                            group = it.next();
                            members = group.members();

                            p.sendMessage(group.getName() + ":");
                            while (members.hasMoreElements())
                            {
                                member = members.nextElement();
                                p.sendMessage("  " + member.getName());
                            }


                        }
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("save"))
                    {
                        return true;
                    }
                }
                return false;
            }
        }
        else if(cmd.getName().equalsIgnoreCase("speed"))
        {
            if(args.length > 0)
            {
                if(p != null)
                {
                    float temp = Integer.parseInt(args[0]) * 0.01f;
                    plugin.getLogger().info(String.valueOf(args[0]));
                    plugin.getLogger().info(String.valueOf(temp));
                    p.setFlySpeed(temp);
                    return true;
                }
            }

            return false;
        }

        return false;
    }
}
