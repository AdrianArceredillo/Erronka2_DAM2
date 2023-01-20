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

public class JsonaPartida {

    public static Partidak irakurri( String strFileIn) {

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
                partida.setUser(Garbitzailea.Garbitu(jsonobj.getString("user")));
                partida.setPuntuazioa(jsonobj.getInt("puntuazioa"));
                partida.setData(jsonobj.getString("data"));

                System.out.println(partida);
                partidak.add(partida);
            }

        } catch (Exception e) {
             System.out.println(e);
        }

        return partidak;
    }
}