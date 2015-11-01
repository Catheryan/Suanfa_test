package com.demo.jkxy;

abstract class Abs{
	private int age;
	public void tell(){
		
	}
	//³éÏó·½·¨
	public abstract void say();
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Absdemo extends Abs{

	@Override
	public void say() {
		System.out.println(getAge());
	}
	
}
public class AbsDemo01 {

	public static void main(String[] args) {
		Absdemo absdemo=new Absdemo();
		absdemo.setAge(30);
		absdemo.say();
	}

}
