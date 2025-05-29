package com.example;

import java.util.ArrayList;

public class UseArrayList {
	static ArrayList<Integer> list = new ArrayList<>(100_000_000);

	public static void main(String[] args) {
		
		//var array = new Integer[Integer.MAX_VALUE];
		var start = System.currentTimeMillis();
		for (var i=0;i<100_000_000;++i)
			list.add(i%128);
//			array[i] = i;
		var stop = System.currentTimeMillis();
		System.err.println("list.size()=%d @ %d ms.".formatted(list.size(),stop-start));
	}

}
