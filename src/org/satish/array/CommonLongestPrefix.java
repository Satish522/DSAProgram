package org.satish.array;

import java.util.Arrays;

public class CommonLongestPrefix {

	public static void main(String[] args) {
		CommonLongestPrefix clp = new CommonLongestPrefix();
        String[] input = {"geeksforgeeks", "geeks", "geek", "geeker", "Assa"};
        System.out.println( "The longest Common Prefix is : " +
                                   clp.longestCommonPrefix(input));

	}

	private String longestCommonPrefix(String[] input) {
		
		if(input.length == 0)
			return null;
		
		if(input.length == 1)
			return input[0];
		
		
		Arrays.sort(input);
		
		int size = input.length;
		
		int lowest = Math.min(input[0].length(), input[size-1].length());
		
		int i=0;
		while(i<lowest && input[0].charAt(i) == input[size-1].charAt(i)) {
			
				i++;
		}
		
		
		
		
		
		return input[0].substring(0, i);
	}

}
