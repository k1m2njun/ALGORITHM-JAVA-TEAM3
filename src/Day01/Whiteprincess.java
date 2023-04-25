package Day01;

import java.util.*;

public class Whiteprincess {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = 9;
        int total = 0;
        List<Integer> dwaf = new ArrayList<Integer>();
        int gap = 0;
        int no1=0;
        int no2=0;
        //9명의 난쟁이의 키를 저장하고 총 합을 구함
        for(int i=0; i<num; i++){
            dwaf.add(scanner.nextInt());
            total += dwaf.get(i);
        }
        gap = total - 100; //총 합에서 100을 뺀 차이를 구함
        //System.out.println("이것은차이: " + gap);

        // 두명의 키의 합이 gap과 같다면 짝퉁 난쟁이 찾으면 바로 for문을 빠져나감
        for(int i=0; i<num; i++){
            for(int j=i+1; j<num; j++){
                if((dwaf.get(i) + dwaf.get(j)) == gap){
                    //System.out.println("이것은 i 랑 j: " + dwaf.get(i) + dwaf.get(j));
                    no1 = dwaf.get(i);
                    no2 = dwaf.get(j);
                    dwaf.remove(Integer.valueOf(no1));
                    dwaf.remove(Integer.valueOf(no2));
                    break;
                }
            }
            if(no1 != 0 && no2 != 0){
                break;
            }
        }
        Collections.sort(dwaf); //오름차순으로 정렬
        for(int i=0; i<7; i++){
            System.out.println(dwaf.get(i));
        }
    }
}
