package org.satish.array.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 6,5,3,7,2,1};
		
		System.out.println("Before Sorting....");
		for(int i :arr) {
			System.out.print(i+" ");
		}
		 
		int left =0;
		int right =arr.length-1;
		mergeSort(arr, left, right);
		
		System.out.println("\nAfter Sorting....");
		for(int i :arr) {
			System.out.print(i+" ");
		}
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
		
		
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		int lArr[] = new int[n1];
		int rArr[] = new int[n2];
		
		for(int x = 0; x < n1; x++) {
			lArr[x]= arr[left+x];
		}
		
		for(int x = 0; x<n2; x++) {
			rArr[x] = arr[mid+1+x];
			
		}
		
		int i =0;
		int j = 0;
		int k =left;
		
		while(i<n1 && j<n2) {
			if(lArr[i] <= rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}
		
		while(i < n1 ) {
			arr[k] = lArr[i];
			i++;k++;
		}
		
		while(j < n2 ) {
			arr[k] = rArr[j];
			j++;k++;
		}
		
	}

}
