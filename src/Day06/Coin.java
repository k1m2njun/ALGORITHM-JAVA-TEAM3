package Day06;

import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        int n, money;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        money = scanner.nextInt();

        int total = 0;
        int[] coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = scanner.nextInt();
        }

        for(int i=n-1; i>=0; i--){
            if(money < coin[i]){ //coin보다 작으면 continue
                continue;
            }
            else {
                total += money / coin[i]; //몫 더해주기
                money = money % coin[i]; // 나머지는 남은 돈
            }
            if(money == 0){
                break;
            }
        }
        System.out.println(total);
    }
}
