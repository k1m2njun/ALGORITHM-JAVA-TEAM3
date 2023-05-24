package kmc;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int size = 0;
		int answer;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			size ++;
			
			int[] copyArr = new int[size];
			for(int j = 0; j < size; j++) {
				copyArr[j] = arr[j];
			}
			Arrays.sort(copyArr);
			
			if(size % 2 == 0) {
				answer = copyArr[size / 2 - 1];
			} else {
				answer = copyArr[size / 2];
			}
			
			System.out.println(answer);
		}
	}
}
