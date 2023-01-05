package team.sensivity.hardcoreplugin.mysql;

import java.sql.*;
import java.time.LocalDate;

public class PlayerInfos {
    public static boolean userDead(String uuid){
        boolean b = false;


        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM hardcore";
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                if(uuid.equals(rs.getString("uuid"))){
                    if (rs.getInt("dead") == 1){
                        b = true;
                    }
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

    public static LocalDate getDate(String uuid){
        LocalDate localDate = LocalDate.now();

        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM hardcore";
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                if(uuid.equals(rs.getString("uuid"))){
                    localDate = LocalDate.parse(rs.getString("datum"));
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localDate;
    }

    public static void updatePlayer(String uuid, String row, String neu){
        try {
            Connection con = Connect.getConnection();

            PreparedStatement posted = con.prepareStatement("UPDATE hardcore SET " + row + " = '" + neu + "' WHERE uuid = '" + uuid + "'");

            posted.executeUpdate();
            con.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayer(String uuid, String row, int neu){
        try {
            Connection con = Connect.getConnection();

            PreparedStatement posted = con.prepareStatement("UPDATE hardcore SET " + row + " = '" + neu + "' WHERE uuid = '" + uuid + "'");

            posted.executeUpdate();
            con.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(String id, String row, String table) {
        boolean exist = false;

        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM " + table;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (id.equals(rs.getString(row))) {
                    exist = true;
                }

            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
}
