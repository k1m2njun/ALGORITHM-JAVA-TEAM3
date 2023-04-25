package seonghyeon.week01.practice2979;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pay1 = sc.nextInt();
        int pay2 = sc.nextInt();
        int pay3 = sc.nextInt();

        int start = 0;
        int end = 0;
        int max = 0;
        int min = 0;
        int sum = 0;

        int[] arr = new int[100];

        for (int i = 0; i < 3; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            min = start < min ? start : min;
            max = end > max ? end : max;

            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        for (int i = min; i < max; i++) {
            switch (arr[i]) {
                case 1:
                    sum += pay1 * arr[i];
                    break;

                case 2:
                    sum += pay2 * arr[i];
                    break;

                case 3:
                    sum += pay3 * arr[i];
                    break;
            }
        }

        System.out.println(sum);
    }
}
