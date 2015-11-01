package com.reflect.bean;

public class Book {
	private int id;
	private String name;
	private String type;
	public int a;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void getNames(String name,int nums) {
		// TODO Auto-generated method stub
		System.out.println("调用了该方法");
	}
}
