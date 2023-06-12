package Day07;

import java.util.Scanner;

public class NumberBaseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        int[][] numInfo = new int[n][2];

        for(int i=0; i<n; i++){
            num[i] = scanner.nextInt();
            numInfo[i][0] = scanner.nextInt();
            numInfo[i][1] = scanner.nextInt();
        }

        int tmp = 123;
        int count=0;
        while(tmp++ <= 987){
            int hundreds = tmp / 100;
            int tens = tmp / 10 % 10;
            int units = tmp % 10;
            if(hundreds == tens || hundreds == units || tens == units) continue; //각 자리 숫자중 서로 같은것이 있으면 continue
            if(tens ==0 || units == 0) continue; // 0이 들어가있다면 continue

            int flag = 1;
            for(int i=0; i<n; i++){
                int strike = 0;
                int ball = 0;

                int hundredsNum = num[i] / 100;
                int tensNum = num[i] / 10 % 10;
                int unitsNum = num[i] % 10;

                //각 자리와 숫자가 일치하면 strike
                if(hundreds == hundredsNum) strike++;
                if(tens == tensNum) strike++;
                if(units == unitsNum) strike++;

                //숫자만 일치하면 ball
                if(hundredsNum == tens || hundredsNum == units) ball++;
                if(tensNum == hundreds || tensNum == units) ball++;
                if(unitsNum == hundreds || unitsNum == tens) ball++;

                //민혁이의 정보와 일치하지 않다면 flag=0 이고 break
                if(strike != numInfo[i][0] || ball != numInfo[i][1]){
                    flag=0;
                    break;
                }
            }
            if(flag == 1){
                count++;
            }
        }
        System.out.println(count);
    }
}
