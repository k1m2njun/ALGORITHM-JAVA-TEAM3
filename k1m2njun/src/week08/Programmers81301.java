package week08;

public class Programmers81301 {
	
	public static void main(String[] args) {
		String s = "one4seveneight";
		
		System.out.println(solution(s));
		
	}

	public static int solution(String s) {
        int answer = 0;
        
        s = s.replace("one", "1").replace("two", "2")
        		.replace("three", "3").replace("four", "4")
        		.replace("five", "5").replace("six", "6")
        		.replace("seven", "7").replace("eight", "9")
        		.replace("nine", "9").replace("zero", "0");
        
        answer = Integer.parseInt(s);
        
        return answer;
    }

}

//https://school.programmers.co.kr/learn/courses/30/lessons/81301