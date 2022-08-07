package JavaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_08_For_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	//@Test
	public void TC_01_Print_to_n() {
		int number = scanner.nextInt();
		
		for (int i = 1; i <= number; i++) {
			System.out.println(i + " ");
		}
		
	}
	
	//@Test
	public void TC_02_Print_From_A_To_B () {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		for (int i = numberA; i <= numberB; i++) {
			System.out.println(i);
		}
	}
	
	@Test
	public void TC_03_Sum_of_Even_Number () {
		List<Integer> evenNumber = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			if (i%2 == 0) {
				evenNumber.add(i);
			}
		}
		int sum = evenNumber.stream().mapToInt(Integer::intValue).sum();
				
		System.out.println(sum);		
	}
}
