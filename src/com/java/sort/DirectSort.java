package com.java.sort;

public class DirectSort {
	/**
	 * 直接排序算法 本排序适合：基本有序的数据
	 * 思路上从待排序的数据中选出一个，插入到前面合适的位置，耗时点在插入方面，合适的位置意味着我们需要进行比较找出哪是合适的位置
	 * ，举个例子：对于9,2,7
	 * ,19,100,97,63,208,55,78这组数，第一个数9前面没有，不做操作，当第一个数完后，剩下的数就是待排序的数
	 * ，我们将要从除去9开始的书中选出一个插入到前面合适的位置
	 * ，拿到2后，放在tmp上，进行注释中的2处的代码，2处的代码就是通过循环找出这个合适的位置，
	 * 发现比tmp大的数，立即将该数向后移动一位（这样做的目的是：前面需要空出一位来进行插入），最后通过注释3处的代码将数插入。
	 * 
	 * @author yzh
	 * 从小到大的顺序进行排序，
	 */
	public static void insertSort(int[] data) {
		int temp, j = 0;
		for (int i = 0; i < data.length; i++) {
			temp = data[i];
			j = i - 1;
			while (j >= 0 && temp < data[j]) {
				data[j + 1] = data[j];
				j--;//这一步主要进行顺序调换的结果，
			}
			data[j + 1] = temp;//主要进行将空位进行补充。
		}
	}

	public static void main(String[] args) {
		int[] data = { 9, 2, 7, 19, 100, 97, 63, 208, 55, 78 };
		// insertSort(data);
		// selectSort(data);
		//sort(data, 2, data.length - 1);
		print(data);
	}

	static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	/**
	 * 选择排序,该算法不太可靠 通过循环，找出最小的数的下标，赋值于k，即k永远保持待排序数据中最小的数的下标，最后和当前位置i互换数据即可。
	 */
	public static void selectSort(int[] data) {
		int i, k, temp = 0;
		for (i = 0; i < data.length - 1; i++) {
			k = i;
			for (int l = i + 1; l < data.length; l++) {
				if (data[l] < data[k]) {
					k = l;
				}
				if (k != i) {
					temp = data[i];
					data[i] = data[k];
					data[k] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序，利用指针进行排序
	 * 分别指向第一个和最后一个，i像后移动，j向前移动，选第一个数为标准（一般这样做，当然快排的关键就是这个“标准”的选取），
	 * 从后面开始，找到第一个比标准小的数
	 * ，互换位置，然后再从前面，找到第一个比标准大的数，互换位置，第一趟的结果就是标准左边的都小于标准，右边的都大于标准
	 * （但不一定有序），分成两拨后，继续递归的使用上述方法，最终有序！
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int array[], int low, int high) {
		int key = array[low];
		while (low < high) {
			while (low < high && array[high] >= key) {
				high--;
			}//表示的是右边的顺序都是大的
			array[low] = array[high];
			while (low < high && array[low] <= key) {
				low++;
			}
			array[high] = array[low];//表示左边的顺序进行有序
		}
		array[low] = key;

		return low;

	}

	public static int[] sort(int[] data, int low, int high) {
		if (low < high) {
			int result = partition(data, low, high);
			sort(data, low, result - 1);
			sort(data, result + 1, high);
		}
		return data;
	}

	/**
	 * 冒泡排序
	 * 小的数一点一点向前起泡，最终有序。
	 */
	public static void bubbleSort(int data[]) {
		int temp = 0;
		for (int k = 0; k < data.length; k++) {
			for (int i = data.length - 1; i > k; i--) {
				if (data[i] < data[i - 1]) {
					temp = data[i];
					data[i] = data[i - 1];
					data[i - 1] = temp;
				}
			}
		}
	}
}
