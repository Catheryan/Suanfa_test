package com.design.shipeiqi;

/**
 * 类的适配器模式
 * @author yzh
 *
 */
public class Adapter extends Source implements Targetable{

	@Override
	public void method2() {
		System.out.println("this is the targetable method!"); 		
	}

}
