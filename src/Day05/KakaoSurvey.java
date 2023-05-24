package Day05;

import java.util.HashMap;

public class KakaoSurvey {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String answer = "";
        //hashmap 초기화
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        //점수계산에서 map에 저장
        for(int i=0; i<choices.length; i++){
            String[] temp = survey[i].split(""); //split해서 하나씩 저장
            if(choices[i] == 4){
                continue;
            } else if (choices[i] > 4) {
                map.put(temp[1], map.get(temp[1])+choices[i]%4);
            } else if (choices[i] == 1){
                map.put(temp[0], map.get(temp[0])+3);
            } else if (choices[i] == 2){
                map.put(temp[0], map.get(temp[0])+2);
            } else{
                map.put(temp[0], map.get(temp[0])+1);
            }
        }

        if(map.get("R") >= map.get("T")){
            answer += "R";
        } else {
            answer += "T";
        }
        if(map.get("C") >= map.get("F")){
            answer += "C";
        } else {
            answer += "F";
        }
        if(map.get("J") >= map.get("M")){
            answer += "J";
        } else {
            answer += "M";
        }
        if(map.get("A") >= map.get("N")){
            answer += "A";
        } else {
            answer += "N";
        }

        System.out.println(answer);

    }
}
