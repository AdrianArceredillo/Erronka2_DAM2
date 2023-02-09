package com.dambi.restapi.erabilgarria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static void logIdatzi(String text){
                    // Log-a idatzi
                    try {
                        System.out.println(new File("").getAbsolutePath());
                        FileWriter fw = new FileWriter("./restapi/src/main/data/log.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        bw.write("[" + formatter.format(date) + "]" + text);
                        bw.newLine();
                        bw.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
    }
    
}
