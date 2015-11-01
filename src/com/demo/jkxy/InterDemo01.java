package com.demo.jkxy;

interface Inter01 {
	public static final int AGE = 1;

	public abstract void tell();
}

interface Inter02 {
	public static final int AGE1 = 1;

	public abstract void say();
}

abstract class Abs2 {
	public abstract void say2();
}

interface inter3 extends Inter02, Inter01 {

}

class A extends Abs2 implements Inter01, Inter02 {
	@Override
	public void tell() {
		System.out.println(Inter02.AGE1);
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub

	}

	@Override
	public void say2() {
		// TODO Auto-generated method stub

	}
}

public class InterDemo01 {

	public static void main(String[] args) {
		A a = new A();
		a.tell();
	}

}
