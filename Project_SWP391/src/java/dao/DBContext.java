package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public Connection connection;
    public DBContext()
    {
<<<<<<< Updated upstream
        try{
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://DESKTOP-L6HTHLK\\KHOINGUYEN;databaseName=SWP3911";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to close the database connection.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        dbContext.closeConnection();
    }
}
