package JavaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement_IfElse {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Test
	public void TC_02_If_Else () {
		// Có tới 2 điều kiện: đúng thì vào if - sai thì vào else
		
		
		// Nếu driver start với browser như Chrome/ FireFox/ Edge/ Safari thì dùng hàm click 
		// thông thường (builtin) của Selenium WebElement
		
		
		// Nếu driver là IE thì dùng hàm click của JSExecutor
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");

		driver = new InternetExplorerDriver();
		
		/*
		 * System.setProperty("webdriver.chrome.driver", projectPath +
		 * "\\browerDrivers\\chromedriver.exe"); driver = new ChromeDriver();
		 */
		
		if (driver.toString().contains("internet explorer")) {
			System.out.println("Click by Javasript Executor");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
		
	}
	
	@Parameters("browser")
	@Test
	public void TC_03_If_Else_If_Else (String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}  else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please input correct the browser name!");
		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		
	}
	
	@Test
	public void TC_04_If_Else_If_Else() {
		// Page Object
		// Dynamic Page
		String pageName = "Login";
		
		if (pageName.equals("Login")) {
			// LoginPage loginPAge = new LoginPage();
			// return loginPage;
		} else if (pageName.equals("Register")){
			// Register page registerPage = new RegisterPage();
			// return registerPage;
		} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;
		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
		}
		
		// if-else
		int age = 20;
		String access = (age <18) ? "You cannot access" : "Welcome to our system!";
		
		// Tương đương
		if (age <18) {
			access = "You cannot access";
		} else {
			access = "Welcome to our system!";
		}
		System.out.println(access);
	}
	
	public static void main(String[] args) {
		boolean status = 5 > 3;
		System.out.println(status);
		
		// Hàm if sẽ nhận vào 1 điều kiện đúng
		if (status) {
			// Đúng thì vào phần thân của if
			// Sai thì bỏ qua
			System.out.println("Go to if");
			
		}
		
		// Gán
		int studentNumber = 10;
		
		// So sánh
		status = (studentNumber == 10);
		System.out.println(status); // Result = true
		
		status = (studentNumber != 10);
		System.out.println(status); // Result = false
		
		WebDriver driver = new FirefoxDriver();
		
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}
		
		// Element không có trong DOM khi popup không hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		//	Check element không hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
			
		}
		
		// Uncheck to checkbox
		WebElement languaguesCheckbox = driver.findElement(By.id(""));
		if (languaguesCheckbox.isSelected()) {
			languaguesCheckbox.clear();
		}
		
		if (!languaguesCheckbox.isSelected()) {
			languaguesCheckbox.clear();
		}
		
		
		
	}
}
