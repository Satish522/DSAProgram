package org.satish.array;

public class SearchinString {

	public static void main(String[] args) {
		String name = "Satish";
		
		char target = 't';
		
		search2(name, target);
		
	}

	private static void search2(String name, char target) {
		if(name.length() == 0) {
			System.out.println("Something wrong......................");
		}
		
		for(char c : name.toCharArray()) {
			if(target == c) {
				System.out.println("Yeah..... You found it :) ........................");
				return;
			}
		}
		System.out.println("Ohhh Nooo................ We can't find your desire................");
		
}
	
	private static void search(String name, char target) {
			if(name.length() == 0) {
				System.out.println("Something wrong......................");
			}
			
			for(int i=0; i< name.length(); i++) {
				if(target == name.charAt(i)) {
					System.out.println("Yeah..... You found it :) ........................");
					return;
				}
			}
			System.out.println("Ohhh Nooo................ We can't find your desire................");
			
	}

}
