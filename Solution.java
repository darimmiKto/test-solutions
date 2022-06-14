package Algoritm;

import java.util.ArrayList;


class Solution {
	public static void main(String[] args) {
		String one = "llo";
		String two = "loj";
		System.out.println(sol(one, two));
		System.out.println(solTwo(one, two));
	}
	
	
	private static boolean sol(String one, String two) {
		char[] oneChar = new char[one.length()];
		char[] twoChar = new char[two.length()];
		int length = one.length();
		for (int i = 0; i < length; i++) {
			oneChar[i] = one.charAt(i);
			twoChar[i] = two.charAt(i); 
		}
		int counter = 0;
		int entrance = 0;
		for (int i = 0; i < length; i++) {
			char c = oneChar[i];
			for (int j = 0; j < length; j++) {
				if (c == twoChar[j]) {
					counter++;
					entrance = entrance + 1;
					if (entrance <= 2) {
						counter--;
					}
				}
					
			}
		}
		if (counter == length) {
			return true;
		} else {
			return false;
		}
		// 3 + 2n + 2 + 1n^2 // O(n^2)
	}
	
	private static boolean solTwo(String one, String two) {
		ArrayList<Character> oneChar = new ArrayList<>();
		ArrayList<Character> twoChar = new ArrayList<>();
		int length = one.length();
		for (int i = 0; i < length; i++) {
			oneChar.add(one.charAt(i));
			twoChar.add(two.charAt(i));
		}
		oneChar.sort(null);
		twoChar.sort(null);
		int counter = 0;
		while (counter < length) {
			if (oneChar.get(counter) == twoChar.get(counter)) {
				counter = counter + 1;
			} else {
				return false;
			}
		}
		return true;
		// 3 + 2n + n log n + n log n + n // o(n log n)
	}
}
