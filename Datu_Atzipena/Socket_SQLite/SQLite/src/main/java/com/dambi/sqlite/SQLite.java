package com.dambi.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SQLite {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */

    private static Connection connect() {
        // SQLite connection string
        String url2 = "jdbc:sqlite:C:/sqlite/db/test.db";
        String url = "jdbc:sqlite:C:/Users/arceredillo.adrian/Documents/DAM2/Erronka_EV_2/Erronka2_DAM2/adrian_unity_Conection/Db_ConectionTest/Assets/testdb.db";
        //C:\Users\arceredillo.adrian\Documents\DAM2\Erronka_EV_2\Erronka2_DAM2\adrian_unity_Conection\Db_ConectionTest\Assets


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param Email
     * @param izena
     * @param user
     * @param jaiotzaData
     * @param taldea
     * 
     */
    public void insertLangilea(String email, String izena, String user, String jaiotzaData, int taldea) {
        String sql = "INSERT INTO Langilea(Email,Izena,User,JaiotzaData,Taldea) VALUES(?,?,?,?,?)";

        try (Connection conn = SQLite.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, izena);
            pstmt.setString(3, user);
            pstmt.setString(4, jaiotzaData);
            pstmt.setInt(5, taldea);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param user
     * @param puntuazioa
     * @param data
     */
    public void insertPartida(String user, float puntuazioa, String data) {
        String sql = "INSERT INTO Partida(User,Puntuazioa,Data) VALUES(?,?,?)";

        try (Connection conn = SQLite.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setDouble(2, puntuazioa);
            pstmt.setString(3, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> selectAll(String taula) {
        ArrayList<String> result = new ArrayList<String>();
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            if (taula.equals("partida")) {
                while (rs.next()) {
                    String datuak = rs.getInt("id") + ", '" +
                            rs.getString("user") + "', " +
                            rs.getDouble("puntuazioa") + ", '" +
                            rs.getString("data") + "'";
                    result.add(datuak);
                }
            } else {
                while (rs.next()) {
                    String datuak = "'" + rs.getString("email") + "', '" +
                            rs.getString("izena") + "', '" +
                            rs.getString("user") + "', '" +
                            rs.getString("jaiotzadata") + "', " +
                            rs.getInt("taldea");
                    result.add(datuak);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
}