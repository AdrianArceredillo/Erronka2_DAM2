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
        String url = "jdbc:sqlite:C:/sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Metodo honek partiden taulako datuak jasotzen ditu eta ArrayList batetan
     * sartzen ditu.
     * 
     * @param taula taularen izena behar du. partida edo langilea.
     * @return ArrayList bat aukeratutako taularen balioekin.
     */

    public static ArrayList<String> selectAll(String taula) {
        ArrayList<String> result = new ArrayList<String>();
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            if (taula.equals("partida")) {
                while (rs.next()) {
                    String zenbakia = "";
                    switch (rs.getString("user")) {
                        case "Adrian":
                            zenbakia = "43";
                            break;
                        case "Haritz":
                            zenbakia = "44";
                            break;
                        case "josebaa":
                            zenbakia = "52";
                            break;
                        case "alain":
                            zenbakia = "46";
                            break;

                        default:
                            zenbakia = "404"; // Errorea
                            break;
                    }
                    String datuak = 
                            //rs.getInt("id") + ", " +
                            zenbakia + ", " +
                            rs.getDouble("puntuazioa") + ", '" +
                            rs.getString("data") +
                            "', true";
                    result.add(datuak); // Adb.: id, 46, puntuazioa, 'data'
                                        // 46, 123456, '2023-02-02', true
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

    public static void datuakGarbitu() {
        String sql = "DELETE FROM partida";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException e) {
        }
    }

    public static void datuakSartu() {
        String sql = "INSERT INTO partida (user, puntuazioa, data) VALUES ('Mohamed', 69, '2023/2/2')";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException e) {

        }
    }

    // /**
    // * Insert a new row into the warehouses table
    // *
    // * @param Email
    // * @param izena
    // * @param user
    // * @param jaiotzaData
    // * @param taldea
    // *
    // */
    // public void insertLangilea(String email, String izena, String user, String
    // jaiotzaData, int taldea) {
    // String sql = "INSERT INTO Langilea(Email,Izena,User,JaiotzaData,Taldea)
    // VALUES(?,?,?,?,?)";

    // try (Connection conn = SQLite.connect();
    // PreparedStatement pstmt = conn.prepareStatement(sql)) {
    // pstmt.setString(1, email);
    // pstmt.setString(2, izena);
    // pstmt.setString(3, user);
    // pstmt.setString(4, jaiotzaData);
    // pstmt.setInt(5, taldea);
    // pstmt.executeUpdate();
    // } catch (SQLException e) {
    // System.out.println(e.getMessage());
    // }
    // }

    // /**
    // * @param user
    // * @param puntuazioa
    // * @param data
    // */
    // public void insertPartida(String user, float puntuazioa, String data) {
    // String sql = "INSERT INTO Partida(User,Puntuazioa,Data) VALUES(?,?,?)";

    // try (Connection conn = SQLite.connect();
    // PreparedStatement pstmt = conn.prepareStatement(sql)) {
    // pstmt.setString(1, user);
    // pstmt.setDouble(2, puntuazioa);
    // pstmt.setString(3, data);
    // pstmt.executeUpdate();
    // } catch (SQLException e) {
    // System.out.println(e.getMessage());
    // }
    // }

}