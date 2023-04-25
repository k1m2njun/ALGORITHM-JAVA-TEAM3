package week01.boj;

import java.io.*;
import java.util.*;


public class Boj2309 {
    static List<Integer> arr = new ArrayList<>();
    static int sum = 0;
    static int faker1 = 0;
    static int faker2 = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // arr data setting
        for (int i = 0; i < 9; i++) {
            arr.add(Integer.parseInt(bf.readLine()));
            sum += arr.get(i);
            // String s = bf.readLine(); //String
            // int i = Integer.parseInt(bf.readLine()); //Int
            // throws IOException 필요 readLine 때문
        }

        Collections.sort(arr); // 오름차순 : [7, 8, 10, 13, 15, 19, 20, 23, 25]

        // 브루트 포스
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr.get(i) - arr.get(j) == 100) {
                    faker1 = arr.get(i);
                    faker2 = arr.get(j);
                    break;
                }

            }
        }

        for (int el : arr) {
            if (!(el == faker1 || el == faker2)) {
                System.out.println(el);
            }
        }

    }
}