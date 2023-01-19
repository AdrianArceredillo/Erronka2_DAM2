package com.dambi.exekutagarriak;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.dambi.atzipenekoak.JsonaL;
import com.dambi.pojoak.Langileak;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Proba {

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/demo/all_Langilea");
        // HttpGet request = new HttpGet("http://localhost:8080/demo/all_Partida");

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
            System.out.println(content);

            String fitxategia = "./src/main/java/com/dambi/data/informazioa.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia));
            writer.write(content);
            writer.close();

            Langileak langileak = JsonaL.irakurri(fitxategia);
            System.out.println(langileak);
            

            // Partidak partidak = JsonaP.irakurri(fitxategia);
            // System.out.println(partidak);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
