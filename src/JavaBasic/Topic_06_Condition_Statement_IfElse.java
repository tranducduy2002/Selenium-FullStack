package JavaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
		System.setProperty("webdriver.ie.driver", projectPath + "\\browerDrivers\\IEDriverServer.exe");
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
