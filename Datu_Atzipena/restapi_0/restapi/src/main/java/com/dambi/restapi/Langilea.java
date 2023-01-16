package com.dambi.restapi;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Langilea")
public class Langilea {
    @Id
    private String email;
    private String izena;
    private String user;
    private Timestamp jaiotzaData;
    private int taldea;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJaiotzaData() {
        return jaiotzaData.toString();
    }

    public void setJaiotzaData(Timestamp jaiotzaData) {
        this.jaiotzaData = jaiotzaData;
    }

    public int getTaldea() {
        return taldea;
    }

    public void setTaldea(int taldea) {
        this.taldea = taldea;
    }

    @Override
    public String toString() {
        return "Langilea[user: " + user +
                ", taldea: " + taldea +
                ", izena: " + izena +
                ", email: " + email +
                ", jaiotza-data: " + jaiotzaData.toString();
    }

}



//https://spring.io/guides/tutorials/rest/
