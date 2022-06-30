package JavaBasic;

import org.testng.annotations.Test;

public class Topic_04_Exercise {
	
	int smallNumber, bigNumber;
	
	@Test
	public void swapNumber() {
		int a = 3;
		int b = 4;
		
		a +=b;
		b = a - b; 
		a -=b;
		
		System.out.println(a);
		System.out.println(b);
		
		int years = 10;
		
		System.out.println("After 15 years: " + (years + 15));
		
		smallNumber = 5;
		bigNumber = 5;
				
		if (smallNumber <= bigNumber) {
			System.out.println("true");
						
		} else {
			System.out.println("false");
		}
		
	}

}
