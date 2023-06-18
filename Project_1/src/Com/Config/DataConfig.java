package Com.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataConfig {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/natalia_database";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static Connection connect;
    
    public static Connection getConnection() {
        if (connect == null){
            try {
                connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                System.out.println("Data Base Connected Succes");
            } catch (SQLException e) {
                e.printStackTrace();
    
            }
        }
        return connect;
    }
}