package com.dambi.mongo;

import com.dambi.atzipenekoak.JsonaP;
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
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet("http://localhost:8080/demo/all_Partida");

        Partidak partidak = null;

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);

            String fitxategia = "./src/main/java/com/dambi/data/informazioa.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
            writer.write(content);
            writer.close();

            // Langileak langileak = JsonaL.irakurri(fitxategia);
            // System.out.println(langileak);

            partidak = JsonaP.irakurri(fitxategia);
            System.out.println(partidak);

        } catch (IOException e) {
            e.printStackTrace();
        }



        MongoClient mongo = MongoClients.create("mongodb://127.0.0.1:27017");

        MongoDatabase db = mongo.getDatabase("Erronka2");

        for (Partida partida : partidak.getPartidak()) {

            Document doc = new Document("id", partida.getId())
                    .append("user", partida.getUser())
                    .append("puntuazioa", partida.getPuntuazioa())
                    .append("data", partida.getData());

            db.getCollection("partida").insertOne(doc);

        }
 
        mongo.close();
    }
}
