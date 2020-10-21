package com.bloggingapp.db;

import java.sql.*;
public class DatabaseConnection {
    private static Connection connect; //declaring static Connection object to be called by other classes
                                        // as per the Singleton design pattern

    private DatabaseConnection() { //privately initializing the Connection object "connect"
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pensedatabase",
                    "root", "password");
        } catch(SQLException e) {
            System.out.println("Error: SQL Exception");
        }
    }

    public static Connection getInstance() { //returns the single Connection object to be used throughout the application
        if(connect == null) {
            try {
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pensedatabase",
                        "root", "Alsim!1707");
            } catch(SQLException e){
                System.out.println("Error: SQL Exception");
            }
        }
        return connect;
    }

    /* main method for testing

    public static void main(String[] args) throws SQLException{
        try {
            DatabaseConnection.getInstance();
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("Not Connected");
        }
    }

     */



}
