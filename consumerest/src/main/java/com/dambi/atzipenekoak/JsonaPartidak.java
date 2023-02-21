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
import java.text.SimpleDateFormat;
import java.util.Date;

// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;

import com.dambi.pojoak.Partida;
import com.dambi.pojoak.Partidak;

import java.io.FileReader;

public class JsonaPartidak {

    public static Partidak irakurri(String strFileIn, String jokoa, int taldea) {

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
                if (taldea == 4 || taldea == 1) {

                    partida.setUser(jsonobj.getJsonObject("langilea").getString("erabiltzailea"));
                    partida.setPuntuazioa((jsonobj.getInt("puntuazioa")));
                    SimpleDateFormat sdf = null;
                    if (taldea == 4) {
                        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    } else {
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }

                    Date date = sdf.parse(jsonobj.getString("data"));

                    partida.setData(date);

                } else { //2 Taldea

                    partida.setUser(jsonobj.getString("erabiltzailea"));
                    partida.setPuntuazioa((jsonobj.getInt("puntuazioa")));

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                    Date date;
                    try {
                        date = sdf.parse(jsonobj.getString("data"));
                    } catch (Exception e) {
                        try {
                            SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd");
                            date = sdfm.parse(jsonobj.getString("data"));
                        } catch (Exception ex) {
                            SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd");
                            date = sdfm.parse(("2000-01-01"));
                        }

                    }
                    partida.setData(date);
                }

                partida.setJokoa(jokoa);
                partida.setTaldea(taldea);
                partidak.add(partida);

            }

        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
        return partidak;
    }

}
