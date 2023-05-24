package kmc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Boj1427 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		Integer[] arr = new Integer[n.length()];
		for (int i = 0; i < n.length(); i++) {
			arr[i] = n.charAt(i) - '0';
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
