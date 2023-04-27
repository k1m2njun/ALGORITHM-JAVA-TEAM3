package week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ2979 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 주차요금
        int A = scanner.nextInt();
        int B = scanner.nextInt() * 2;
        int C = scanner.nextInt() * 3;

        int threeCars = 0;
        int twoCars = 0;
        int aCar = 0;

        int count3 = 0;
        int count2 = 0;
        int count1 = 0;

        List<int[]> cars = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            int startMinute = scanner.nextInt();
            int endMinute = scanner.nextInt();

            int[] zero = new int[100];
			Arrays.fill(zero, 0);

            cars.add(fillOneArray(zero, startMinute, endMinute));
        }
        scanner.close();

        for(int i = 0; i < 100; i++) {
            if(cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] != 0) {
                if(cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] == 3) {
                    threeCars++;
                    count3 ++;
                } else if ((cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] != 3) && (cars.get(0)[i-1] + cars.get(1)[i-1] + cars.get(2)[i-1] == 3)) {
                    if(count3 > 1) { threeCars--; }
                    count3 = 0;
                }

                if(cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] == 2) {
                    twoCars++;
                    count2 ++;
                } else if ((cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] != 2) && (cars.get(0)[i-1] + cars.get(1)[i-1] + cars.get(2)[i-1] == 2)) {
                    if(count2 > 1) { threeCars--; }
                    count2 = 0;
                }

                if(cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] == 1) {
                    aCar++;
                    count1 ++;
                } else if ((cars.get(0)[i] + cars.get(1)[i] + cars.get(2)[i] != 1) && (cars.get(0)[i-1] + cars.get(1)[i-1] + cars.get(2)[i-1] == 1)) {
                    if(count1 > 1) { threeCars--; }
                    count1 = 0;
                }
            }
        }

        System.out.println(A + " " + aCar + " " + B + " " + twoCars + " " + C + " " + threeCars);

        int total = (A * aCar) + (B * twoCars) + (C * threeCars);

        System.out.println(total);

    }

    public static int[] fillOneArray(int[] arr, int start, int end) {

        for(int i = start; i < end + 1; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}