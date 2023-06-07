package Day05;

import java.util.*;

public class Parking {
    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        HashMap<String, String> car = new HashMap<String, String>(); //출차되지않고 입차된 차들을 저장
        HashMap<String, Integer> carTime = new HashMap<String, Integer>(); // 출차된차들의 누적시간 계산

        for(int i=0; i< records.length; i++){
            String[] temp = records[i].split(" ");
            if(car.containsKey(temp[1])){ //car에 이미 입차된 차가 있다면 출차하는 차이므로 시간을 구해서 carTime에 put
                String[] time1 = car.get(temp[1]).split(":");
                String[] time2 = temp[0].split(":");
                int totalTime;
                if(Integer.parseInt(time2[0])-Integer.parseInt(time1[0]) > 0){ //출차시간과 입차시간의 차가 0보다 클때
                    totalTime = ((Integer.parseInt(time2[0])-Integer.parseInt(time1[0])-1) * 60) + ((60 - Integer.parseInt(time1[1])) + Integer.parseInt(time2[1]));
                }
                else{ //출차시간과 입차시간의 차가 0과 같으면 분만 뺌
                    totalTime = Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
                }
                if(carTime.containsKey(temp[1])){ //이미 한번 입출차가 됐던 차라면 원래 시간에 더해줌
                    carTime.put(temp[1], carTime.get(temp[1])+totalTime);
                }
                else{ //아니라면 구한시간만 put
                    carTime.put(temp[1], totalTime);
                }
                car.remove(temp[1]); //출차가 완료됐으므로 남은 car에서 지워줌
            }
            else{
                car.put(temp[1], temp[0]); // 처음 들어온 차라면 put
            }
        }

        if(!car.isEmpty()){ //car가 비워있지않다면 출차되지않은 차들이 남아있는것
            for(String key : car.keySet()){
                String[] temp = car.get(key).split(":");
                int tempTime = (23 - Integer.parseInt(temp[0]))*60 + (59 - Integer.parseInt(temp[1])); //23시59분에서 뺀 시간을 계산
                if(carTime.containsKey(key)){ //carTime에 이미 있는 key라면 원래있던 시간에 더해줌
                    carTime.put(key, carTime.get(key)+tempTime);
                }
                else{ //아니라면 구한 시간만 put
                    carTime.put(key, tempTime);
                }
            }
        }
        System.out.println(carTime);

        List<String> keyset = new ArrayList<>(carTime.keySet());
        Collections.sort(keyset); //자동차번호대로 sort
        int[] answer = new int[keyset.size()]; //정답 배열 생성
        int i=0;
        for(String key : keyset){
            if(carTime.get(key) <= fees[0]){ //기본 시간보다 적거나 같다면
                answer[i] = fees[1]; //기본요금
            }
            else{
                answer[i] = fees[1] + (int)((Math.ceil((double) (carTime.get(key) - fees[0])/fees[2])) * fees[3]);
            }
            i++;
        }
        for(i=0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
    }

}
