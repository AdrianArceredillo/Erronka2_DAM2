package com.dambi.atzipenekoak;
 
public class Garbitzailea {
    public static String garbitu(String textoa) {

        String textoaFinal = "";

        for (int i = 0; i < textoa.length(); i++) {
            char c = textoa.charAt(i);
            if ((c > 32 && c < 65) || (c > 64 && c < 91) || (c > 96 && c < 123)) {
                textoaFinal += c;
            } else {
                break;
            }
        }
        return textoaFinal;
    }

    public static String data(String data) {
        String dataTxarto = "2023-01-15T23:00:00.000+00:00";
        String dataOndo = "2023-01-16 00:00:00.0";

        String[] dataZatiak1 = dataTxarto.split("T");
        String part1 = dataZatiak1[0];

        String[] dataZatiak2 = part1.split("-");

        int urtea = Integer.parseInt(dataZatiak2[0]);
        int hilabetea = Integer.parseInt(dataZatiak2[1]);
        int eguna = Integer.parseInt(dataZatiak2[2]);

        eguna ++;

        if (hilabetea == (1 | 3 | 5 | 7 | 8 | 10 | 12)){
            if (eguna == 32){
                hilabetea ++;
                if (hilabetea == 13){
                    hilabetea = 1;
                    urtea ++;
                }
                eguna = 1;
            }
        } else if(hilabetea == (4 | 6 | 9 | 11)){
            if(eguna == 31){
                hilabetea++;
                eguna = 1;
            }
        } else {
            if (urtea % 4 != 0){
                if (eguna == 29){
                    eguna = 1;
                    hilabetea++;
                }
            }
        }
        if (hilabetea > 9 && eguna > 9){
            dataOndo = urtea + "-" + hilabetea + "-" + eguna + "00:00:00.0";
        } else if(hilabetea > 9 && eguna < 10){
            dataOndo = urtea + "-" + hilabetea + "-0" + eguna + "00:00:00.0";
        } else if(hilabetea < 10 && eguna > 9){
            dataOndo = urtea + "-0" + hilabetea + "-" + eguna + "00:00:00.0";
        } else {
            dataOndo = urtea + "-0" + hilabetea + "-0" + eguna + "00:00:00.0";
        }
        return dataOndo;
    }


    public static void garbituPantaila(){
        System.out.println("============================");
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
    }

}
