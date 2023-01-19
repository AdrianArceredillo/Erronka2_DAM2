package com.dambi.atzipenekoak;

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


public class JsonaL {

        public static Langileak irakurri( String strFileIn) {

        Langileak langileak = null;

        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            langileak = new Langileak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Langilea langilea = new Langilea();
                langilea.setEmail(Garbitzailea.garbitu(jsonobj.getString("email")));

                langilea.setIzena(Garbitzailea.garbitu(jsonobj.getString("izena")));

                langilea.setUser(Garbitzailea.garbitu(jsonobj.getString("user")));

                langilea.setJaiotzaData(jsonobj.getString("jaiotzaData"));
                langilea.setTaldea(jsonobj.getInt("taldea"));

                langileak.add(langilea);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
        return langileak;
    }

}
