package com.example;

import java.util.List;

public class Example04 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int i = 42; // 4-byte
		Integer j = Integer.valueOf(542); // Stack: 4-byte, Heap: 12-byte + 4-byte = 16-byte = 20-byte
		// -XX:+CompressedOops
		List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42); // Cache?
		int[] arrayOfNumbers = new int[] { 4, 8, 15, 16, 23, 42 };
		for (var number : numbers) { // cannot utilize cache!

		}
		for (var number : arrayOfNumbers) { // can utilize number

		}
		List<Circle> circles = List.of(new Circle(1, 2, 3), new Circle(4, 5, 6), new Circle(7, 8, 9));
		// Heap: 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
		// 8 8 8 8 8 8 8 8 8
		// H | x | 1 | 2 | 3 | H | x | 4 | 5 | 6 |H | x | 7 | 8 | 9 |
		// 12 4 8 8 8 12 4 8 8 8 12 4 8 8 8

	}
}

record Circle(double x, double y, double radius) {

}
