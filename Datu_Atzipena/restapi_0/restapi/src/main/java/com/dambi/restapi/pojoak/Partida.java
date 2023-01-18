package com.dambi.restapi.pojoak;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partida")
public class Partida {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String user;
    private int puntuazioa;
    private Timestamp data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String name) {
        this.user = name;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public String getData() {
        return data.toString();
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Partida[id: " + id +
                ", user: " + user +
                ", puntuazioa: " + puntuazioa +
                ", data: " + data.toString();
    }

}