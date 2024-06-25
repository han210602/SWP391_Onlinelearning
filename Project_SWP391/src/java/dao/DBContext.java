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
            String pass = "123456";
            String url = "jdbc:sqlserver://DESKTOP-C7SDOL4\\SQLEXPRESS:1433;databaseName=SE1827_SWP391_OnlineLearning";
=======
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName= SE1827_SWP391_OnlineLearning1";
            String username = "sa";
            String password = "123456";
>>>>>>> Stashed changes
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
