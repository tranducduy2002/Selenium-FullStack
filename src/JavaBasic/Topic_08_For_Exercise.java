package JavaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	
	//@Test
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
	
	//@Test
	public void TC_04_Sum_of_All_Numbers () {
		int numberC = scanner.nextInt();
		int numberD = scanner.nextInt();
		
		List<Integer> sumAllNumbers = new ArrayList<Integer>();
		for (int i = numberC; i <= numberD; i++) {
				sumAllNumbers.add(i);
		}
		int sum = sumAllNumbers.stream().mapToInt(Integer::intValue).sum();
				
		System.out.println(sum);		
	}
	
	//@Test
	public void TC_05_Sum_of_Odd_Numbers () {
		int numberE = scanner.nextInt();
		
		List<Integer> sumOddNumbers = new ArrayList<Integer>();
		for (int i = 0; i <= numberE; i++) {
			if (i%2 != 0) {
				sumOddNumbers.add(i);
			}
		}
		int sum = sumOddNumbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);		

	}
	

	//@Test
	public void TC_06_List_Of_Numbers_Devided_Three () {
		int numberF = scanner.nextInt();
		int numberG = scanner.nextInt();
		
		List<Integer> devidedToThree = new ArrayList<Integer>();
		for (int i = numberF; i <= numberG; i++) {
			if (i%3 == 0) {
				devidedToThree.add(i);
			}
		}
		System.out.println(devidedToThree);		

	}
	
	@Test
	public void TC_7_Multiplication () {
		int numberH = scanner.nextInt();
		long factorial = 1;
		for (int i = 2; i <= numberH; i++) {
			factorial *= i;
			
			} 

		
		System.out.println(factorial);		
	}
	
	

	
}
