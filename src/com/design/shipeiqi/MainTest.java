package com.design.shipeiqi;

public class MainTest {

	public static void main(String[] args) {
		Source source =new Source();
		Wrapper wrapper =new Wrapper(source);
		wrapper.method1();
		wrapper.method2();
	}

}
