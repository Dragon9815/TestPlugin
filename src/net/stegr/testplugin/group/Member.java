package net.stegr.testplugin.group;

import java.util.Vector;

public class Member
{
    private String name;

    public Member(String name)
    {
        super();
        this.name = name;
    }

    public Member()
    {
        super();
        this.name = "";
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
