package com.example.test;

import java.util.concurrent.ForkJoinPool;

import com.example.task.FibonacciTask;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class TestFibonacci {
	public static void main(String[] args) throws Exception {
		try (ForkJoinPool fjp = new ForkJoinPool()) {
			FibonacciTask ft = new FibonacciTask(49);
			long result = fjp.submit(ft).get();
			System.out.println("Fib(49)=" + result);
		}
	}
}
