package Day03;

import java.util.Scanner;
import java.util.Stack;

public class GoodWord {
    public static void main(String[] args) {
        int num, count=0;
        String str;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        for(int i=0; i<num; i++){
            Stack<Character> stack = new Stack<>();
            str = scanner.next();
            if(str.length() % 2 != 0){ //길이가 짝수가 아니라면 이미 좋은 단어가 아님
                continue;
            }
            for(int j=0; j<str.length(); j++){
                if(!stack.isEmpty() && stack.peek() == str.charAt(j)){ //stack이 비어있지않고 가장 위의 값과 현재들어오는 값이 같으면 pop
                    stack.pop();
                }
                else { //다르면 stack에 푸쉬
                    stack.push(str.charAt(j));
                }
            }
            if(stack.isEmpty()){ //스택이 비어있으면 좋은단어
                count++;
            }
        }
        System.out.println(count);

    }
}
