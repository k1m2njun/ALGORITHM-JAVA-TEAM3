package Day02;

import java.util.Scanner;

public class PocketMonster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M; //포켓몬 개수, 문제 개수
        N = scanner.nextInt();
        M = scanner.nextInt();
        int flag=0; //이름으로 찾았는지 확인해주는 변수

        String[] pocketmon = new String[N];
        for(int i=0; i<N; i++){
            pocketmon[i] = scanner.next();
        }
        String[] problem= new String[M];
        for(int i=0; i<M; i++){
            problem[i] = scanner.next();
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                //이름으로 찾았다면 flag에 표시후 위치 반환
                if(problem[i].equals(pocketmon[j])){
                    System.out.println(j+1);
                    flag = 1;
                    break;
                }
            }
            //이름으로 못찾았다면 String을 int타입으로 변환후 비교
            if(flag != 1){
                for(int j=1; j<=N; j++){
                    if(Integer.parseInt(problem[i]) == j){
                        System.out.println(pocketmon[j-1]);
                        flag = 1;
                        break;
                    }
                }
            }
            //아니라면 flag초기화
            else{
                flag = 0;
            }
        }
    }
}
