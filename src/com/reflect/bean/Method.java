package com.reflect.bean;

import java.lang.reflect.Modifier;

public class Method {

	public void show(Object ob) {
		Class cl = ob.getClass();
		java.lang.reflect.Method[] mt = cl.getDeclaredMethods();
		for (java.lang.reflect.Method mm : mt) {
			System.out.println("方法名称：" + mm.getName());
			System.out.println("方法修饰符：" + Modifier.toString(mm.getModifiers()));
			System.out.println("方法返回值类型：" + mm.getReturnType());
			System.out.println("方法参数：");
			Class[] preType = mm.getParameterTypes();
			for (Class cll : preType) {
				System.out.println(cll.getName());
			}
		}
	}

	public void showUseMethod(Object ob) {
		Class cl = ob.getClass();
		try {
			java.lang.reflect.Method me = cl.getMethod("setName", String.class);
			me.invoke(ob, "nima");

			Class[] cll = { String.class, int.class };
			java.lang.reflect.Method mt2 = cl.getMethod("getNames", cll);
			Object[] ob2={"daibi",2};
			mt2.invoke(ob, ob2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Book book2 = new Book();
		book2.setId(2);
		book2.setName("wanger");
		book2.setType("renming");
		Method mt = new Method();
		//mt.show(book2);
		mt.showUseMethod(book2);
	}
}
