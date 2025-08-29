package org.satish.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.satish.array.util.DSAUtil;

public class ArrayMediumProblems {

	public static void main(String[] args) {
		int arr[] = DSAUtil.generateRandomeArray(10);
		int arr1[] = DSAUtil.generateRandomeArrayNegPositive(10);
		int sortedArr[] = DSAUtil.generateRandomeSortedArray(10);
		checkPairIndexWithGivenSum(arr, 14);
		
		checkPairIndexWithGivenSum(sortedArr, 14);
		
		sortArrayOf0s1s2s();
		
		majorityElement(arr);
		
		giveMaximumSubarraySum(arr1);
		
		buySellStock(arr);
		
		rearrangeAlternateSamePosNeg(arr1);
		rearrangeAlternatePosNeg(arr1);
	}
	
	

	private static void rearrangeAlternatePosNeg(int[] arr1) {
		System.out.println("\nRandome positive and negative numbers");
		arr1 = new int[]{-1, -3, 9, -7, -10, 7, -1, -2, 2, 0};
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		List<Integer> pos = new ArrayList<Integer>();
		List<Integer> neg = new ArrayList<Integer>();
		int posIndex = 0;
		int negIndex = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i]>= 0) {
				pos.add(arr1[i]);
			} else {
				
				neg.add(arr1[i]);
			}
		}
		int min = Math.min(pos.size(), neg.size());
		int max = Math.max(pos.size(), neg.size());
		for(int i = 0; i < min; i++) {
			arr1[i*2] = pos.get(i);

			arr1[i*2+1] = neg.get(i);
		}
		int index = 0;
		if(pos.size() > neg.size()) {
			index = neg.size()*2;
		} else if(pos.size() < neg.size()) {
			index = pos.size()*2 ;
		}
		
		for(int i = min; i < max; i++) {
			if(pos.size() > neg.size()) {
				
				arr1[index++]= pos.get(i);
			} else {
				arr1[index++] = neg.get(i);
			}
		}
		System.out.println("Veriety of Rearranged Array");
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		
	}



	private static void rearrangeAlternateSamePosNeg(int[] arr1) {
		arr1 = new int[]{-1, -3, 9, -7, 10, 7, -1, -2, 2, 0};
		//bruteForceRearrangeAlternatePosNeg(arr1);
		
		optimalRearrangeAlternatePosNeg(arr1);
				
	}



	private static void optimalRearrangeAlternatePosNeg(int[] arr1) {
		System.out.println();
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		int ans[] = new int[arr1.length];
		int posIndex = 0;
		int negIndex = 1;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i]>= 0) {
				ans[posIndex] = arr1[i];
				posIndex += 2;
			} else {
				ans[negIndex] = arr1[i];
				negIndex += 2;
			}
		}
		System.out.println("\nOptimal Rearranged Array");
		Arrays.stream(ans).forEach(ele -> System.out.print(ele+" "));
		
	}



	private static void bruteForceRearrangeAlternatePosNeg(int[] arr1) {
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		int pos[] = new int[arr1.length];
		int neg[] = new int[arr1.length];
		int posIndex = 0;
		int negIndex = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i]>= 0) {
				pos[posIndex++] = arr1[i];
			} else {
				neg[negIndex++] = arr1[i];
			}
		}
		
		for(int i = 0; i < arr1.length/2; i++) {
			arr1[i*2] = pos[i];
			arr1[i*2+1] = neg[i];
		}
		System.out.println("Bruteforce Rearranged Array");
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));

		
	}



	private static void buySellStock(int[] arr) {
		arr = DSAUtil.generateRandomeArray(10);
		//Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		bruteforceBuySellStock(arr);
		
		optimalBuySellStock(arr);
		
	}



	private static void optimalBuySellStock(int[] arr) {
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			minPrice =Math.min(minPrice, arr[i]);
			maxProfit = Math.max(maxProfit, arr[i] - minPrice);
		}
		
		System.out.println("Optimal Maximum Profit "+ maxProfit);
		
	}



	private static void bruteforceBuySellStock(int[] arr) {
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int maxProfit = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] < arr[j])
					maxProfit = Math.max(maxProfit, arr[j]-arr[i]);
			}
		}
		
		System.out.println("Bruteforce Maximum Profit "+ maxProfit);
		
	}



	private static void giveMaximumSubarraySum(int[] arr) {
		
		
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		
		//bruteforceMaximumSubarraySum(arr);
		bruteForceMaximumSubarraySum(arr);
		
		betterMaximumSubarraySum(arr);
		
		optimalMaximumSubarraySum(arr); //Kadane's algorithm
		
	}



	private static void optimalMaximumSubarraySum(int[] arr) {
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(sum < 0) {
				sum = 0;
			} else {
				sum += arr[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println("Optimal Maximum subarray sum "+ maxSum);
	}



	private static void betterMaximumSubarraySum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			for(int j = i; j < arr.length; j++) {
				
				
				sum += arr[j];
				
				maxSum = Math.max(maxSum, sum);
				
			}
		}
		if(maxSum < 0) {
			maxSum = 0;
		}
		System.out.println("Better Maximum subarray sum "+ maxSum);
		
	}



	private static void bruteForceMaximumSubarraySum(int[] arr) {
		
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				int sum = 0;
				for(int k = i; k <= j; k++) {
					sum += arr[k];
				}
				maxSum = Math.max(maxSum, sum);
				
			}
		}
		System.out.println("Maximum subarray sum "+ maxSum);
		
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
