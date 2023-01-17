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

    public Partidak partidak;
    public String strFileOut;
    private String strFileIn;

    public JsonaP(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    public JsonaP(Partidak partidak, String strFileOut) {
        this.partidak = partidak;
        this.strFileOut = strFileOut;
    }


    // public Partidak irakurri() {
        public void irakurri( String data) {

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
                partida.setUser(jsonobj.getString("user"));
                partida.setPuntuazioa(jsonobj.getInt("puntuazioa"));
                partida.setData(jsonobj.getString("data"));
                System.out.println("UwU");
                System.out.println(partida);
                partidak.add(partida);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak String-a irakurtzerakoan.");
        }
        //return partidak;
    }
    public void main(String[] args) {

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

        irakurri(content);

    }





























    // public void idatzi() {
    //     //int produktuKopurua = 0;
    //     JsonArray model = null;
    //     JsonArrayBuilder jab = Json.createArrayBuilder();
    //     for (Produktua p : this.produktuak.getProduktuak()) { //!!!
    //         jab.add(Json.createObjectBuilder()
    //             //ID;IZENA;DESKRIPZIOA;PREZIOA;STOCKA;BOLUMENA;PISUA;BARRAKODEA;LEHENTASUNA
    //                 .add("id", p.getId())
    //                 .add("izena", p.getIzena())
    //                 .add("deskripzioa", p.getDeskripzioa())
    //                 .add("prezioa", p.getPrezioa())
    //                 .add("stocka", p.getStocka())
    //                 .add("bolumena", p.getBolumena())
    //                 .add("pisua", p.getPisua())
    //                 .add("barraKodea", p.getBarraKodea())
    //                 .add("lehentasuna", p.getLehentasuna())
    //                 .build());
    //         //produktuKopurua++;
    //     }
    //     model=jab.build();

    //     try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(this.strFileOut))) {
    //         jsonWriter.writeArray(model);
    //     } catch (FileNotFoundException fnfe) {
    //         System.out.println("Fitxategia sortzerakoan arazoak.");
    //     }

    // }
}
