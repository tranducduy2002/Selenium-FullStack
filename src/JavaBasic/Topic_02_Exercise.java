package JavaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {

	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;
		
		float chieudai = 7.5f;
		float chieurong = 3.8f;
		
		System.out.println("Tong =" + (a + b));
		System.out.println("Hieu =" + (a - b));
		System.out.println("Tich =" + (a * b));
		System.out.println("Thuong =" + (a / b));

		System.out.println("Dien tich =" + (chieudai * chieurong));
		
		String chuoi = "Look Up";
		
		System.out.println("Ket qua: " + chuoi);

		
		
		
	}
}
