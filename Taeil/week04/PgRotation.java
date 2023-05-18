package week04;

import java.util.Arrays;

public class PgRotation {
    // 이차원 배열 구현
    // queue 활용 가능 할듯
    static int[][] matrix;
    static int minNum;
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        System.out.println(solution(rows, columns, queries));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = initMatrix(rows, columns);
        int queryIdx = 0;

        for (int[] q : queries) {
            rotation(q[0] - 1, q[1] - 1, q[2] - 1, q[3] - 1);
            answer[queryIdx] = minNum;
            queryIdx++;
            System.out.println(Arrays.deepToString(matrix));
        }

        return answer;
    }

    public static int[][] initMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int num = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = num++;
            }
        }

        return matrix;
    }

    static void rotation(int x1, int y1, int x2, int y2) {
        int saveNum = matrix[x1][y1];
        minNum = saveNum;

        // 왼쪽 : 위로 올리기
        for (int i = x1 + 1; i <= x2; i++) {
            matrix[i - 1][y1] = matrix[i][y1];
            // Math.min 내부 로직
            minNum = (matrix[i][y1] <= minNum) ? matrix[i][y1] : minNum ; // 시간 복잡도 측면에서 크게 상관 없을 듯

        }

        // 아래 : 왼쪽으로 이동
        for(int i = y1 + 1; i <= y2; i++) {
            matrix[x2][i - 1] = matrix[x2][i];
            minNum = Math.min(matrix[x2][i], minNum);
        }

        // 오른쪽 : 아래로 이동
        for (int i = x2 - 1; i >= x1; i--) {
            matrix[i + 1][y2] = matrix[i][y2];
            minNum = Math.min(matrix[i][y2], minNum);
        }

        // 위쪽 : 오른쪽으로 이동
        for (int i = y2 - 1; i >= y1; i--) {
            matrix[x1][i + 1] = matrix[x1][i];
            minNum = Math.min(matrix[x1][i], minNum);
        }

        matrix[x1][y1 + 1] = saveNum;
    }
}
