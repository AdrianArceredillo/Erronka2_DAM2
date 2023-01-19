package com.dambi.pojoak;

import java.security.Timestamp;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "email", "izena", "user", "jaiotzadata", "taldea" })
@XmlRootElement(name = "Langilea")

public class Langilea {

    int taldea;
    String email, izena, user, jaiotzadata;

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "Izena")
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @XmlElement(name = "User")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @XmlElement(name = "JaiotzaData")
    public String getJaiotzaData() {
        return jaiotzadata;
    }

    public void setJaiotzaData(String jaiotzaData) {
        this.jaiotzadata = jaiotzaData;
    }

    @XmlElement(name = "Taldea")
    public int getTaldea() {
        return taldea;
    }

    public void setTaldea(int taldea) {
        this.taldea = taldea;
    }


    @Override
    public String toString() {
        return "Langilea[E-mail:" + this.getEmail() + ", izena: " + this.getIzena() + ", user:" + this.getUser() + ", jaiotza-data:" + this.getJaiotzaData() + ", taldea:" + this.getTaldea() + "]";
    }

}
