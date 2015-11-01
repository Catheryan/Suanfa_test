package com.reflect.bean;

import java.awt.print.Book;

public class TestBook {

	public static void main(String[] args) {

		Class demo1=null;
		Class demo2=null;
		Class demo3=null;
		
		try {
			demo1=Class.forName("com.reflect.bean.Book");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(demo1);
		
		
		Book book1=new Book();
		System.out.println("第二种："+book1.getClass());
		
		demo3= Book.class;
		System.out.println(demo3);
		
		try {
			Book bo1=(Book) demo3.newInstance();
			System.out.println(bo1);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
