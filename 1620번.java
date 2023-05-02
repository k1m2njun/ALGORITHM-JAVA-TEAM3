// HashMap 생성 후 str -> int int -> str
// HashMap 공부 : https://coding-factory.tistory.com/556

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> hash = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            hash.put(Integer.toString(i), str);
            hash.put(str, Integer.toString(i));
        }

        for (int i = 0; i < m; i++) {
            sb.append(hash.get(br.readLine())+"\n");
        }

        System.out.println(sb);
    }
}
