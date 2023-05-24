package kmc;

public class Programmers42577 {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		for(int i = 0; i < phone_book.length - 1; i++) {
			for(int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[i] == phone_book[j].substring(0, phone_book[i].length())) {
					System.out.println("false");
					return;
				}
			}
			
		}
		System.out.println("true");
	}
}
