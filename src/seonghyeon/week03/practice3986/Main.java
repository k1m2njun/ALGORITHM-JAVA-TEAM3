package seonghyeon.week03.practice3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int cnt = sc.nextInt();

		sc.nextLine();

		for (int i = 0; i < cnt; i++) {
			String str = sc.nextLine();

			if (str.length() % 2 == 1) continue;

			Stack<Character> stack = new Stack<>();

			stack.push(str.charAt(0));

			for (int j = 1; j < str.length(); j++) {

				if (stack.size() > 0 && stack.peek() == str.charAt(j)) {
					stack.pop();
					continue;
				}

				stack.push(str.charAt(j));
			}
			if (stack.isEmpty()) answer++;
		}

		System.out.println(answer);
	}
}
