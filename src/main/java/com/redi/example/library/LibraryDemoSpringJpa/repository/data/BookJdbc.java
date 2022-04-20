package com.redi.example.library.LibraryDemoSpringJpa.repository.data;

import java.sql.*;

public class BookJdbc {

    public static void main(String[] args) {
        ResultSet rs = null;
        try (Connection conn =
                     DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/library", "postgres", "varsha")) {

            if (conn != null) {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from book");
                while(rs.next()){
                    System.out.print(rs.getString("title") + "\t");
                    System.out.print(rs.getString("year") + "\t");
                    System.out.print(rs.getString("edition") + "\t");
                }
                } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
