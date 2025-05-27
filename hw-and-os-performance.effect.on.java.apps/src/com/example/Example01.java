package com.example;

public class Example01 {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2_000; i++) {
			Thread.sleep(2);
		}
		long end = System.currentTimeMillis();
		System.out.println("Millis elapsed: " + (end - start - 4000) / 40.0);
		System.out.println("Millis elapsed: " + (end - start));
	}
}
/*
Ubuntu:
   Millis elapsed: 8.875
   Millis elapsed: 4355
Windows:
   Millis elapsed: 28.35
   Millis elapsed: 5134
*/