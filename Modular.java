package Algoritm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Modular {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int one = input.nextInt();
		int two = input.nextInt();
		int m = modular(new int[] {3, 5, 7}, one, two);
		System.out.println(m);
		input.close();
	}
	
	private static int modular(int[] arr, int intInpOne, int intInpTwo) {
		int[] arrModelOne = new int[arr.length];
		int[] arrModelTwo = new int[arr.length];
		int[] otvet = new int[arr.length];
		int M = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			arrModelOne[i] = intInpOne % arr[i];
			arrModelTwo[i] = intInpTwo % arr[i];
			otvet[i] = (arrModelOne[i] * arrModelTwo[i]) % arr[i];
			M = M * arr[i];
		}
		int MNum = 0;
		int otvetInt = 0;
		for (int i = 0; i < arr.length; i++) {
			MNum = M / arr[i];
			map.put(MNum , 0);
			map.put(MNum, MNum % arr[i]);
			otvetInt = otvetInt + (otvet[i] * MNum * map.get(MNum));
		}
		return otvetInt % M;
	}
}	
