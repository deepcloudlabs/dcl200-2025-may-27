package com.example;

import java.util.concurrent.ThreadLocalRandom;

public class Example03 {

	public static void main(String[] args) {
		ThreadLocalRandom.current()
		                 .ints(1, 60)
		                 .distinct()
		                 .limit(6)
		                 .sorted()
		                 .forEach(System.err::println);
	}

}
