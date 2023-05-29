package week06;

import java.util.Scanner;

public class BOJ1541 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.nextLine().split("-");
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < s.length; i++) {
			
			int sum = 0;
			
			String[] add = s[i].split("\\+");
			
			for(String num : add) {
				sum += Integer.parseInt(num);
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = sum;
			} else {
				answer -= sum;
			}
		}
		System.out.println(answer);
	}
}

//https://www.acmicpc.net/problem/1541