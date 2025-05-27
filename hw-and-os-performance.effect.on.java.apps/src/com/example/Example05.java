package com.example;

public class Example05 {

	public static void main(String[] args) {
		// -XX:AutoBoxCacheMax=2048
		Integer x = Integer.valueOf(42); 
		Integer y = 42; 
		Integer m = 549; 
		Integer n = 549; 
		System.out.println("x==y? %s".formatted(x==y)); // true
		System.out.println("m==n? %s".formatted(m==n)); // false
	}

}
