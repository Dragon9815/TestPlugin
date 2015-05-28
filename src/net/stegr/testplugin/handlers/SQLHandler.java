package net.stegr.testplugin.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHandler
{
    private static Connection connection;

    // TODO: SQL-Speicherung
    public static void connect(String IP, int Port, String User, String Password) throws SQLException
    {
        connection = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + Port + "/" + User, User, Password);
    }
}
