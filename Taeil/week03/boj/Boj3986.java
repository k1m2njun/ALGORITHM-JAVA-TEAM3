package week03.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj3986  {
    public static void main(String[] args) throws IOException {
        // stack 유형
        // 하나씩 꺼내면서 처음 꺼냈던 것과 같으면 count
        Stack<Character> stack = new Stack<Character>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            // stack에 담기
            for (int j = 0; j < str.length(); j++) {
                // 빈 stack이 아니고, j번째 값이 stack.peek() - top()하고 같은 경우
                // pop()
                char idxStr =  str.charAt(j);
                if (!stack.isEmpty() && stack.peek().equals(idxStr)) {
                    stack.pop();
                }
                // push
                else {
                    stack.push(str.charAt(j));
                }
            }
            if (stack.isEmpty()) count++;
            stack.clear();
        }

        System.out.println(count);
        br.close();
    }
}
