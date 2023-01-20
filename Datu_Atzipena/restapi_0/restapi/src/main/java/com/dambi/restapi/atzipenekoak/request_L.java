package com.dambi.restapi.atzipenekoak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.bson.Document;

import com.dambi.restapi.pojoak.Langilea;
import com.dambi.restapi.pojoak.Langileak;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class request_L {

    public static HttpGet request_Langileak = new HttpGet("http://localhost:8080/demo/LangileaBat?langileaEmail=prueba0@gmail.com");
    // http://localhost:8080/demo/LangileaBat?langileaEmail=aaa

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();

        Langileak langileak = null;

        try {
            // LANGILEAK
            HttpResponse response_Langileak = client.execute(request_Langileak);
            HttpEntity entity_L = response_Langileak.getEntity();
            content = EntityUtils.toString(entity_L);

            String fitxategia_L = "./src/main/java/com/dambi/data/informazioaLangileak.json";
            BufferedWriter writer_L = new BufferedWriter(new FileWriter(fitxategia_L));
            writer_L.write(content);
            writer_L.close();

            langileak = JsonaLangilea.irakurri(fitxategia_L);
            System.out.println(langileak);
            System.out.println("------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("erronkaPrueba");
        // MongoCollection<Document> collection = database.getCollection("langilea");

        for (Langilea langilea : langileak.getLangileak()) {
            Document doc = new Document("email", langilea.getEmail())
                    .append("izena", langilea.getIzena())
                    .append("user", langilea.getUser())
                    .append("jaiotzaData", langilea.getJaiotzaData())
                    .append("taldea", langilea.getTaldea());

            database.getCollection("langilea").insertOne(doc);

        }

        mongoClient.close();
    }

    /*
     * public static void infoObjetos(HttpGet request_, String tipoObjeto) {
     * System.out.print("\033[H\033[2J");
     * System.out.flush();
     * 
     * String content = "";
     * HttpClient client = HttpClientBuilder.create().build();
     * Langileak langileak = null;
     * Partidak partidak = null;
     * 
     * if (tipoObjeto.equals("L")) {
     * try {
     * HttpResponse response_Langileak = client.execute(request_);
     * HttpEntity entity_L = response_Langileak.getEntity();
     * content = EntityUtils.toString(entity_L);
     * 
     * String fitxategia_L =
     * "./restapi/src/main/java/com/dambi/data/informazioaLangileak.json";
     * BufferedWriter writer_L = new BufferedWriter(new FileWriter(fitxategia_L));
     * writer_L.write(content);
     * writer_L.close();
     * 
     * langileak = JsonaLangilea.irakurri(fitxategia_L);
     * System.out.println("------------------------");
     * System.out.println(langileak);
     * System.out.println("------------------------");
     * 
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * 
     * // MongoClient mongoClient =
     * MongoClients.create("mongodb://localhost:27017");
     * // MongoDatabase database = mongoClient.getDatabase("erronkaPrueba");
     * 
     * for (Langilea langilea : langileak.getLangileak()) {
     * Document doc = new Document("email", langilea.getEmail())
     * .append("izena", langilea.getIzena())
     * .append("user", langilea.getUser())
     * .append("jaiotzaData", langilea.getJaiotzaData())
     * .append("taldea", langilea.getTaldea());
     * 
     * database.getCollection("langilea").insertOne(doc);
     * 
     * }
     * mongoClient.close();
     * 
     * } else if (tipoObjeto.equals("P")) {
     * try {
     * HttpResponse response_Partidak = client.execute(request_);
     * HttpEntity entity_P = response_Partidak.getEntity();
     * content = EntityUtils.toString(entity_P);
     * 
     * String fitxategia_P =
     * "./restapi/src/main/java/com/dambi/data/informazioaPartidak.json";
     * BufferedWriter writer_P = new BufferedWriter(new FileWriter(fitxategia_P));
     * writer_P.write(content);
     * writer_P.close();
     * 
     * partidak = JsonaPartida.irakurri(fitxategia_P);
     * System.out.println("------------------------");
     * System.out.println(partidak);
     * System.out.println("------------------------");
     * 
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * 
     * // MongoClient mongoClient =
     * MongoClients.create("mongodb://localhost:27017");
     * // MongoDatabase database = mongoClient.getDatabase("erronkaPrueba");
     * 
     * for (Partida partida : partidak.getPartidak()) {
     * Document doc = new Document("id", partida.getId())
     * .append("user", partida.getUser())
     * .append("puntuazioa", partida.getPuntuazioa())
     * .append("data", partida.getData());
     * 
     * database.getCollection("partida").insertOne(doc);
     * 
     * }
     * mongoClient.close();
     * }
     * 
     * }
     */
}
