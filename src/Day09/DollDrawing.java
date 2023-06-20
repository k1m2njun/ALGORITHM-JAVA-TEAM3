package Day09;

import java.util.Stack;

public class DollDrawing {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int result = 0;

        Stack<Integer> basket = new Stack<>();

        for(int i=0; i< moves.length; i++){
            for(int j=0; j<board.length; j++){
                //0이면 인형이 없으므로 continue
                if(board[j][moves[i]-1] == 0){
                    continue;
                }
                else{
                    //stack이 비어있으면 push 하고 board는 0으로 세팅후 break
                    if(basket.empty()){
                        basket.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                    else {
                        //stack이 안비어있으면 stack의 최상위값과 비교후 같으면 board는 0으로 세팅후 pop, reault값 더해주고 break
                        //최상위값과 다르면 push후 0으로 세팅 break
                        if(basket.peek() == board[j][moves[i]-1]){
                            board[j][moves[i]-1] = 0;
                            basket.pop();
                            result+=2;
                            break;
                        }
                        else{
                            basket.push(board[j][moves[i]-1]);
                            board[j][moves[i]-1] = 0;
                            break;
                        }
                    }

                }
            }
        }
        System.out.println(result);
    }
}
