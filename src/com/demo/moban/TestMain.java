package com.demo.moban;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		Duck[] duck={new Duck("Duck1", 1),
				new Duck("Duck2",2),
				new Duck("Duck3", 4),
				new Duck("Duck4", 3),
				new Duck("Duck5", 22),
				new Duck("Duck6", 21),
				new Duck("Duck7", 33)};
		System.out.println("before:");
		display(duck);
		Arrays.sort(duck);
		System.out.println("after:");
		display(duck);
		
	}
	public static void display(Duck[] duck){
		for (int i = 0,len=duck.length; i < len; i++) {
			System.out.println(duck[i]);
		}
	}
}
