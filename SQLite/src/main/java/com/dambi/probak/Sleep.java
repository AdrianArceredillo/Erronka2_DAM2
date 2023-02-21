package com.dambi.probak;

import java.util.concurrent.TimeUnit;

public class Sleep {
    public static void main(String[] args) throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);
        System.out.println("proba1");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("proba2");
    }
}
