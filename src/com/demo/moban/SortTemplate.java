package com.demo.moban;
/**
 * 
 * @author yzh
 * 子类进行实现
 * 数组进行冒泡排序
 *
 */
public abstract class SortTemplate {
	public final void sort(Object[] objects) {
			for (int i = 0,len=objects.length-1; i < len; i++) {
				if (compare(objects[i+1])>0) {
					
				}else{
					
				}
			}
	}
	public abstract int compare(Object objects);
}
