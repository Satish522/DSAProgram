package org.satish.array.sorting;

import org.satish.array.util.DSAUtil;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = DSAUtil.generateRandomeArray(10);
		int size = arr.length;
		int steps = 0;
		System.out.println("Before Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		for(int i=0; i<size;i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j] > key) {
				steps++;
				arr[j+1] = arr[j];
				j--;
				
			}
			arr[j+1] = key;
			
			System.out.println();
			for(int ele : arr) {
				System.out.print(ele + " ");
			}
		}
		
		
		
		
		System.out.println("\n\nNumber of steps :"+steps);
		System.out.println("After Selection Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		
		

	}

}
