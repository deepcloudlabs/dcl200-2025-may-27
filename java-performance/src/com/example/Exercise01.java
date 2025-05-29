package com.example;
// Ubuntu 24.02:
// Millis elapsed: 1.05225
// Millis elapsed: 4209
// Window 11:
// Millis elapsed: 1.31375
// Millis elapsed: 5255
public class Exercise01 {

	public static void main(String[] args) throws InterruptedException {
		var start = System.currentTimeMillis();
		for (var i = 0; i < 2_000; i++) {
			Thread.sleep(2);
		}
		var end = System.currentTimeMillis();
		System.out.println("Millis elapsed: " + (end - start) / 4000.0);
		System.out.println("Millis elapsed: " + (end - start));
	}

}
