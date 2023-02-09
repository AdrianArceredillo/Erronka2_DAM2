package com.dambi.exekutagarriak;

import com.dambi.mongo.insert;

public class Maina {
    public static void main(String[] args) {
        // 1 TALDEA

        // insert.insertPartida("http://localhost:8080/demo/all_Partida");
        // insert.insertPartida("http://localhost:8080/demo/all_Langilea");

        // 2 TALDEA
        insert.insertPartida("http://localhost:8080/demo/all_Partida", "Jokoa 1");
        insert.insertLangilea("http://localhost:8080/demo/all_Langilea");


        // 3 TALDEA
        // insert.insertPartida("http://localhost:8080/demo/all_Partida");
        // insert.insertPartida("http://localhost:8080/demo/all_Langilea");


        // 4 TALDEA
        // insert.insertPartida("http://localhost:8080/demo/all_Partida");
        // insert.insertPartida("http://localhost:8080/demo/all_Langilea");


    }

}
