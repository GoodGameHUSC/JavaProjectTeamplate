package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author HunG
 * Date : 2018/06/15
 */
public class Driver {
    
    public static Connection connection;
    
    /**
     * Default connect
     */
    public static void connect() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-V8QN72N\\SQLEXPRESS:1433;databaseName=employee;user=sa;password=123";
            connection = DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Custom databaseName
     * @param databaseName
     */
    public static void connect(String databaseName) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-V8QN72N\\SQLEXPRESS:1433;databaseName="+databaseName+";user=sa;password=123";
            connection = DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Custom databseName, Username and Password
     * @param databaseName
     * @param username
     * @param password
     */
    public static void connect(String databaseName, String username, String password) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-V8QN72N\\SQLEXPRESS:1433;databaseName="+databaseName+";user="+username+";password="+password;
            connection = DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Custom all parameter
     * @param servername
     * @param port
     * @param databaseName
     * @param username
     * @param password
     */
    public static void connect(String servername, String port, String databaseName, String username, String password) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://"+servername+"\\SQLEXPRESS:"+port+";databaseName="+databaseName+";user="+username+";password="+password;
            connection = DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
