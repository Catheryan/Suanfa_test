package com.java.sort;


public class MergeSort {

	private static void mergeSort(int[] data, int start, int end) {
		if (end > start) {
			int pos = (start + end) / 2;
			mergeSort(data, start, pos);
			mergeSort(data, pos + 1, end);
			merge(data, start, end, pos);
		}
	}

	private static void merge(int[] data, int start, int end, int position) {
		int len1 = position - start + 1;
		int len2 = end - position;
		int A[] = new int[len1 + 1];
		int B[] = new int[len2 + 1];
		for (int i = 0; i < len1; i++) {
			A[i] = data[i + start - 1];
		}
		//A[len1] = Integer.MAX_VALUE;// 避免最后的数字不一样,填充最后一个数字
		for (int i = 0; i < len2; i++) {
			B[i] = data[i + position];
		}
		//B[len2] = Integer.MAX_VALUE;// 避免最后的数字不一样
		int m = 0, n = 0;
		for (int i = start - 1; i < end; i++) {
			if (A[m] > B[n]) {
				data[i] = B[n];
				n++;
			} else {
				data[i] = A[m];
				m++;
			}
		}
	}

	private static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	public static void main(String args[]) {
		int data[] = { 8, 16, 99, 732, 10, 1, 29, 66 };
		print(data);
		System.out.println();
		mergeSort(data, 1, data.length);
		print(data);
	}
}
