package kmc;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1920 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrN = new int[n];
		for (int i = 0; i < n; i++) {
			arrN[i] = sc.nextInt();
		}
		
		Arrays.sort(arrN);
		
		int m = sc.nextInt();
		int[] arrM = new int[m];
		for (int i = 0; i < m; i++) {
			arrM[i] = sc.nextInt();
			System.out.println(binarySearch(arrN, arrM[i]));
		}
	}
	
	public static int binarySearch(int[] arr, int num) {
		if (arr[arr.length/2] > num) {
			for (int i = 0; i < arr.length/2; i++) {
				
			}
		}
		
		return 0;
	}

}
