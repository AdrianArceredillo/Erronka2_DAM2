package com.dambi.restapi.atzipenekoak;


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

import com.dambi.restapi.pojoak.Partida;
import com.dambi.restapi.pojoak.Partidak;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class request_P {

    public static HttpGet request_PartidaGuztiak = new HttpGet("http://localhost:8080/demo/PartidaBat?partidaId=1");

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";

        HttpClient client = HttpClientBuilder.create().build();
        Partidak partidak = null;

        try {
            // PARTIDAK
            HttpResponse response_Partidak = client.execute(request_PartidaGuztiak);
            HttpEntity entity_P = response_Partidak.getEntity();
            content = EntityUtils.toString(entity_P);

            String fitxategia_P = "./src/main/java/com/dambi/data/informazioaPartidak.json";
            BufferedWriter writer_P = new BufferedWriter(new FileWriter(fitxategia_P));
            writer_P.write(content);
            writer_P.close();

            partidak = JsonaPartida.irakurri(fitxategia_P);
            System.out.println(partidak);
            System.out.println("------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("erronkaPrueba");
        // MongoCollection<Document> collection = database.getCollection("partida");

        for (Partida partida : partidak.getPartidak()) {
            Document doc = new Document("id", partida.getId())
                    .append("user", partida.getUser())
                    .append("puntuazioa", partida.getPuntuazioa())
                    .append("data", partida.getData());

            database.getCollection("partida").insertOne(doc);

        }

        mongoClient.close();
    }
}
