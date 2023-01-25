package com.dambi.tcp;

import java.io.*;
import java.net.*;

import com.dambi.object.Datuak;
import com.dambi.sqlite.SQLite;

public class Erabiltzailea {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        // String Host = "127.0.0.1"; //"localhost" ipintzea berdina da
        String Host = "192.168.65.6";
        // String Host = "192.168.65.16";
        int Puerto = 6000;
        
        Socket Cliente = new Socket(Host, Puerto);

        OutputStream outputStream = Cliente.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Datuak datuak = new Datuak();
        datuak.setLangilea(SQLite.selectAll("langilea"));
        datuak.setPartida(SQLite.selectAll("partida"));

        objectOutputStream.writeObject(datuak);

        Cliente.close();
        System.out.print("");
    } // main

}
