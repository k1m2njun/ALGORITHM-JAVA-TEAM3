package seonghyeon.week08.one2three;

public class Main {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}

	public static int solution(String s) {
		if (isInteger(s))
			return Integer.parseInt(s);

		String[] arr = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		String answer = s;
		for (int j = 0; j < arr.length; j++) {
			answer = answer.replace(arr[j], Integer.toString(j));
		}

		return Integer.parseInt(answer);
	}

	public static boolean isInteger(String s) {
		boolean flag = true;

		try {
			int i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			flag = false;
		}

		return flag;
	}
}
