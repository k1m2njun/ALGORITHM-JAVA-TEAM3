package Day03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fashion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int test = Integer.parseInt(scanner.next());

        while(test > 0){
            int n = Integer.parseInt(scanner.next());
            Map<String, Integer> fashion = new HashMap<>();
            int result = 1;
            while(n > 0) {
                scanner.next(); //이름은 필요없음
                String key = scanner.next();
                if(fashion.containsKey(key)){
                    fashion.put(key, fashion.get(key)+1);
                }
                else {
                    fashion.put(key, 1);
                }
                n--;
            }
            for(int i : fashion.values()){
                result *= (i+1); //안입는경우 1을 더해 곱해야함
            } 
            System.out.println(result-1); //아예 아무것도 안입는경우 1빼고 리턴
            test--;
        }
    }
}
