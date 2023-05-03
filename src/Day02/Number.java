package Day02;

import java.util.Scanner;

//2559번 : 수열
public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num, day;
        int max = Integer.MIN_VALUE; //이렇게 안하면 틀림..
        int tmp=0;
        int count=1;
        num = scanner.nextInt();
        day = scanner.nextInt();
        int[] temperature = new int[num];

        for(int i=0; i<num; i++){
            temperature[i] = scanner.nextInt();
        }

        for(int i=0; i<num; i++){
            tmp = temperature[i]; //기준이 되는 값 먼저 저장

            if((i+day) > num){ //Array의 값을 초과하는걸 방지하기 위해 체크
                break;
            }
            for(int j=i+1; j<i+day; j++){
                 tmp += temperature[j];
                 count++;
            }
            //System.out.println("count: " + count);
            if(count != day){ //count가 day가 아니면 day만큼 더하지 않았다는 뜻 break
                break;
            }
            if(tmp > max){ //최대값이면 값 저장후 초기화
                max = tmp;
                count = 1;
                tmp = 0;
            }
            else{ //아니라면 초기화
                count = 1;
                tmp = 0;
            }
            //System.out.println("tmp: "+ tmp + " max: " +max);
        }

        System.out.println(max);
    }
}
