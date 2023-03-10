package com.dambi.pojoak;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "langilea", "puntuazioa", "data"})
@XmlRootElement(name = "Partida")

public class Partida {

    int id, puntuazioa, taldea;
    String user, jokoa;
    Date data;

    @XmlElement(name = "Id")
    public int getId(){
       return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Langilea")
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
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
    public String getJokoa() {
        return jokoa;
    }
    public void setJokoa(String jokoa) {
        this.jokoa = jokoa;
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
        return String.format("Partida[ID:" + this.getId() + ", User:" + this.getUser() + ", Puntuazioa: " + this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}
