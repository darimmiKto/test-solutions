package Algoritm;

import java.util.ArrayList;

class Solution {
	 public static void main(String[] args) {
		 String one = "leetcode";
		 String two = "etco";
		 int num = minDistance(one, two);
		 System.out.println(num);
	 }
	 
	 private static int minDistance(String word1, String word2) {
		 ArrayList<Character>oneChar = new ArrayList<>();
		 ArrayList<Character>twoChar = new ArrayList<>();
		 ArrayList<Character>threeChar = new ArrayList<>();
		 for (int i = 0; i < word1.length(); i++) {
			 oneChar.add(word1.charAt(i));
		 }
		 for (int i = 0; i < word2.length(); i++) {
			 twoChar.add(word2.charAt(i));
		 }
		 if (twoChar.size() < oneChar.size()) {
			 for (int i = 0; i < oneChar.size(); i++) {
				 for(int j = 0; j < twoChar.size(); j++) {
					 if (oneChar.get(i) == twoChar.get(j)) {
						 threeChar.add(oneChar.get(i));
						 oneChar.set(i, '*');
						 twoChar.set(j, '*');
					 }
				 }
			 } 
		 } else {
			 for (int i = 0; i < twoChar.size(); i++) {
				 for(int j = 0; j < oneChar.size(); j++) {
					 if (twoChar.get(i) == oneChar.get(j)) {
						 threeChar.add(twoChar.get(i));
						 twoChar.set(i, '*');
						 oneChar.set(j, '*');
					 }
				 }
			 } 
		 }
		 int minusCounter = 0;
		 for (int i = threeChar.size(); i > 0; i--) {
			 if (threeChar.get(i - 1) == '*') {
				 minusCounter++;
			 }
		 }
		 int threeSize = threeChar.size() - minusCounter;
		 int number = (oneChar.size() - threeSize) + (twoChar.size() - threeSize); 
		 return number;
	 }
}
