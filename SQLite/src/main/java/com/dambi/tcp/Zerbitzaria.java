package com.dambi.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Statement;
import java.util.ArrayList;

import com.dambi.object.Datuak;
public class Zerbitzaria {

    public static String mezua;
    public static void main(String[] arg) throws IOException, ClassNotFoundException {

        mezua = "";
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

        Datuak datuak = new Datuak();
        datuak = (Datuak) objectInputStream.readObject();

        //System.out.println(datuak.getPartida());
        //System.out.println(datuak.getLangilea());

        String sql = "INSERT INTO partida VALUES " + sqlPrestatu(datuak.getPartida());
        //System.out.println(sql);
        //exekuzioa(sql);

        sql = "INSERT INTO langilea VALUES " + sqlPrestatu(datuak.getLangilea());
        //System.out.println(sql);
        //exekuzioa(sql);

        sql = "INSERT INTO partida VALUES (129, 'alainnnn', 2349057, '2023-01-25')";
        exekuzioa(sql);
        sql = "INSERT INTO partida VALUES (130, 'alainnnn', 2349057, '2023-01-25')";
        exekuzioa(sql);

        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        flujoSalida.writeUTF(mezua);

        salida.close();
        flujoSalida.close();
        clienteConectado.close();
        servidor.close();

    }
    
    public static void exekuzioa(String sql) {
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {

            System.out.println("Exception: " + ex);
            mezua += ex + "\n";
        }
    }

    public static String sqlPrestatu(ArrayList<String> list) {
        //System.out.println(list);

        String result = "";

        for (String string : list) {
            result += "(" + string + "), ";
        }


        return result = result.substring(0, result.length() - 2);
    }


}


















