package com.dambi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "user", "puntuazioa", "data"})
@XmlRootElement(name = "Partida")

public class Partida {

    int id, puntuazioa;
    String user, data;

    @XmlElement(name = "Id")
    public int getId(){
       return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "User")
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
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() { 
        return String.format("Partida[ID:" + this.getId() + ", User:" + this.getUser() + ", Puntuazioa: " + this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}
