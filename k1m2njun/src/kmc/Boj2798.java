package kmc;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Boj2798 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		Set<Integer> arrs = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < arr.length-2; i++) {
			for(int j = i + 1; j < arr.length-1; j++) {
				for(int k = j + 1; k < arr.length; k++) {
					if(M >= arr[i] + arr[j] + arr[k]) {
						arrs.add(arr[i] + arr[j] + arr[k]);
					}
				}
			}
		}
		
		Integer max = arrs.stream().sorted().max(Comparator.comparing(x->x)) .orElseThrow(NoSuchElementException::new);

		System.out.println(max);
	}
}
