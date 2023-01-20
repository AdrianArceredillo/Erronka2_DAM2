package com.dambi.restapi.exekutagarriak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.dambi.restapi.atzipenekoak.JsonaPartida;

public class infoToJSON {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request_Partidak = new HttpGet("http://localhost:8080/demo/all_Partida");
        HttpGet request_Langileak = new HttpGet("http://localhost:8080/demo/all_Langilea");

        // HttpGet request_Langileak = new
        // HttpGet("http://localhost:8080/demo/LangileaBat");

        try {
            // PARTIDAK
            HttpResponse response_Partidak = client.execute(request_Partidak);
            HttpEntity entity_P = response_Partidak.getEntity();
            content = EntityUtils.toString(entity_P);

            String fitxategia_P = "./src/main/java/com/dambi/data/informazioaPartidak.json";
            BufferedWriter writer_P = new BufferedWriter(new FileWriter(fitxategia_P));
            writer_P.write(content);
            writer_P.close();

            JsonaPartida.irakurri(fitxategia_P);

            // LANGILEAK
            HttpResponse response_Langileak = client.execute(request_Langileak);
            HttpEntity entity_L = response_Langileak.getEntity();
            content = EntityUtils.toString(entity_L);

            String fitxategia_L = "./src/main/java/com/dambi/data/informazioaLangileak.json";
            BufferedWriter writer_L = new BufferedWriter(new FileWriter(fitxategia_L));
            writer_L.write(content);
            writer_L.close();

            // JsonaLangilea.irakurri(fitxategia_L);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
