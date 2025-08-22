package org.satish.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.satish.array.util.DSAUtil;

public class ArrayMediumProblems {

	public static void main(String[] args) {
		int arr[] = DSAUtil.generateRandomeArray(10);
		int sortedArr[] = DSAUtil.generateRandomeSortedArray(10);
		checkPairIndexWithGivenSum(arr, 14);
		
		checkPairIndexWithGivenSum(sortedArr, 14);
		
		sortArrayOf0s1s2s();
		
		majorityElement(arr);
		
		
		
		
	}
	
	

	private static void sortArrayOf0s1s2s() {
		int arr[] = {1, 0, 2, 0, 0, 2, 1, 1, 2, 0, 1, 2, 0, 1, 0, 1, 2, 0, 2, 1, 2, 0, 1, 0, 2, 1, 0, 2, 0, 1, 0};
		betterSortArrayOf0s1s2s(arr);
		
		optimalSortArrayOf0s1s2s(arr); // Duetch national flag algorithm
	}



	private static void optimalSortArrayOf0s1s2s(int[] arr) {
		
		System.out.println("\n Sort an array of 0s, 1s and 2s element in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		int low = 0, mid = 0, high = arr.length-1;
		
		while(mid <= high) {
			if(arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if(arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;
			}
		}
		
		System.out.println("\n Optimal Sort result is ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
	}



	private static void swap(int[] arr, int low, int mid) {
		
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
		
	}



	private static void betterSortArrayOf0s1s2s(int[] arr) {
		
		System.out.println("\n Sort an array of 0s, 1s and 2s element in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		int count0=0, count1=0, count2=0;
		
		for(int ele : arr) {
			if(ele == 0) {
				count0++;
			} else if(ele == 1) {
				count1++;
			} else {
				count2++;
			}
		}
		
		for(int i = 0; i < count0; i++) arr[i] = 0;
		for(int i = count0; i < count0+count1; i++) arr[i] = 1;
		for(int i = count0+count1; i < count0+count1+count2; i++) arr[i] = 2;
		
		System.out.println("\n Sort result is ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
	}



	private static void majorityElement(int[] arr) {
		arr = new int[]{1, 2, 3, 2, 2, 2, 5,6,8,8,8,8,8,8,8,8};
		
		System.out.println("\n Check majority element in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		bruteForceMajorityElement(arr);
		
		betterMajorityElement(arr);
		
		optimalMajorityElement(arr); // Moories voting algorithm
		
	}



	private static void optimalMajorityElement(int[] arr) {
		System.out.println("\n Optimal approach number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int count = 0;
		int ele=0;
		for(int i = 0; i < arr.length; i++) {
			
			if(count == 0) {
				ele = arr[i];
				count = 1;
			} else if(arr[i] == ele) {
				count++;
			} else {
				count--;
			}
		}
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ele) {
				counter++;
			}
		}
		
		if(count >= arr.length/2) {
			System.out.println("Optimal approach ==> Number is :  "+ele);
		
		}
	}



	private static void betterMajorityElement(int[] arr) {
		System.out.println("\n Better approach number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int ele : arr) {
			map.put(ele, map.getOrDefault(ele, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= arr.length/2) {
				System.out.println("Better approach ==> Number is :  "+entry.getKey());
				break;
			}
		}	
	}



	private static void bruteForceMajorityElement(int[] arr) {
		System.out.println("\n Brute force approach number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int count = 1;
		int major = arr.length/2;
		for(int i = 1; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			if(count >= major) {
				System.out.println("Better approach ==> Number is :  "+arr[i]);
				break;
			}
			count = 1;
		}
	}



	private static void checkPairIndexWithGivenSum(int[] arr, int sum) {
		bruteforceCheckPairIndexWithGivenSum(arr, sum);
		
		betterCheckPairIndexWithGivenSum(arr, sum);
		
		optimalCheckPairIndexWithGivenSum(arr, sum);
	}

	private static void optimalCheckPairIndexWithGivenSum(int[] arr, int sum) {
		// Sort arreay and two pointer both end increase or decrease according to target sum
		Arrays.sort(arr);
		System.out.println("\n Optimal approach number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int rem = 0;
		int i =0 , j = arr.length-1;
		while(i < j) {
			int targetSum = arr[i] + arr[j];
			if(targetSum == sum) {
				System.out.println("Better approach ==> Number pairs are :  "+arr[i]+", "+ arr[j]);
				break;
			} else if(targetSum < sum)
				i++;
			else if(targetSum > sum) 
				j--;
			
		}
		
	}
	
	

	private static void betterCheckPairIndexWithGivenSum(int[] arr, int sum) {
		// Use hashing approach
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			
			int other = sum - arr[i];
			if(map.containsKey(other)) {
				System.out.println("Better approach ==> Number pairs are :  "+arr[i]+", "+ other);
				break;
			} 
			map.put(arr[i], i);
			
		}
		
	}

	private static void bruteforceCheckPairIndexWithGivenSum(int[] arr, int sum) {
		// Dual loop to find the index
		System.out.println("\n Check number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		for(int i =0; i < arr.length; i++) {
			
			for(int j = i+1; j < arr.length; j++ ) {
				
				int targetSum = arr[i]+arr[j];
				
				if(targetSum == sum) {
					System.out.println("Number pairs are :  "+arr[i]+", "+ arr[j]);
					break;
				}
			}
		}
		
		
	}

}
