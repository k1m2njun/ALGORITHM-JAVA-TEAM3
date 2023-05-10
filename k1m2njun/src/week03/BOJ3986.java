package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			String ab = br.readLine();
			
			if (ab.length() % 2 != 0) continue;
			
			Stack<Character> stack = new Stack<>();
			stack.push(ab.charAt(0));
			
			for(int j = 1; j < ab.length(); j++) {
				if (stack.size() > 0 && stack.peek() == ab.charAt(j)) {
					stack.pop();
				} else {
					stack.push(ab.charAt(j));
				}
			}
			if (stack.isEmpty()) count++;
		}
		System.out.println(count);
	}

}

//https://www.acmicpc.net/problem/3986