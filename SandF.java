package Algoritm;

import java.util.Scanner;

class SandF {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int inputOne = input.nextInt();
		char[] newArray = input(inputOne);
		String p =cityHome(newArray);
		System.out.println(p);
		input.close();
	}
	
	private static char[] input(int size) {
		char[] array = new char[size];
		String t = input.next();
		for (int i = 0; i < size; i++) {
			array[i] = t.charAt(i);
		}
		return  array;
	}
	
	private static String cityHome(char[] array) {
		int SF = 0;
		int FS = 0;
		int S = 0;
		int F = 0;
		int size = array.length;
		int j = 0;
		for (int i = 0; i < size - 1; i++) {
			if (array[i] == 'S' && array[i + 1] == 'F') {
				SF = SF + 1;
				i = i + 1;
			} else if (array[j] == 'F' && array[j + 1] == 'S') {
				FS = FS + 1;
				j = j + 1;
			} else {
				i++;
			}
			j++;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 'S') {
				S = S + 1;
			} else {
				F = F + 1;
			}
		}
		if (SF > FS) {
			return "YES";
		} else if (FS > SF) {
			return "NO";
		} else if (SF == 0 && FS == 0 && F > S){
			return "NO";
		} else if (SF == 0 && FS == 0 && S > F) {
			return "NO";
		} else if (S > F || F > S) {
			return "NO";
		} else {
			return "NO";	
		}
	}
}