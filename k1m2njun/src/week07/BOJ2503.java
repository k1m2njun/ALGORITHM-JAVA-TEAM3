package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2503 {
	
	static int N;
	static List<BaseBallData> inputData = new ArrayList<>();
	static int MIN_NUMBER = 123;
	static int MAX_NUMBER = 987;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sc = br.readLine();
		
		N = Integer.parseInt(sc);
		
		// 입력 데이터 수집
		for(int i = 0; i < N; i++) {
			sc = br.readLine();
			StringTokenizer st = new StringTokenizer(sc, " ");
			
            inputData.add(
            		new BaseBallData(
            			st.nextToken(), 
            			Integer.parseInt(st.nextToken()),
            			Integer.parseInt(st.nextToken())));
		}
		
		System.out.println(calBaseBall());
		
	}
	
	static int calBaseBall() {
        int result = 0;

        // 범위 내 모든 수에 베이스볼 게임을 진행.
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (!checkNum(i)) continue; // 중복수 및 0 체크해서 제외

            int allTestPass = 0;
            // 328
            for (int j = 0; j < N; j++) {
                int strikeCount = 0; // 1, 1, 2, 0
                int ballCount = 0;   // 1, 0, 0, 1

                BaseBallData current = inputData.get(j);
                String currentDataString = current.data; // 민혁이가 영수에게 물은 수
                String myDataString = Integer.toString(i);

                // 숫자 야구 게임 룰.
                // String 3개 수를 비교, 만약 i 로 들어온 수가 답이라면 입력받은 s, b의 개수와 동일하게 측정될 것.
                for (int k = 0; k < 3; k++) {
                	if (currentDataString.charAt(k) == myDataString.charAt(k)) { // strike
                        strikeCount++;
                        continue;
                    }
                    for (int u = 0; u < 3; u++) { // ball
                        if (myDataString.charAt(k) == currentDataString.charAt(u)) { // 수는 같은데
                            if (k != u) ballCount++; // 위치가 같지 않은 경우 ball 체크
                        }
                    }
                }
                // strike와 ball의 개수가 입력받은 것과 같으면 카운트 최대 N개
                if (current.strike == strikeCount && current.ball == ballCount) allTestPass++;
            }
            // 어떠한 수에 대해 위의 카운트와 N이 일치하면 카운트 == 베이스볼 게임의 정답으로 예측되는 수임
            if (allTestPass == N) result++;
        }
        return result;
    }
	
	// 중복수 및 0 체크, 없으면 true
	static boolean checkNum(int num) {

        String numString = Integer.toString(num);

        if ((numString.charAt(0) == numString.charAt(1)) ||
            (numString.charAt(1) == numString.charAt(2)) ||
            (numString.charAt(0) == numString.charAt(2))) return false;

        if (numString.charAt(0) == '0' ||
        	numString.charAt(1) == '0' ||
        	numString.charAt(2) == '0') return false;

        return true;
    }
	
	static class BaseBallData {
        String data;
        int strike;
        int ball;

        public BaseBallData(String data, int strike, int ball) {
            this.data = data;
            this.strike = strike;
            this.ball = ball;
        }
    }

}

//https://www.acmicpc.net/problem/2503