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

    public static void irakurri( String strFileIn) {

        Partidak partidak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            partidak = new Partidak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);

                //Partida objektu berri bat sortu
                Partida partida = new Partida();
                partida.setId(jsonobj.getInt("id"));
                String user = jsonobj.getString("user");
                
                //String userFinal = "";

                //probar a cambiar el tipo de dato en la tabla -> nvarchar, char, text...
                // for (int j = 0; i < user.length(); i++){
                //     char c = user.charAt(i);
                //     if ((c > 47 && c < 58) || (c > 64 && c < 91) || (c > 96 && c < 123)){
                //         userFinal += c;
                //     } else {
                //         break;
                //     }
                // }

                // System.out.println("-------------");
                // System.out.println(userFinal);
                // System.out.println("-------------");


                // partida.setUser(userFinal);
                partida.setUser(user);
                partida.setPuntuazioa(jsonobj.getInt("puntuazioa"));

                
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(jsonobj.getString("jaiotzadata"));
                Timestamp partida_Data = new Timestamp(date.getTime());
                partida.setData(partida_Data);


                System.out.println(partida);
                partidak.add(partida);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
    }
}