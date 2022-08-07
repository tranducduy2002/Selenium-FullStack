package JavaBasic;

import java.util.Scanner;

import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		int number = scanner.nextInt();
				
		if (number % 2 == 0) {
			System.out.println("Số: " + number + " là số chẵn");
		} else {
			System.out.println("Số: " + number + " là số lẻ");

		}
	}
	
	//@Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA > numberB) {
			System.out.println("Number A is greater than Number B");
		} else if (numberA < numberB){
			System.out.println("Number A is smaller than Number B");
		} else {
			System.out.println("Number A is equal to Number B");
		}
	}
	
	// @Test
	public void TC_03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		if (firstStudent.equals(secondStudent)) {
			System.out.println("They are same name");
		} else {
			System.out.println("They are different names");

		}
	}
	
	//@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC) {
			System.out.println("Số lớn nhất là:" + numberA);
		} else if (numberB > numberA && numberB > numberC) {
			System.out.println("Số lớn nhất là:" + numberB);
		} else {
			System.out.println("Số lớn nhất là:" + numberC);

		}

	}
	
	//@Test
	public void TC_05() {
		int numberA = scanner.nextInt();
		if (numberA > 10 && numberA < 100) {
			System.out.println(numberA + "nằm trong khoảng 10 đến 100");
		} else {
			System.out.println(numberA + "không nằm trong khoảng 10 đến 100");

		}
		
	}
	
	//@Test
	public void TC_06() {
		float numberA = scanner.nextFloat();
		if (numberA >= 0 && numberA <= 5) {
			System.out.println("Loại D");
		} else if (numberA > 5 && numberA <= 7.5) {
			System.out.println("Loại C");
		} else if (numberA > 7.5 && numberA <= 8.5) {
			System.out.println("Loại B");
		} else {
			System.out.println("Loại A");

		}

		
	}
	
	@Test
	public void TC_07() {
		int numberOfMonth = scanner.nextInt();
		if (numberOfMonth == 1 | numberOfMonth == 3 | numberOfMonth == 5 | numberOfMonth == 7 | numberOfMonth == 8 | numberOfMonth == 10 | numberOfMonth == 12) {
			System.out.println("Tháng " + numberOfMonth + " có 31 ngày");
		} else if (numberOfMonth == 4 | numberOfMonth == 6 | numberOfMonth == 9 | numberOfMonth == 11) {
			System.out.println("Tháng " + numberOfMonth + " có 30 ngày");
		} else {
			System.out.println("Tháng " + numberOfMonth + " có 28 ngày");

		}
	}
	
}
