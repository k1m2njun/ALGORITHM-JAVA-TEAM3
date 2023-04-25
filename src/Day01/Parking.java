package Day01;

import java.util.Arrays;
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B, C;
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        int firstS, firstE;
        int secondS, secondE;
        int thirdS, thirdE;
        int total = 0;

        firstS = scanner.nextInt();
        firstE = scanner.nextInt();
        secondS = scanner.nextInt();
        secondE = scanner.nextInt();
        thirdS = scanner.nextInt();
        thirdE = scanner.nextInt();

        int max = 0;
        if(max < firstE){
            max = firstE;
        }
        if(max < secondE){
            max = secondE;
        }
        if(max < thirdE){
            max = thirdE;
        }

        int[] time = new int[max];
        Arrays.fill(time, 0); //0으로 초기화

        //각 시간을 배열에 체크
        for(int i=firstS; i<firstE; i++){
            time[i]++;
        }
        for(int i=secondS; i<secondE; i++){
            time[i]++;
        }
        for(int i=thirdS; i<thirdE; i++){
            time[i]++;
        }

        // 1일땐 차가 한대, 2일땐 차가 두대, 3일땐 차가 3대인것
        for(int i=0; i<time.length; i++){
            if(time[i]==1){
                total += time[i] * A;
            }
            else if(time[i]==2){
                total += time[i] * B;
            }
            else if(time[i]==3){
                total += time[i] * C;
            }
            else{
                continue;
            }
        }
        System.out.println(total);
    }
}
