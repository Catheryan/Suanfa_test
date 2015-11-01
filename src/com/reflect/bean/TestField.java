package com.reflect.bean;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Field;

public class TestField {
	public void show(Class cl) {
		Field[] fd=cl.getDeclaredFields();//可以访问私有属性
		
		for (Field ff:fd) {
			System.out.println(ff.getName());
			System.out.println(ff.getType());
		}
		System.out.println(fd);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Field[] fd2=cl.getFields();//只可以获取到公有属性
		for (Field ff:fd2) {
			System.out.println(ff.getName());
			System.out.println(ff.getType());
		}
		
	}
	
	//获取 实体类的 属性和值
	public void show2(Object ob) {
		Class cl =ob.getClass();
		Field[] fd=cl.getDeclaredFields();//可以访问私有属性
		try {
			for (Field ff:fd) {
				ff.setAccessible(true);
				System.out.println(ff.getName());
				System.out.println(ff.get(ob));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			Book book1=new Book();
			book1.setId(2);;
			book1.setName("人");
			book1.setType("男");
			
			TestField tf =new TestField();
			//tf.show(Book.class);
			tf.show2(book1);
	}

}
