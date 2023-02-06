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

import java.io.IOException;

// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;

import com.dambi.pojoak.Partida;
import com.dambi.pojoak.Partidak;

import java.io.FileReader;


public class JsonaP {

        public static Partidak irakurri(String strFileIn) {

        Partidak partidak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            partidak = new Partidak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Partida partida = new Partida();
                partida.setId(jsonobj.getInt("id"));
                partida.setLangilea("langilea");
                partida.setPuntuazioa(jsonobj.getInt("puntuazioa"));
                partida.setData(jsonobj.getString("data"));
                partidak.add(partida);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
        return partidak;
    }

}
