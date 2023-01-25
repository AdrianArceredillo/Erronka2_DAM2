package com.dambi.exekutagarriak;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.dambi.atzipenekoak.JsonaL;
import com.dambi.pojoak.Langileak;
import com.dambi.pojoak.Partidak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Proba {

    public static void main(String[] args) {

        String linkLangilea = "http://localhost:8080/query?id=0";
        //String linkPartida = "http://localhost:8080/demo/all_Langilea";
        String fitxategia = "./src/main/java/com/dambi/data/informazioa.json";


        Langileak langileak = JsonaL.irakurri(linkLangilea, fitxategia);
        //Partidak partidak = JsonaL.irakurri(linkPartida, fitxategia);
        System.out.println(langileak);

        // Partidak partidak = JsonaP.irakurri(fitxategia);
        // System.out.println(partidak);

    }
}
