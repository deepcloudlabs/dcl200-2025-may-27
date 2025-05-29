package com.example.test;

import java.util.HashSet;
import java.util.Objects;

public class Exercise08 {

	public static void main(String[] args) {
		var set = new HashSet<>();
		set.add(new ABC(42));
		var start = System.currentTimeMillis();
//		for (var i = 0; i < 10_000_000; ++i) {
//			set.add(new ABC(i));
//		}
		System.out.println(set.size());
		while (!set.isEmpty()) {
			set.remove(new ABC(42));
			System.out.println(set.size());
		}
		System.out.println(set.size());
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms. length: %d".formatted(stop - start,set.size()));
		
	}

}

record R1(int x) {}
class ABC {
	private int x;

	public ABC(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ABC other = (ABC) obj;
		return x == other.x;
	}


	
}