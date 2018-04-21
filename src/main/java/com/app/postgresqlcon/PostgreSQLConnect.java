package main.java.com.app.postgresqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnect {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/arbitrage";/*?useSSL=false*/
    private final String USERNAME = "postgres";
    private final String PASSWORD = "89082d6PRDB@";
    private Connection connection;

    public PostgreSQLConnect(){
         connection = null;
        // try {
        //     DriverManager.registerDriver(new org.postgresql.Driver());
        //     System.out.println("PostgreSQL JDBC Driver Registered!");
        //     connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        // } catch (SQLException e) {
        //     System.out.println("Connection Failed");
        //     e.printStackTrace();
        //     return;
        // }

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
            ex.printStackTrace();
            return;
        }



        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
