package WebDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Mix_Implicit_Explicit_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
	
	}
	
	@Test
	public void TC_01_Element_Found () {
		driver.get("https://facebook.com");
		By emailIDBy = By.id("email");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Start implicit:" + getCurrentTime());
		driver.findElement(emailIDBy).isDisplayed();
		System.out.println("End implicit:" + getCurrentTime());
		
		explicitWait = new WebDriverWait(driver, 10);
		System.out.println("Start explicit:" + getCurrentTime());

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailIDBy));
		System.out.println("End explicit:" + getCurrentTime());

	}
	
	@Test
	public void TC_02_Element_NotFound_Only_Implicit () {
		driver.get("https://facebook.com");
		By emailIDBy = By.id("vietnam");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Start implicit:" + getCurrentTime());
		
		try {
			driver.findElement(emailIDBy).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End implicit:" + getCurrentTime());
		
	}
	
	@Test
	public void TC_03_Element_NotFound_Only_Explicit() {
		driver.get("https://facebook.com");
		By emailIDBy = By.id("vietnam");
		
		explicitWait = new WebDriverWait(driver, 15);
		System.out.println("Start explicit:" + getCurrentTime());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailIDBy));
		} catch (Exception e) {

		}
		System.out.println("End explicit:" + getCurrentTime());
	}
	@Test
	public void TC_04_Element_NotFound_Implicit_Explicit() {
		driver.get("https://facebook.com");
		By emailIDBy = By.id("vietnam");
		// 1. implicit < explicit
		// 2. implicit = explicit
		// 3. implicit > explicit
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 2);
		System.out.println("Start explicit:" + getCurrentTime());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailIDBy));
		} catch (Exception e) {

		}
		System.out.println("End explicit:" + getCurrentTime());
	}
	
	@Test
	public void TC_05_Element_NotFound_Implicit_Explicit() {
		
		
	}
	
	public String getCurrentTime() {
		Date date = new Date();
		return date.toString();
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
