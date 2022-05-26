package Topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Topic_06_WebBrowsers {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	

	@Test
	public void TC_01_Chrome() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		driver.quit();
		
	}
	
	// Hàm không có tham số
	public void clickToElement() {
		
	}
	
	
	// Hàm này có 1 tham số
	// Tham số này có kiểu dữ liệu là String
	public void clickToElement(String elementName) {
		
		
	}
	
	// Hàm này có 2 tham số (số lượng)
	public void clickToElement(String elementName, String locatorName) {
		
	}

@Test // Test method
public void TC_01_Login() {
	
	
	
}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
