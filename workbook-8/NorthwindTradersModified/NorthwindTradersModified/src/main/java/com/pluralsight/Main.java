package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url      = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "P@ssw0rd";


        // 1. open a connection to the database
        // use the database URL to point to the correct database
        String query = """
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM   products
                ORDER  BY ProductID
                """;

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(query)) {

            // header
            System.out.printf("%-4s %-35s %-10s %-6s%n",
                    "Id", "Name", "Price", "Stock");
            System.out.printf("%-4s %-35s %-10s %-6s%n",
                    "----", "-----------------------------------", "---------", "------");

            // rows
            while (rs.next()) {
                int    id    = rs.getInt("ProductID");
                String name  = rs.getString("ProductName");
                double price = rs.getDouble("UnitPrice");
                int    stock = rs.getInt("UnitsInStock");

                System.out.printf("%-4d %-35s $%-9.2f %-6d%n",
                        id, name, price, stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3. Close the connection



    }
}