package Day06;

import java.util.Scanner;

public class Bracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.next().split("-");

        int sum = Integer.MAX_VALUE; // 초기값 확인용

        for(int i=0; i<str.length; i++){
            int temp = 0;

            //덧세므로 분리하여 해당 숫자는 더해줌
            String[] add = str[i].split("\\+");

            for(int j=0; j<add.length; j++){
                temp += Integer.parseInt(add[j]);
            }

            //sum 값이 그대로인 경우
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
