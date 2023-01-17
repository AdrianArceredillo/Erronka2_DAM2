package com.dambi.pojoak;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

public class Proba {

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String content = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/demo/all_Partida");

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            content = EntityUtils.toString(entity);

            System.out.println(content);
            System.out.println("-----------");
            content = content.substring(1);
            System.out.println(content);
            System.out.println("-----------");

        } catch (IOException e) {
            e.printStackTrace();
        }

            

        Partidak partidak = null;   
        try {
            JSONObject jsonObject = new JSONObject(content);

            JsonStructure jsonst = (JsonStructure) jsonObject;
            JsonArray jsonarray = jsonst.asJsonArray();
            partidak = new Partidak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Partida partida = new Partida();
                partida.setId(jsonobj.getInt("id"));
                partida.setUser(jsonobj.getString("user"));
                partida.setPuntuazioa(jsonobj.getInt("puntuazioa"));
                partida.setData(jsonobj.getString("data"));
                System.out.println(partida);
                partidak.add(partida);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
}
}
