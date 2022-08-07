package JavaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Topic_07_Condition_Statement_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	public void TC_01(String browserName) {
	switch(browserName) {
	case "chrome":
		 System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 break;
	case "firefox":
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		break;
	case "edge":
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		break;
	case "ie":
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		break;
	default: 
		new RuntimeException("Please input correct the browser name!");
		break;
		}
	}
	//@Parameters("browser")
	//@Test
	public void TC_02_Get_Browser_Short(String browserName) {
		 
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		System.out.println(driver.toString());
	}
	
	//@Test
	public void TC_03_Get_Month() {
		 int month = scanner.nextInt();
		 switch (month) {
		 case 1:
		 case 3:
		 case 5:
		 case 7:
		 case 8:
		 case 10:
		 case 12:
			 System.out.println("Tháng này có 31 ngày");
			 break;
		 case 2:
			 System.out.println("Tháng này có 28 hoặc 29 ngày");
			 break;
		 case 4:
		 case 6:
		 case 9:
		 case 11:
			 System.out.println("Tháng này có 30 ngày");
			 break;	 
			 
		 }
		
	}
	
	//@Test
	public void TC_04_Exercise_One_To_Ten() {
		 int countNumber = scanner.nextInt();
		 switch (countNumber) {
		 case 1:
			 System.out.println("One");
		 	 break;	 
		 case 2:
			 System.out.println("Two");
		 	 break;	 
		 case 3:
			 System.out.println("Three");
		 	 break;	 
		 case 4:
			 System.out.println("Four");
		 	 break;	 
		 case 5:
			 System.out.println("Five");
		 	 break;	 
		 case 6:
			 System.out.println("Six");
		 	 break;	 
		 case 7:
			 System.out.println("Seven");
		 	 break;	 
		 case 8:
			 System.out.println("Eight");
		 	 break;	 
		 case 9:
			 System.out.println("Nine");
		 	 break;	 
		 case 10:
			 System.out.println("Ten");
		 	 break;	 
		 }
	}
	
	@Test
	public void TC_05_Exercise_Calculator() {

		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		String operator = scanner.next();

		 switch (operator) {
		 case "+":
			 System.out.println("Sum : " + (numberA + numberB));
		 	 break;	 
		 case "-":
			 System.out.println("Divide :" + (numberA - numberB));
		 	 break;	 
		 case "x":
			 System.out.println(numberA * numberB);
		 	 break;	 
		 case "/":
			 System.out.println(numberA / numberB);
		 	 break;	 
		 case "%":
			 System.out.println(numberA % numberB);
		 	 break;	
		 }
		
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		switch(browserName) {
		case "chrome":
			 System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			 break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default: 
			new RuntimeException("Please input correct the browser name!");
			break;
			}		
		return driver;
	}
	

}

