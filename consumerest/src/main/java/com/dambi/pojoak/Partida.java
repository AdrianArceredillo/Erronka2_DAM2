package com.dambi.pojoak;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "langilea", "puntuazioa", "data"})
@XmlRootElement(name = "Partida")

public class Partida {

    int id, puntuazioa, jokoa;
    String langilea;
    Date data;

    @XmlElement(name = "Id")
    public int getId(){
       return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Langilea")
    public String getLangilea() {
        return langilea;
    }
    public void setLangilea(String langilea) {
        this.langilea = langilea;
    }

    @XmlElement(name = "Puntuazioa")
    public int getPuntuazioa() {
        return puntuazioa;
    }
    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    @XmlElement(name = "Data")
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    @XmlElement(name = "Jokoa")
    public int getJokoa() {
        return jokoa;
    }
    public void setJokoa(int jokoa) {
        this.jokoa = jokoa;
    }


    @Override
    public String toString() { 
        return String.format("Partida[ID:" + this.getId() + ", User:" + this.getLangilea() + ", Puntuazioa: " + this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}
