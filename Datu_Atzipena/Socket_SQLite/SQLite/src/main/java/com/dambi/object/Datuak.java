package com.dambi.object;


import java.io.Serializable;
import java.util.ArrayList;

public class Datuak implements Serializable {

    public ArrayList<String> partida = new ArrayList<String>();
    public ArrayList<String> langilea = new ArrayList<String>();

    public Datuak() {
    }

    public void setPartida(ArrayList<String> list) {
        this.partida = list;
    }

    public ArrayList<String> getPartida() {
        return partida;
    }

    public void setLangilea(ArrayList<String> list) {
        this.langilea = list;
    }

    public ArrayList<String> getLangilea() {
        return langilea;
    }


}