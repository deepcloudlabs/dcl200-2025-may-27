package com.example;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise03 {
	private static final int THREAD_COUNT = 10;
	private static final int INCREMENT_COUNT = 1_000_000_000;
	private static int counter = 0;
	private static final ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		var executorService = Executors.newFixedThreadPool(THREAD_COUNT);

		for (var i = 0; i < THREAD_COUNT; i++) {
			executorService.submit(() -> {
				for (var j = 0; j < INCREMENT_COUNT; j++) {
					incrementCounter();
				}
			});
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
			// Wait for all tasks to complete
		}

		System.out.println("Final counter value: " + counter);
	}

	private static void incrementCounter() {
		lock.lock();
		try {
			counter++;
		} finally {
			lock.unlock();
		}
	}
}
