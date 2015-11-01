package com.reflect.bean;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 *
 * 使用ReferenceQueue清除失去了软引用对象的SoftReference
 * @author yzh
 * @@function  高速缓存，清除应用类。
 * @param <T>
 */
public class BeanCache<T> {
	static private BeanCache cache;// 一个Cache实例
    private Hashtable<String,EmployeeRef> employeeRefs;// 用于Chche内容的存储
    private ReferenceQueue<T> q;// 垃圾Reference的队列
    private Class<T> cl;
    // 继承SoftReference，使得每一个实例都具有可识别的标识。
    // 并且该标识与其在HashMap内的key相同。
    private class EmployeeRef extends SoftReference<T> {
       private String _key = "";
 
       public EmployeeRef(T em, ReferenceQueue<T> q) {
           super(em, q);
           cl= (Class<T>) em.getClass();
           _key = getId(em, "id");
       }
    }
 
    // 构建一个缓存器实例
    public BeanCache() {
       employeeRefs = new Hashtable<String,EmployeeRef>();
       q = new ReferenceQueue<T>();
    }
 
    // 取得缓存器实例
   /* public static BeanCache getInstance() {
       if (cache == null) {
           cache = new BeanCache();
       }
       return cache;
    }*/
 
    // 以软引用的方式对一个Employee对象的实例进行引用并保存该引用
    private void cacheEmployee(T em) {
       cleanCache();// 清除垃圾引用
       //将对象方队引用队列中
       EmployeeRef ref = new EmployeeRef(em, q);
       employeeRefs.put(getId(em, "id"), ref);
    }
 
    // 依据所指定的ID号，重新获取相应Employee对象的实例
    public T getEmployee(String ID) throws InstantiationException, IllegalAccessException {
       T em = null;
       // 缓存中是否有该Employee实例的软引用，如果有，从软引用中取得。
       if (employeeRefs.containsKey(ID)) {
           EmployeeRef ref = (EmployeeRef) employeeRefs.get(ID);
           em = (T) ref.get();
       }
       // 如果没有软引用，或者从软引用中得到的实例是null，重新构建一个实例，
       // 并保存对这个新建实例的软引用
       if (em == null) {
           em = cl.newInstance();
           System.out.println("Retrieve From EmployeeInfoCenter. ID=" + ID);
           this.cacheEmployee(em);
       }
       return em;
    }
 
    // 清除那些所软引用的Employee对象已经被回收的EmployeeRef对象
    private void cleanCache() {
       EmployeeRef ref = null;
       while ((ref = (EmployeeRef) q.poll()) != null) {
           employeeRefs.remove(ref._key);
       }
    }
 
    // 清除Cache内的全部内容
    public void clearCache() {
       cleanCache();
       employeeRefs.clear();
       System.gc();
       System.runFinalization();
    }
    //获取对应的id或者编号
    private String getId(T t,String nameId){
    	Method metd=null;
		try {
			// 根据字段名找到对应的get方法，null表示无参数
			metd = cl.getMethod("get" + changeFirstOne(nameId), null);
			// 调用该字段的get方法
			String name = (String) metd.invoke(t, null);
			return name;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
    }
    public String changeFirstOne(String src) {
		if (src != null) {
			StringBuffer sb = new StringBuffer(src);
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			return sb.toString();
		} else {
			return null;
		}
	}
}
