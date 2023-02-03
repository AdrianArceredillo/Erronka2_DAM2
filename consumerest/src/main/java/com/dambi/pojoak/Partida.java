package com.dambi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "langilea", "puntuazioa", "data"})
@XmlRootElement(name = "Partida")

public class Partida {

    int id, puntuazioa, taldea;
    String langilea, data;

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
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
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
        return String.format("Partida[ID:" + this.getId() + ", User:" + this.getLangilea() + ", Puntuazioa: " + this.getPuntuazioa() + ", Data: " + this.getData() + "]");
    }

}
