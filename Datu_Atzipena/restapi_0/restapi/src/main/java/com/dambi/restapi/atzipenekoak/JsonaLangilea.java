package com.dambi.restapi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import com.dambi.restapi.pojoak.Langilea;
import com.dambi.restapi.pojoak.Langileak;
import com.dambi.restapi.pojoak.Partida;
import com.dambi.restapi.pojoak.Partidak;

public class JsonaLangilea {

    public static void irakurri(String strFileIn) {

        Langileak langileak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            langileak = new Langileak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);

                // Langilea objektu berri bat sortu
                Langilea langilea = new Langilea();
                langilea.setEmail(jsonobj.getString("email"));
                langilea.setIzena(jsonobj.getString("izena"));
                langilea.setUser(jsonobj.getString("user"));

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(jsonobj.getString("jaiotzadata"));
                Timestamp jaiotza_Data = new Timestamp(date.getTime());
                langilea.setJaiotzaData(jaiotza_Data);

                System.out.println(langilea);
                langileak.add(langilea);
            }

        } catch (Exception e) {
            // System.out.println("Arazoak String-a irakurtzerakoan.");
        }
    }

    public static void emailaFiltratu(String email_Sartutakoa) {

        Langileak langileak = null;
        String fitxategia_L = "./restapi/src/main/java/com/dambi/data/informazioaLangileak.json";

        try {
            JsonReader reader = Json.createReader(new FileReader(fitxategia_L));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            langileak = new Langileak();
            for (int i = 0; i < jsonarray.size(); i++) {

                JsonObject jsonobj = jsonarray.getJsonObject(i);

                // Langilea objektu berri bat sortu
                Langilea langilea = new Langilea();
                langilea.setEmail(jsonobj.getString("email"));
                langilea.setIzena(jsonobj.getString("izena"));
                langilea.setUser(jsonobj.getString("user"));

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(jsonobj.getString("jaiotzadata"));
                Timestamp jaiotza_Data = new Timestamp(date.getTime());
                langilea.setJaiotzaData(jaiotza_Data);

                if (langilea.getEmail().equals(email_Sartutakoa)) {
                    System.out.println(langilea);
                    langileak.add(langilea);
                }

                // System.out.println(langilea);
                // langileak.add(langilea);
            }

        } catch (Exception e) {
            // System.out.println("Arazoak String-a irakurtzerakoan.");
        }
    }
}
