package week02;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1620 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); 
		int M = scanner.nextInt(); 
		
		ArrayList<String> pokemons = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			pokemons.add(scanner.next());
		}
		
		String[] Q = new String[M];
		for(int i = 0; i < M; i++) {
			Q[i] = scanner.next();
		}
		scanner.close();
		
		for(String q : Q) {
			if(q.charAt(0) >= 48 && q.charAt(0) <= 57) {
				System.out.println(pokemons.get(Integer.parseInt(q)-1));
			} else {
				System.out.println(pokemons.indexOf(q)+1);
			}
		}
	}
}

// https://www.acmicpc.net/problem/1620
// 시간초과