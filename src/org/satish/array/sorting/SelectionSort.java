package org.satish.array.sorting;

import java.util.Random;

import org.satish.array.util.DSAUtil;

public class SelectionSort {

	public static void main(String[] args) {
		//int arr[] = {5,3,9,2,6,3,7};
		int arr[] = DSAUtil.generateRandomeArray(30);
		int size = arr.length;
		int steps = 0;
		System.out.println("Before Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//Approach 1
		int minIndex = -1;
		for(int i=0; i<size; i++) {
			minIndex = i;
			for(int j=i; j<size;j++) {
				steps++;
				if(arr[minIndex]>arr[j])
					minIndex = j;
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
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
