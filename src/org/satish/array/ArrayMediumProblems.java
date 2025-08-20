package org.satish.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.satish.array.util.DSAUtil;

public class ArrayMediumProblems {

	public static void main(String[] args) {
		int arr[] = DSAUtil.generateRandomeArray(10);
		int sortedArr[] = DSAUtil.generateRandomeSortedArray(10);
		checkPairIndexWithGivenSum(arr, 14);
		
		checkPairIndexWithGivenSum(sortedArr, 14);
		
		majorityElement(arr);
		
		
		
		
	}
	
	

	private static void majorityElement(int[] arr) {
		arr = new int[]{1, 2, 3, 2, 2, 2, 5,6,8,8,8,8,8,8,8,8};
		
		System.out.println("\n Check majority element in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		bruteForceMajorityElement(arr);
		
		betterMajorityElement(arr);
		
		optimalMajorityElement(arr);
		
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
