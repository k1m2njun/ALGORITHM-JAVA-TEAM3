package Day04;

public class RowsColumns {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int min = 10000;
        int num=1;
        int temp;

        int[][] queries = { {1, 1, 2, 2}, {1, 2, 2, 3}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        int[][] total = new int[rows+1][columns+1];
        int[] result = new int[queries.length];

        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                total[i][j] = num;
                num++;
            }
        }
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                System.out.printf("   %d    ", total[i][j]);
            }
            System.out.printf("\n");
        }
        int length = 0;
        while(length < queries.length){
           //가장 위쪽 회전
            temp = total[queries[length][0]][queries[length][3]];
            if(temp < min){
                min = temp;
            }
            for(int i=queries[length][3]; i>queries[length][1]; i--){
                total[queries[length][0]][i] = total[queries[length][0]][i-1];
                if(total[queries[length][0]][i] < min){
                    min = total[queries[length][0]][i];
                }
            }

            //오른쪽 회전
            int temp2 = total[queries[length][2]][queries[length][3]];
            if(temp2 < min){
                min = temp2;
            }
            for(int i=queries[length][2]; i>queries[length][0]; i--){
                total[i][queries[length][3]] = total[i-1][queries[length][3]];
                if(total[i][queries[length][3]]< min){
                    min = total[i][queries[length][3]];
                }
            }
            total[queries[length][0]+1][queries[length][3]] = temp;

            //가장 아랫쪽 회전
            int temp3 = total[queries[length][2]][queries[length][1]];
            if(temp3 < min){
                min = temp3;
            }
            for(int i=queries[length][1]; i<queries[length][3]; i++){
                total[queries[length][2]][i] = total[queries[length][2]][i+1];
                if(total[queries[length][2]][i] < min){
                    min = total[queries[length][2]][i];
                }
            }
            total[queries[length][2]][queries[length][3]-1] = temp2;

            //가장 왼쪽 회전
            for(int i=queries[length][0]; i<queries[length][2]; i++){
                total[i][queries[length][1]] = total[i+1][queries[length][1]];
                if(total[i][queries[length][1]]< min){
                    min = total[i][queries[length][1]];
                }
            }
            total[queries[length][2]-1][queries[length][1]] = temp3;

            //최솟값 결과배열에 저장
            result[length] = min;
            min = 10000; //최솟값 초기화
            length++;
        }

        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                System.out.printf("   %d    ", total[i][j]);
            }
            System.out.printf("\n");
        }

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }


    }
}
