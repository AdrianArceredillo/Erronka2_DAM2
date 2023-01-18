package com.dambi.atzipenekoak;

public class Garbitzailea {
    public static String garbitu (String textoa){

        String textoaFinal = "";

        for (int i = 0; i < textoa.length(); i++){
            char c = textoa.charAt(i);
            if ((c > 32 && c < 65) || (c > 64 && c < 91) || (c > 96 && c < 123)){
                textoaFinal += c;
            } else {
                break;
            }
        }
        return textoaFinal;
    }
    
}
