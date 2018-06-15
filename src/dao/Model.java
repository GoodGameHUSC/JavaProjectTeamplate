package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * It is only example model, When using change follow problem required
 * 
 * @author HunG
 *
 */
public class Model {
    /**
     * 
     * @return
     */
    public static ArrayList<Object> read() {
        ArrayList<Object> list = new ArrayList<Object>();
        String sql = "Select * From Bla";
        PreparedStatement cmd;
        try {
            cmd = Driver.connection.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("time");
                Object ob = new Object();
                list.add(ma);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("getData is crash :((");
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 
     * @return
     */
    public static boolean insert() {
        String sql = "INSERT INTO Bla Values(?)";
        try {
            PreparedStatement cmd = Driver.connection.prepareStatement(sql);
            int t = 1;
            Date now = new Date(); 
            Timestamp time = new Timestamp(now.getTime());
            cmd.setTimestamp(1, time);
            int k = cmd.executeUpdate();
            /*
             * Timestamp time = new Timestamp( ob.getNgaySinh().getTime());
                cmd.setTimestamp(t++, time);
             * ...
             */
            cmd.close();
            return k != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public boolean Delete(String id) {
        String sql = "Delete From ChiNhanh Where Id=?";
        PreparedStatement cmd = null;
        try {
            cmd = Driver.connection.prepareStatement(sql);
            cmd.setString(1, id);
            int kq = cmd.executeUpdate();
            cmd.close();
            return kq != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    
    /**
     * 
     * @return
     */
    public static boolean Update() {
        String sql = "Update ChiNhanh Set Column1=?, Conlumn2=? Where Id=?";
        PreparedStatement cmd;
        try {
            cmd = Driver.connection.prepareStatement(sql);
            cmd.setString(1, "bla");
            cmd.setString(2, "blas");
            cmd.setString(3, "blass");
            int kq = cmd.executeUpdate();
            cmd.close();
            return kq != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
