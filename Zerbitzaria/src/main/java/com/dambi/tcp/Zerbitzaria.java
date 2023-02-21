package com.dambi.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dambi.object.Datuak;

public class Zerbitzaria {

    public static String mezua;
    public static int kont;
    public static int datuKop;
    public static int datuKopTotala;
    // public static ArrayList<String> iDak;

    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        while (true) {
            mezua = "Errore kopurua: ";
            kont = 0;
            datuKop = 0;
            datuKopTotala = 0;

            // iDak = new ArrayList<String>();
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            int numeroPuerto = 6000;// Puerto
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            Socket clienteConectado = null;

            System.out.println("Erabiltzailearen zain:");
            clienteConectado = servidor.accept();

            InputStream inputStream = clienteConectado.getInputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Datuak datuak = new Datuak();
            datuak = (Datuak) objectInputStream.readObject();

            // exekuzioa(datuak.getPartida());
            for (String string : datuak.getPartida()) {
                String sql = "INSERT INTO library_partida(langilea, puntuazioa, data, active) VALUES (" + string + ")";
                exekuzioa(sql);

            }

            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            flujoSalida.writeUTF(mezua + kont);

            salida.close();
            flujoSalida.close();
            clienteConectado.close();

            servidor.close();

            System.out.println(
                    "Jaso diren (" + datuKopTotala + ") datuetatik, " + datuKop + " datu gehitu dira datu basera.");
        }

    }

    // public static void exekuzioa(ArrayList<String> list) {
    // Konexioa konekzioa = new Konexioa();
    // Statement st;

    // for (String datuak : list) {
    // try {
    // String sql = "INSERT INTO partida VALUES " + datuak;
    // st = konekzioa.connectDatabase().createStatement();
    // st.executeQuery(sql);
    // } catch (Exception ex) {
    // System.out.println("Exception: " + ex);
    // // Errorerik ez bada egon datuak sartzeko orduan
    // if (ex.equals("org.postgresql.util.PSQLException: No results were returned by
    // the query.")) {

    // String[] parts1 = datuak.split(","); // Datuak banatu "INSERT INTO partida
    // VALUES (130" <- horrelako
    // // zerbait lortuz
    // String part1 = parts1[0];
    // String[] parts2 = part1.split("("); // Berriro banatu "130" lortuz, hau da,
    // ID-a. Datu hau gero
    // // berriro erabiltzailera bidaliko da id-horrek dituen datuak
    // // ezabatzeko
    // String id = parts2[0];
    // iDak.add(id);
    // } else {
    // mezua += ex + "\n";
    // }
    // }

    // }

    // }

    /**
     * Metodo honek sql agindu bat exekutzatzen du
     * 
     * @param sql SQL agindua
     * @return Errore kantitatea bueltatzen du.
     */

    public static void exekuzioa(String sql) {
        Konexioa konekzioa = new Konexioa();
        Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception ex) {
            String exceptionMessage = ex.toString();
            if (!exceptionMessage.equals("org.postgresql.util.PSQLException: La consulta no retornó ningún resultado.")) {

                kont++;
            } else {
                datuKop++;
            }
            datuKopTotala++;

        }
    }

}
