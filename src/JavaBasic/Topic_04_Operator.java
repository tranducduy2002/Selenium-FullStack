package JavaBasic;

import java.util.Iterator;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 10;
		
		number +=5;
		
		number = number + 5;
		System.out.println(number);
		
		// 15 /5 = 3
		System.out.println(number / 5);
		
		// 15%6 = 2 dư 3 (chia lấy dư)
		System.out.println(number %= 6);
		// In number trước sau đó ++ => tăng number lên 1 => kết quả là number ban đầu
		System.out.println(number++);
		
		// Tăng number lên trước sau đó in giá trị => 12
		System.out.println(++number);
		
		for (int i = 0; i < 3; ++i) {
			System.out.println(i);
		}
		
		String address = "Ho Chi Minh";
		if (address != "Ha Noi") {
			System.out.println("Address is not the same");
		}
		
		if (address != "Ha Noi" || address == "Da Nang") {
			System.out.println("Address is not the same");
		}
		
		if (address != "Ha Noi" && address == "Da Nang") {
			System.out.println("Address is not the same");
		}
		
		if (!(address == "Ha Noi")) {
			System.out.println("Address is not the same");
		}
		
		boolean status = (address == "Ha Noi") ? true : false;
		System.out.println(status);
		
	}
}
