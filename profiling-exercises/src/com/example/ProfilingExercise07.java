package com.example;

import java.util.concurrent.ThreadLocalRandom;

public class ProfilingExercise07 {
    public static void main(String[] args) throws InterruptedException {
        var total = 0.0;
    	while (total >= 0) {
            total += process();
            Thread.sleep(100);
            System.out.println(total);
        }
    }
    
    public static double process() {
    	return Math.pow(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
    }
}
