package org.satish.array.sorting;

import java.util.Random;

import org.satish.array.util.DSAUtil;

public class QuickSort {
	static int steps = 0;
	
	public static void main(String[] args) {
		//int arr[] = {5,3,9,2,6,3,7};
		int arr[] = DSAUtil.generateRandomeArray(10);
		int size = arr.length;
		
		System.out.println("Before Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		quickSort(arr, 0 , size-1);
		
		
		
		System.out.println("\n\nNumber of steps :"+steps);
		System.out.println("After Selection Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void quickSort(int[] arr, int lb, int ub) {
		if(lb < ub) {
			steps++;
			int loc = partition(arr, lb, ub);
			quickSort(arr, lb, loc-1);
			quickSort(arr, loc+1, ub);
		}
	}
	
	private static int partition(int[] arr, int lb, int ub) {
		int pivot = arr[lb];
		int start = lb;
		int end = ub;
		while(start < end) {
			while(arr[start] <= pivot) {
				start++;
			}
			
			while(arr[end] > pivot) {
				end--;
			}
			if(start < end)
				swap(arr , start , end);
		}
		swap(arr , lb , end);
		return end;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	
	
}
