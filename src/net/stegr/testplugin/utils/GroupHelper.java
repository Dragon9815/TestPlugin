package net.stegr.testplugin.utils;

import net.stegr.testplugin.group.Group;
import net.stegr.testplugin.group.Member;
import net.stegr.testplugin.handlers.FileHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class GroupHelper
{
    private static JavaPlugin plugin;

    private static List<Group> groupsList;
    private static FileConfiguration configFile;

    public GroupHelper(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static void reloadFile()
    {
        Set<String> groupNames;
        List<String> groupMembers;

        Iterator<String> it;
        Iterator<String> it2;

        Group temp;
        String tempString;

        configFile = FileHandler.ReloadGroupFile();

        groupNames = configFile.getKeys(false);

        groupsList.clear();

        it = groupNames.iterator();
        while(it.hasNext())
        {
            tempString = it.next();
            temp = new Group(tempString);
            plugin.getLogger().info(tempString);

            groupMembers = configFile.getStringList(tempString);

            it2 = groupMembers.iterator();
            while(it2.hasNext())
            {
                tempString = it2.next();
                plugin.getLogger().info(tempString);
                temp.addMember(new Member(tempString));
            }

            groupsList.add(temp);
        }
    }

    /*public static List<Group> getGroups()
    {
        return groupsList;
    }

    public static void setGroups(List<Group> groups)
    {
        groupsList = groups;
    }*/

    public static void saveGroups()
    {
        List<String> groupMembers = new ArrayList<>();
        Enumeration<? extends Member> members;

        configFile = FileHandler.ReloadGroupFile();

        Iterator<Group> groupIterator;

        Group group;
        Member member;

        groupIterator = groupsList.iterator();
        while(groupIterator.hasNext())
        {
            group = groupIterator.next();

            members = group.getMembers();
            while(members.hasMoreElements())
            {
                member = members.nextElement();

                groupMembers.add(member.getName());
            }

            configFile.set(group.getName(), groupMembers);
        }

        FileHandler.SaveGroupFile(configFile);
    }

    public static Group getGroup(String groupName)
    {
        Iterator<Group> iterator = groupsList.iterator();
        Group current;

        while(iterator.hasNext())
        {
            current = iterator.next();
            if(current.getName().equals(groupName))
            {
                return current;
            }
        }

        return null;
    }


    public static boolean addGroup(Group group)
    {
        if(isGroup(group.getName()))
        {
            return false;
        }

        groupsList.add(group);
        return true;
    }

    public static  boolean isGroup(String groupName)
    {
        Iterator<Group> iterator = groupsList.iterator();

        while(iterator.hasNext())
        {
            if(iterator.next().getName().equals(groupName))
            {
                return true;
            }
        }

        return false;
    }


}
