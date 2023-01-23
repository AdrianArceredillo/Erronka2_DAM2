package com.dambi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
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

        try (Connection conn = this.connect();
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

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setDouble(2, puntuazioa);
            pstmt.setString(3, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> selectAll(){
        ArrayList<String> result = new ArrayList<String>();
        String sql = "SELECT id, user, puntuazioa, data FROM partida";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("user") + "\t" +
                                   rs.getDouble("puntuazioa"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * @param args the command line arguments
     */
    public ArrayList<String> informazioa() {

        InsertApp app = new InsertApp();
        return app.selectAll();

    }

}