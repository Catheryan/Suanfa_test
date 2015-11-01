package com.demo.moban;

/**
 * 
 * @author 传递数组对象，进行模板
 *
 *在实现一个接口对象
 */
public class Duck implements Comparable{
	String name="";
	int weight=1;
	
	public Duck(String name,int weight){
		this.name=name;
		this.weight=weight;
	}
	public String toString(){
		return name+" weight:"+weight;
	}
	@Override
	public int compareTo(Object o) {
		Duck duck=(Duck)o;
		if (this.weight>duck.weight) {
			return 1;
		}else if(this.weight<duck.weight){
			return -1;
		}
		return 0;
	}

}
