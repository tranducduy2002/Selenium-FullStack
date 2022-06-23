package Button_Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Checkbox_02 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		jsExecutor = (JavascriptExecutor) driver;
	}

	@Test
	public void TC_01_Angular_RadioButton() {
		driver.get("https://material.angular.io/components/radio/examples");
		By summerCheckedbox = By.xpath("//span[contains(text(), 'Summer')]/preceding-sibling::span/input");
		
		if (!driver.findElement(summerCheckedbox).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(summerCheckedbox));
			sleepInMiliSecond(3000);
			Assert.assertTrue(driver.findElement(summerCheckedbox).isSelected());
		}

		
		
		
		
	
	}


	public void sleepInMiliSecond(long timeInMiliSecond) {
	try {
		Thread.sleep(timeInMiliSecond);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
}
