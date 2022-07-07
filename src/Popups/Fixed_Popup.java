package Popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Fixed_Popup {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	JavascriptExecutor jsExecutor;
	String jsFileContent;
	
	@BeforeClass
	public void beforeClass () {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void TC_01_FixedPopupInDOM() {
		driver.get("https://ngoaingu24h.vn/");
		
		WebElement loginPopup = driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]"));
		
		Assert.assertFalse(loginPopup.isDisplayed());
		
		driver.findElement(By.cssSelector("button.login_")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(loginPopup.isDisplayed());

		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//input[@id='account-input']")).sendKeys("automationfc");
		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//input[@id='password-input']")).sendKeys("automationfc");
		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//button[contains(@class,'btn-login-v1')]")).click();
		sleepInSecond(3);

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//div[@class='row error-login-panel']")).getText(), "Tài khoản không tồn tại!");
		
		// Close popup
		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//button[@class='close']")).click();
		sleepInSecond(3);

		Assert.assertFalse(loginPopup.isDisplayed());

	}
	
	@Test
	public void TC_02_FixedPopupInDOM() {
		driver.get("https://ngoaingu24h.vn/");
	
	}

	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
