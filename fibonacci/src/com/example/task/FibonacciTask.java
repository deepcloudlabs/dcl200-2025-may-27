package com.example.task;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class FibonacciTask extends RecursiveTask<Long> {
	private long n;

	public FibonacciTask(long n) {
		this.n = n;
	}

	@Override
	protected Long compute() {
		if (n == 0 || n == 1)
			return n;
		FibonacciTask t1 = new FibonacciTask(n - 1);
		FibonacciTask t2 = new FibonacciTask(n - 2);
		t1.fork();
		return t2.compute() + t1.join();
	}

}
