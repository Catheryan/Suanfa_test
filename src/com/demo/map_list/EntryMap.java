package com.demo.map_list;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EntryMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("d", 2);
		map.put("c", 1);
		map.put("b", 1);
		map.put("a", 3);

		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());

		// 排序前
		for (int i = 0; i < infoIds.size(); i++) {
			String id = infoIds.get(i).toString();
			System.out.println(id);
		}
		// d 2
		// c 1
		// b 1
		// a 3

		// 排序
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				// return (o2.getValue() - o1.getValue());
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});

		// 排序后
		for (int i = 0; i < infoIds.size(); i++) {
			String id = infoIds.get(i).getValue().toString();
			System.out.println(id);
		}
		// 根据key排序
		// a 3
		// b 1
		// c 1
		// d 2
		// 根据value排序
		// a 3
		// d 2
		// b 1
		// c 1

		/*
		 * List<Map.Entry<String,Double>> termls = new
		 * ArrayList<Map.Entry<String,Double>>(); for(String s:
		 * tf.get(i).keySet()) { termls.add(new AbstractMap.SimpleEntry(s,
		 * tf.get(i).get(s)*1.0*Math.log10(count*1.0/df.get(s)))); }
		 * Collections.sort(termls, new Comparator<Map.Entry<String, Double>>(){
		 * public int compare(Map.Entry<String, Double> o1,Map.Entry<String,
		 * Double> o2){ return(o2.getValue().compareTo(o1.getValue())); }
		 * 
		 * } ); System.out.println("line " + (i+1)); for (int ind = 0; ind <
		 * termls.size(); ++ind){
		 * System.out.print(termls.get(ind).toString()+"  "); }
		 * System.out.println();
		 */

		/*
		 * Map是java中的接口，Map.Entry是Map的一个内部接口。
		 * 
		 * Map提供了一些常用方法，如keySet()、entrySet()等方法。
		 * 
		 * keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
		 * 
		 * Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）
		 * 。接口中有getKey(),getValue方法。
		 */

		// 由以上可以得出，遍历Map的常用方法：

		Map map1 = new HashMap();

		Iterator iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {

			Map.Entry entry = (Map.Entry) iterator.next();

			Object key = entry.getKey();

		}

		Map map2 = new HashMap();

		Set keySet = map.keySet();

		Iterator iterator2 = keySet.iterator();

		while (iterator.hasNext()) {

			Object key = iterator.next();

			Object value = map.get(key);

		}

		// 另外，还有一种遍历方法是，单纯的遍历value值，Map有一个values方法，返回的是value的Collection集合。通过遍历collection也可以遍历value,如

		Map map3 = new HashMap();

		Collection c = map.values();

		Iterator iterator3 = c.iterator();

		while (iterator.hasNext()) {

			Object value = iterator.next();

		}
	}
}
