package Day08;

public class Post {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        long result = 0;

        int deliver = 0;
        int pickup = 0;
        for(int i=n-1; i>=0; i--){
            if(deliveries[i] > 0 || pickups[i] > 0){ //배달이나 픽업할게 한개라도 있다면 방문
                int count = 0; //count초기화
                while(deliver < deliveries[i] || pickup < pickups[i]){
                    //i번째 집에 몇번 방문하는지 카운트
                    count++;
                    deliver += cap;
                    pickup += cap;
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                result += (i+1) * count *2;
            }
        }
        System.out.print(result);
    }
}
