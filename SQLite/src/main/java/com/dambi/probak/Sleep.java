package com.dambi.probak;

import java.util.concurrent.TimeUnit;

public class Sleep {
    public static void main(String[] args) {
        try {
            int i = 0;
while(i > -1){
    TimeUnit.SECONDS.sleep(3);
    System.out.println(i);
    i++;
}
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
