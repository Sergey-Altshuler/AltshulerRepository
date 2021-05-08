package projectPackage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerUtilClass {
    private final static String URL = "jdbc:mysql://localhost:3306/sergeyjava";
    private final static String password = "root";
    private final static String userName = "root";
    public static Connection get(){
        try{
            return DriverManager.getConnection(URL, userName,password);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}