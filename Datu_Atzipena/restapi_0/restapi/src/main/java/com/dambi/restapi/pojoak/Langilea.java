package com.dambi.restapi.pojoak;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;

@Entity



@XmlType(propOrder = { "email", "izena", "user", "jaiotzadata", "taldea" })
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJaiotzaData() {
        return jaiotzadata.toString();
    }

    public void setJaiotzaData(String jaiotzadata) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(jaiotzadata);
        Timestamp jaiotza_Data = new Timestamp(date.getTime());
        
        this.jaiotzadata = jaiotza_Data;
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
                ", jaiotza-data: " + jaiotzadata.toString();
    }

}



//https://spring.io/guides/tutorials/rest/
