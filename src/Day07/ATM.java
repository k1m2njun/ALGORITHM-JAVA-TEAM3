package Day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> time = new ArrayList<>();
        for(int i=0; i<n; i++){
            time.add(scanner.nextInt());
        }
        Collections.sort(time, Comparator.naturalOrder()); //오름차순으로 정렬
        int total = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                total += time.get(j);
            }
            //System.out.println(total);
        }
        System.out.println(total);
    }
}
