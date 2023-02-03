package com.dambi.exekutagarriak;

import javax.annotation.processing.SupportedOptions;

import com.dambi.atzipenekoak.Garbitzailea;

public class Proba1 {
    public static void main(String[] args) {
        int cont = 0;
        int maxCont = 0;
        int num = 0;
        long startTime = System.nanoTime();
        for (int i = 5; i < 115000; i++) {
            cont = 0;
            int numero = i;
            while (numero != 4 && numero != 2 && numero != 1) {
                if (numero % 2 == 0) {
                    numero /= 2;
                } else {
                    numero = (numero*3) + 1;
                }
                cont++;
                //System.out.println(numero);
            }
            if (cont > maxCont){
                maxCont = cont;
                num = i;
            }
        }
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        Garbitzailea.garbituPantaila();
        System.out.println(totalTime);
        System.out.println(num);
        System.out.println(maxCont);
        
    }
}
