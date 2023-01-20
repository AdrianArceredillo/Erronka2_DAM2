package com.dambi.restapi.atzipenekoak;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import com.dambi.restapi.pojoak.Langilea;
import com.dambi.restapi.pojoak.Langileak;

public class JsonaLangilea {

    public static Langileak irakurri(String strFileIn) {

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
                langilea.setEmail(Garbitzailea.Garbitu(jsonobj.getString("email")));
                langilea.setIzena(Garbitzailea.Garbitu(jsonobj.getString("izena")));
                langilea.setUser(Garbitzailea.Garbitu(jsonobj.getString("user")));

                // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                // Date date = formatter.parse(jsonobj.getString("jaiotzadata"));
                // Timestamp jaiotza_Data = new Timestamp(date.getTime());
                // langilea.setJaiotzaData(jaiotza_Data);
                langilea.setJaiotzaData(jsonobj.getString("jaiotzaData"));
                langilea.setTaldea(jsonobj.getInt("taldea"));

                System.out.println(langilea);
                langileak.add(langilea);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return langileak;
    }

}
