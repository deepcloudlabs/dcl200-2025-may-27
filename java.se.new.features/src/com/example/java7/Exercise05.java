package com.example.java7;

@SuppressWarnings("unused")
public class Exercise05 extends Object {

	public static void main(String[] args) {
		// try-with-resources
		try (PreciousResource res1 = new PreciousResource();
				PreciousResource res2 = new PreciousResource();
				PreciousResource res3 = new PreciousResource();) {
			throw new IllegalArgumentException("Something is wrong!");
		} catch (Exception e) {
			System.out.println(e);
			for (Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		}

	}

}
