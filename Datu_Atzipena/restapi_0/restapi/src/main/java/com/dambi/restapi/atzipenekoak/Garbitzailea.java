package com.dambi.restapi.atzipenekoak;

public class Garbitzailea {
    public static String Garbitu (String texto) {
        String textoFinal = "";
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ((c > 32 && c < 65) || (c > 64 && c < 91) || (c > 96 && c < 123)) {
                textoFinal += c;
            } else {
                break;
            }
        }
        return textoFinal;
    }
}
