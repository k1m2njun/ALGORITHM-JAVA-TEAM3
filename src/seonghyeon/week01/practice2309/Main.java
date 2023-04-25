package seonghyeon.week01.practice2309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            list.add(sc.nextInt());
            sum += list.get(i);
        }

        sc.close();

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - list.get(i) - list.get(j) == 100) {
                    list.remove(j);
                    list.remove(i);

                    Collections.sort(list);

                    for (int answer : list) {
                        System.out.println(answer);
                    }

                    return;
                }
            }
        }
    }
}
