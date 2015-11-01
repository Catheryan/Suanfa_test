package com.java.sort;
/**
 * @function 合并有序序列。
 */
public class SortGuibingTest {

	 // 将有序数组a[]和b[]合并到c[]中  
    static void MemeryArray(int a[], int n, int b[], int m, int c[]) {  
        int i, j, k;  
  
        i = j = k = 0;  
        while (i < n && j < m) {  
            if (a[i] < b[j])  
                c[k++] = a[i++];  
            else  
                c[k++] = b[j++];  
        }  
  
        while (i < n)  
            c[k++] = a[i++];  
  
        while (j < m)  
            c[k++] = b[j++];  
    }  
      
    public static void main(String[] args) {  
        int a[] = { 2, 7, 8, 10, 299 };  
        int b[] = { 5, 9, 14, 20, 66, 88, 92 };  
        int c[] = new int[a.length + b.length];  
        MemeryArray(a, 5, b, 7, c);  
        print(c);  
    }  
  
    private static void print(int[] c) {  
        for (int i = 0; i < c.length; i++) {  
            System.out.print(c[i] + " ");  
        }  
    }  

}
