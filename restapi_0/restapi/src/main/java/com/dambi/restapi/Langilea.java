package com.dambi.restapi;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "langilea")
public class Langilea {
    @Id
    private String email;
    private String izena;
    private String user;
    private Timestamp jaiotzadata;
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

    public String getErabiltzailea() {
        return user;
    }

    public void setErabiltzailea(String user) {
        this.user = user;
    }

    public String getJaiotzadata() {
        return jaiotzadata.toString();
    }

    public void setJaiotzadata(Timestamp jaiotzadata) {
        this.jaiotzadata = jaiotzadata;
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
                ", jaiotzadata: " + jaiotzadata.toString();
    }

}
