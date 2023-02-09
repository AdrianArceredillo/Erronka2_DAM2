package com.dambi.exekutagarriak;

import com.dambi.atzipenekoak.Garbitzailea;
import com.dambi.atzipenekoak.Log;
import com.dambi.mongo.insert;

public class Maina {
    public static void main(String[] args) {
        // 1 TALDEA
        //taldea1();

        // 2 TALDEA
        taldea2();

        // 3 TALDEA
        //taldea3();

        // 4 TALDEA
        //taldea4();
    }

public static void taldea1(){
    String linkPartida = "============================================";
    try {
        insert.insertPartida(linkPartida, "Jokoa 1");
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "============================================";
    try {
        insert.insertLangilea(linkLangilea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}

//JOKOAREN IZENA FALTA DA
public static void taldea2(){
    String linkPartida = "http://localhost:8080/demo/all_Partida";
    try {
        insert.insertPartida(linkPartida, "Jokoa 2");
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "http://localhost:8080/demo/all_Langilea";
    try {
        insert.insertLangilea(linkLangilea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}


public static void taldea3(){
    String linkPartida = "============================================";
    try {
        insert.insertPartida(linkPartida, "Jokoa 2");
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "============================================";
    try {
        insert.insertLangilea(linkLangilea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}


public static void taldea4(){
    String linkPartida = "============================================";
    try {
        insert.insertPartida(linkPartida, "Jokoa 2");
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "============================================";
    try {
        insert.insertLangilea(linkLangilea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}

}
