package net.stegr.testplugin.group;

import com.sun.istack.internal.NotNull;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Group
{
    private Vector<Member> members;
    private String name;

    public Group(@NotNull String name)
    {
        super();
        this.name = name;
        this.members = new Vector<>();
    }

    public Group()
    {
        this("");
    }

    public Enumeration<? extends Member> getMembers()
    {
        return members.elements();
    }

    public String getName()
    {
        return name;
    }

    public void setName(@NotNull String name)
    {
        this.name = name;
    }

    public boolean addMember(@NotNull Member member)
    {
        if(isMember(member.getName()))
        {
            return false;
        }
        else
        {
            this.members.add(member);
            return true;
        }
    }

    public boolean removeMember(@NotNull String name)
    {
        int index = 0;
        boolean found = false;
        Iterator<Member> iterator;
        Member member;

        iterator = this.members.iterator();

        while(iterator.hasNext())
        {
            member = iterator.next();
            if(member.getName().equals(name))
            {
                found = true;
                break;
            }
            index++;
        }

        if(found)
        {
            this.members.removeElementAt(index);
            return true;
        }

        return false;
    }

    public boolean isMember(String memberName)
    {
        Iterator<Member> iterator = this.members.iterator();
        Member member;

        while (iterator.hasNext())
        {
            member = iterator.next();

            if(member.getName().equals(memberName))
            {
                return true;
            }
        }

        return false;
    }
}
