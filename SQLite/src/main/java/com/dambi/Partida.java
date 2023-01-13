package com.dambi;
import java.io.Serializable;

public class Partida implements Serializable{
    public String izena;
    public int puntuazioa;
    
    public Partida(){
    }

    public Partida (String izena, int puntuazioa){
        this.izena = izena;
        this.puntuazioa = puntuazioa;
    }

    public String getIzena (){
        return izena;
    }

    public void setIzena(String izena){
        this.izena = izena;
    }
    
    public int getPuntuazioa (){
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa){
        this.puntuazioa = puntuazioa;
    }

    @Override
    public String toString() {
        return "Partida[Izena: "+this.getIzena()+", Puntuazioa: "+ this.getPuntuazioa() + "]";
    }
}
