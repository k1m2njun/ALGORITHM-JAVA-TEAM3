package Day02;

import java.util.HashMap;
import java.util.Scanner;

public class PocketMonsterVer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M; //포켓몬 개수, 문제 개수
        N = scanner.nextInt();
        M = scanner.nextInt();
        HashMap<String, Integer> pocketmonster = new HashMap<String, Integer>(); //문자로 받았을때
        String[] pocketmon = new String[N+1]; //숫자로 받았을때

        for(int i=1; i<=N; i++){
            String tmp = scanner.next();
            pocketmonster.put(tmp, i);
            pocketmon[i] = tmp;
        }
        for(int i=0; i<M; i++){
            String tmp = scanner.next();
            if(pocketmonster.containsKey(tmp)){ //문자로 받았을때 key값을 찾아 value를 출력
                System.out.println(pocketmonster.get(tmp));
            }
            else{
                System.out.println(pocketmon[Integer.parseInt(tmp)]); //숫자로 받았을때 String을 int로 변환하여 출력
            }
        }
    }
}
