package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1621_repair {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
		
        HashMap<Integer, String> pokemons = new HashMap<>();
		for(int i = 0; i < N; i++) {
			pokemons.put(i+1, br.readLine());
		}
		
		String[] Q = new String[M];
		for(int i = 0; i < M; i++) {
			Q[i] = br.readLine();
		}
		
		for(String q : Q) {
			if(Character.isDigit(q.charAt(0))) {
				System.out.println(pokemons.get(Integer.parseInt(q)));
			} else {
				System.out.println(getKey(pokemons, q));
			}
		}
	}
	
	public static <K, V> K getKey(HashMap<K, V> map, V value) {
		 
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}

// https://www.acmicpc.net/problem/1620