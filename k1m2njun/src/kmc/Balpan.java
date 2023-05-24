package kmc;

import java.util.Arrays;
import java.util.Collections;

public class Balpan {

	public static void main(String[] args) {

		int h = 12;
		int k = 3;
		int[] boxes = {2, 3, 6, 7, 8, 10, 11};
		
		Integer[] boxesInt = Arrays.stream(boxes).boxed().toArray(Integer[]::new);
		
		Arrays.sort(boxesInt, Collections.reverseOrder());
		
		int steps = 0;
		int height = 0;
		int end = 0;
		
		while(end <= h) {
			for (int i = 0; i < boxesInt.length; i++) {
				if(boxesInt[i] <= k + height) {
					height = boxesInt[i];
					end = height + k;
					steps++;
					break;
				}
			}
		}
		
		System.out.println(steps);
	}
}
