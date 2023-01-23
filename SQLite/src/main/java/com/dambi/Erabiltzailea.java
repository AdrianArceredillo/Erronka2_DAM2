package com.dambi;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Erabiltzailea {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        String Host = "127.0.0.1"; //"localhost" ipintzea berdina da
        // String Host = "192.168.65.16";
        int Puerto = 6000;
        System.out.println("Idatzi izena eta ondoren puntuazioa:");
        
        Socket Cliente = new Socket(Host, Puerto);

        OutputStream outputStream = Cliente.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Datuak datuak = new Datuak();

        // datuak.setLangilea();

        objectOutputStream.writeObject(partida);

        Cliente.close();
        System.out.print("");
        sc.nextLine();
    } // main

}
