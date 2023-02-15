package com.dambi.mongo;

import com.dambi.atzipenekoak.JsonaLangileak;
import com.dambi.atzipenekoak.JsonaPartidak;
import com.dambi.atzipenekoak.Log;
import com.dambi.pojoak.Langilea;
import com.dambi.pojoak.Langileak;
import com.dambi.pojoak.Partida;

import com.dambi.pojoak.Partidak;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.bson.Document;

public class insert {
    public static String fitxategia = "informazioa.json";

    public static void insertPartida(String link, String jokoa, int taldea) {
        String content = "";
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(link);

        Partidak partidak = new Partidak();

        // Json fitxategi batean idatzi lortutako informazioa:
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
            writer.write(content);
            writer.close();
            // Fitxategia irakurri eta datuak lortu
            partidak = JsonaPartidak.irakurri(fitxategia, jokoa, taldea);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MongoClient mongo = MongoClients.create("mongodb://127.0.0.1:27017"); // Datu Basearen Helbidea

        MongoDatabase db = mongo.getDatabase("Erronka2");

        int kontagailua = 0;
        for (Partida partida : partidak.getPartidak()) {
            try {
                Document doc = new Document("partidaId", partida.getId())
                        .append("langilea", partida.getUser()) // langile bezala utziko da eta ez user bezala
                        .append("puntuazioa", partida.getPuntuazioa())
                        .append("data", partida.getData())
                        .append("jokoa", partida.getJokoa())
                        .append("taldea", partida.getTaldea());

                db.getCollection("partida").insertOne(doc);
                kontagailua++;
            } catch (Exception e) {
                
            }

        }
        Log.logIdatzi(link + " erabiliz, partiden informazioa gorde da. (" + kontagailua + ") datu berri gorde dira.");
        mongo.close();
    }

    public static void insertLangilea(String link) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(link);

        Langileak langileak = new Langileak();

        // Json fitxategi batean idatzi lortutako informazioa:
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
            writer.write(content);
            writer.close();
            // Fitxategia irakurri eta datuak lortu
            langileak = JsonaLangileak.irakurri(fitxategia);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MongoClient mongo = MongoClients.create("mongodb://127.0.0.1:27017"); // Datu Basearen Helbidea

        MongoDatabase db = mongo.getDatabase("Erronka2");

        int kontagailua = 0;
        for (Langilea langilea : langileak.getLangileak()) {

            try {
                Document doc = new Document("email", langilea.getEmail())
                        .append("izena", langilea.getIzena())
                        .append("user", langilea.getUser())
                        .append("jaiotzadata", langilea.getJaiotzaData())
                        .append("taldea", langilea.getTaldea());

                db.getCollection("langilea").insertOne(doc);
                kontagailua++;
            } catch (Exception e) {

            }
        }

        Log.logIdatzi(link + " erabiliz, langileen informazioa gorde da. (" + kontagailua + ") datu berri gorde dira.");
        mongo.close();
    }

}
