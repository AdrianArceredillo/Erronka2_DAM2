package com.dambi.exekutagarriak;

import java.io.File;
import java.util.concurrent.TimeUnit;

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
        taldea4();

    }
//
public static void taldea1(){
    int taldea = 1;
    String linkPartida = "http://192.168.65.11:8080/api/allPartidak";
    try {
        insert.insertPartida(linkPartida, "Mahi Kingdom", taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "http://192.168.65.11:8080/api/allLangileak";
    try {
        insert.insertLangilea(linkLangilea, taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}

//Mahi Kingdom
//ZOMBIE KILLER
//Pouni
//Johnny

public static void taldea2(){
    int taldea = 2;
    String linkPartida = "http://192.168.65.90:8081/demo/all_Partida";
    try {
        //insert.insertPartida(linkPartida, "Mahi Kingdom", 1);
        insert.insertPartida(linkPartida, "ZOMBIE KILLER", taldea);
        //insert.insertPartida(linkPartida, "Pouni", 3);
        //insert.insertPartida(linkPartida, "Johnny", 4);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "http://192.168.65.90:8081/demo/all_Langilea";
    try {
        insert.insertLangilea(linkLangilea, taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}


public static void taldea3(){
    int taldea = 3;
    String linkPartida = "============================================";
    try {
        insert.insertPartida(linkPartida, "Pouni", taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "============================================";
    try {
        insert.insertLangilea(linkLangilea, taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}

//Erlantz, Markel, Raul, Peru
public static void taldea4(){
    int taldea = 4;
    String linkPartida = "http://192.168.65.123:8080/Partidak/getPartidak";
    try {
        insert.insertPartida(linkPartida, "Johnny", taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkPartida + " helbidearekin");
        System.out.println("Konexio errorea " + linkPartida + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
    
    String linkLangilea = "http://192.168.65.123:8080/Langileak/getLangileak";
    try {
        insert.insertLangilea(linkLangilea, taldea);
    } catch (Exception e) {
        Garbitzailea.garbituPantaila();
        Log.logIdatzi("Konexio errorea " + linkLangilea + " helbidearekin");
        System.out.println("Konexio errorea " + linkLangilea + " helbidearekin");
    }
    Garbitzailea.garbituPantaila();
}

}
