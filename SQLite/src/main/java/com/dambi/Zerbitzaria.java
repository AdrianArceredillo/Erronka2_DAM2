package com.dambi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Statement;
public class Zerbitzaria {
    public static void main(String[] arg) throws IOException, ClassNotFoundException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        int numeroPuerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente ");
        clienteConectado = servidor.accept();

        //inStream = new ObjectInputStream(socket.getInputStream());

        InputStream inputStream = clienteConectado.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Partida partida = (Partida) objectInputStream.readObject();

        System.out.println(partida.getIzena());
        System.out.println(partida.getPuntuazioa());

        String sqlPT = "INSERT INTO proba(izena, puntuazioa)";

        sqlPT += "VALUES('" + partida.getIzena() + "', "+partida.getPuntuazioa()+")";
        exekuzioa(sqlPT);
    }
    
    public static void exekuzioa(String sql) {
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            System.out.println(st.executeQuery(sql));
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
