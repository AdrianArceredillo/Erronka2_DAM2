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

import ch.qos.logback.core.db.DataSourceConnectionSource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// import org.json.simple.JSONObject;

// import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JsonaLangileak {

    public static Langileak irakurri(String strFileIn, int taldea) {

        Langileak langileak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            langileak = new Langileak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Langilea langilea = new Langilea();
                langilea.setEmail(jsonobj.getString("email"));
                langilea.setIzena(jsonobj.getString("izena"));
                langilea.setUser((jsonobj.getString("erabiltzailea")));
                
                Date date;
                SimpleDateFormat err = new SimpleDateFormat("yyyy-MM-dd");
                date = err.parse("2000-01-01");
                if(taldea == 4) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); //Taldea 4
                    date = sdf.parse(jsonobj.getString("jaiotzadata"));
                }
                if(taldea == 1) {
                    SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd"); //Taldea 1
                    date = sdfm.parse(jsonobj.getString("jaiotzadata"));
                }
                if(taldea == 2) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); //Taldea 2
                    date = sdf.parse(jsonobj.getString("jaiotzadata"));
                }
               
                langilea.setJaiotzaData(date);
                langilea.setTaldea(jsonobj.getInt("taldea"));
                langileak.add(langilea);
            }

        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
        return langileak;
    }

}
