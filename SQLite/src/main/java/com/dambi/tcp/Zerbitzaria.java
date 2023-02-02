package com.dambi.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Statement;
import java.util.ArrayList;

import com.dambi.object.Datuak;

public class Zerbitzaria {

    public static String mezua;
    public static int kont;
    public static ArrayList<String> iDak;

    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        mezua = "";
        kont = 0;
        iDak = new ArrayList<String>();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int numeroPuerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente ");
        clienteConectado = servidor.accept();

        // inStream = new ObjectInputStream(socket.getInputStream());

        InputStream inputStream = clienteConectado.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Datuak datuak = new Datuak();
        datuak = (Datuak) objectInputStream.readObject();

        // System.out.println(datuak.getPartida());
        // System.out.println(datuak.getLangilea());

        String sql = "INSERT INTO partida VALUES " + sqlPrestatu(datuak.getPartida());
        // System.out.println(sql);
        // exekuzioa(sql);

        // sql = "INSERT INTO langilea VALUES " + sqlPrestatu(datuak.getLangilea());
        // System.out.println(sql);
        // exekuzioa(sql);

        sql = "INSERT INTO aa_proba_taula VALUES (19, 'Proba', 420)";
        System.out.println(exekuzioa(sql));

        sql = "INSERT INTO aa_proba_taula VALUES (19, 'Proba', 420)";
        System.out.println(exekuzioa(sql));


        sql = "INSERT INTO aa_proba_taula VALUES (20, 'Proba', 420)";
        System.out.println(exekuzioa(sql));


        sql = "INSERT INTO aa_proba_taula VALUES (20, 'Proba', 420)";
        System.out.println(exekuzioa(sql));


        sql = "INSERT INTO aa_proba_taula VALUES (21, 'Proba', 420)";
        System.out.println(exekuzioa(sql));



        //sql = "INSERT INTO partida VALUES (130, 'alainnnn', 2349057, '2023-01-25')";
        //exekuzioa(sql);

        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        flujoSalida.writeUTF(mezua);

        salida.close();
        flujoSalida.close();
        clienteConectado.close();
        servidor.close();

    }




    public static void exekuzioa(ArrayList<String> list) {
        Konexioa konekzioa = new Konexioa();
        Statement st;

        for (String datuak : list) {
            try {
                String sql = "INSERT INTO partida VALUES " + datuak;
                st = konekzioa.connectDatabase().createStatement();
                st.executeQuery(sql);
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
                // Errorerik ez bada egon datuak sartzeko orduan
                if (ex.equals("org.postgresql.util.PSQLException: No results were returned by the query.")) {

                    String[] parts1 = datuak.split(","); //Datuak banatu "INSERT INTO partida VALUES (130" <- horrelako zerbait lortuz
                    String part1 = parts1[0];
                    String[] parts2 = part1.split("("); //Berriro banatu "130" lortuz, hau da, ID-a. Datu hau gero berriro erabiltzailera bidaliko da id-horrek dituen datuak ezabatzeko
                    String id = parts2[0];
                    iDak.add(id);
                } else {
                    mezua += ex + "\n";
                }
            }

        }

    }


/**
 * Metodo honek sql agindu bat exekutzatzen du
 * 
 * @param sql SQL agindua
 * @return Errore kantitatea bueltatzen du.
 */


    public static String exekuzioa(String sql) {
        mezua = "Errore kopurua: ";
        Konexioa konekzioa = new Konexioa();
        Statement st;
            try {
                st = konekzioa.connectDatabase().createStatement();
                st.executeQuery(sql);
            } catch (Exception ex) {

                String exceptionMessage = ex.toString();

                if (!exceptionMessage.equals("org.postgresql.util.PSQLException: No results were returned by the query.")){
                    kont++;
                }
            }
            return mezua += kont;
    }



    public static String sqlPrestatu(ArrayList<String> list) {
        // System.out.println(list);

        String result = "";

        for (String string : list) {
            result += "(" + string + "), ";
        }

        return result = result.substring(0, result.length() - 2);
    }

}
