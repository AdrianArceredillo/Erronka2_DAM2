package com.dambi.restapi.exekutagarriak;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;

import com.dambi.restapi.atzipenekoak.JsonaPartida;

public class pruebasJSON {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/demo/all_Partida");

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
            System.out.println(content);
            
            System.out.println(new File("").getAbsolutePath());
            String fitxategia = "./restapi/src/main/java/com/dambi/data/informazioa.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
            writer.write(content);
            writer.close();

            JsonaPartida.irakurri(fitxategia);

        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
