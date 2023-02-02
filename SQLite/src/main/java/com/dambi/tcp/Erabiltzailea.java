package com.dambi.tcp;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

import com.dambi.object.Datuak;
import com.dambi.sqlite.SQLite;

public class Erabiltzailea {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String Host = "127.0.0.1"; // "localhost" ipintzea berdina da
        // String Host = "192.168.65.16";
        int Puerto = 6000;
        while (true) {
            while (true) {
                TimeUnit.SECONDS.sleep(3);
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
                    // EL SERVIDOR ME ENVIA UN MENSAJE

                    String mezua = flujoEntrada.readUTF();

                    System.out.println("Zerbitzaritik jasotzen: \n" + mezua);
                    SQLite.datuakGarbitu();

                    // CERRAR STREAMS Y SOCKETS
                    flujoEntrada.close();
                    Cliente.close();

                } catch (Exception e) {
                    System.out.println("Zerbitzaria ez dago piztuta");
                }
            }
        }

    } // main

}
