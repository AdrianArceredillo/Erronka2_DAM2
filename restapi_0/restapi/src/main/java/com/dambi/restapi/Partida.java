package com.dambi.restapi;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_partida")
public class Partida {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int puntuazioa;
    private Timestamp data;
    private int langilea;
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLangilea() {
        if (langilea == 43)
        return "Adrian";
        if (langilea == 44)
        return "Haritz";
        if (langilea == 52)
        return "josebaa";
        if (langilea == 46)
        return "alain";
        
        return "0";
    }

    public void setLangilea(int langilea) {
        this.langilea = langilea;
    }




    
    @Override
    public String toString() {
        return "Partida[id: " + id +
                ", user: " + langilea +
                ", puntuazioa: " + puntuazioa +
                ", data: " + data.toString();
    }

}