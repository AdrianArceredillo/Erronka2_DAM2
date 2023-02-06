package com.dambi.atzipenekoak;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.dambi.pojoak.Langilea;
import com.dambi.pojoak.Langileak;

import java.io.IOException;

// import org.json.simple.JSONObject;

// import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JsonaL {
 
    public static Langileak irakurri(String link, String fitxategia) {

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(link);
        Langileak langileak = null;
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fitxategia)); //Idatzi
            writer.write(content);
            writer.close();

            try {
                JsonReader reader = Json.createReader(new FileReader(fitxategia)); //Irakurri
                JsonStructure jsonst = reader.read();
                JsonArray jsonarray = jsonst.asJsonArray();
                langileak = new Langileak();
                for (int i = 0; i < jsonarray.size(); i++) {
                    JsonObject jsonobj = jsonarray.getJsonObject(i);
                    Langilea langilea = new Langilea();
                    langilea.setEmail(Garbitzailea.garbitu(jsonobj.getString("email")));

                    langilea.setIzena(Garbitzailea.garbitu(jsonobj.getString("izena")));

                    langilea.setUser(Garbitzailea.garbitu(jsonobj.getString("langilea")));

                    langilea.setJaiotzaData(jsonobj.getString("jaiotzadata"));
                    langilea.setTaldea(jsonobj.getInt("taldea"));

                    langileak.add(langilea);
                }

            } catch (Exception e) {
                System.out.println("Arazoak String-a irakurtzerakoan.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return langileak;
    }

}
