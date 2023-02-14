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
import java.text.SimpleDateFormat;
import java.util.Date;

// import org.json.simple.JSONObject;

// import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JsonaLangileak {

    public static Langileak irakurri(String strFileIn) {

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

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

                //Try catch batekin egin behar da zeren talderen batek ez dut ipini jaiotzadata *kof* *kof* 4 taldea *kof* *kof*
                Date date = sdf.parse("1970-01-02 00:00:00.0");
                try {
                    date = sdf.parse(jsonobj.getString("jaiotzadata"));
                } catch (Exception e) {
                    date = sdf.parse(jsonobj.getString("jaiotzedata"));
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
