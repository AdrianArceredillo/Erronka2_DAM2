package com.dambi.tcp;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

import com.dambi.object.Datuak;
import com.dambi.sqlite.SQLite;

public class Erabiltzailea {
    public static void main(String[] args) throws Exception {

        String Host = "192.168.65.90"; // "localhost" ipintzea berdina da
        // String Host = "192.168.65.16";
        int Puerto = 6000;
        while (true) {

            while (true) {
                System.out.print("PROGRAMA EXEKUTATZEN");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(".");
                try {

                    // SQLite-ko datuak lortu
                    Datuak datuak = new Datuak();
                    datuak.setPartida(SQLite.selectAll("partida"));

                    if (datuak.getPartida().isEmpty()) {
                        System.out.println("Partida taula hutsik dago.");
                        // System.out.println("Datuak sartzen...");
                        // SQLite.datuakSartu();
                        break;
                    }

                    // Socket konexioa
                    Socket Cliente = new Socket(Host, Puerto);

                    OutputStream outputStream = Cliente.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                    objectOutputStream.writeObject(datuak);

                    DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

                    String mezua = flujoEntrada.readUTF();

                    System.out.println("Zerbitzaritik jasotzen: \n" + mezua);
                    SQLite.datuakGarbitu();

                    flujoEntrada.close();
                    Cliente.close();

                } catch (Exception e) {
                    System.out.println("Zerbitzaria ez dago piztuta");
                }
            }
        }

    } // main

}
