package org.satish.array;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = {34,53,11,2,4,6};
		
		reverse(arr, 0, arr.length-1);
	}

	private static void reverse(int[] arr, int i, int j) {
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int start, int end) {
		
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		
		
	}
	
	

}
