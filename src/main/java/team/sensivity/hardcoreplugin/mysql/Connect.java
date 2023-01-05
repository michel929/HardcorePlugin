package team.sensivity.hardcoreplugin.mysql;

import team.sensivity.hardcoreplugin.geheim.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static String url = "jdbc:mysql://192.168.178.200:3306/TeamSensivity";
    static String user = "discord";
    static String pass = MySQL.password;

    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            return con;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
