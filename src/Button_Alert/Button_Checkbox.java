package Button_Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Button_Checkbox {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
      

	@Test
	public void TC_01_EditableDropdown() {
		driver.get("https://www.fahasa.com/customer/account/create");
		// Xử lý popup thì không cần sleep cứng
		sleepInSecond(4);
		driver.findElement(By.cssSelector("li.popup-login-tab-item")).click();
		
		By loginButtonBy = By.cssSelector("button.fhs-btn-login");
		
		Assert.assertFalse(driver.findElement(loginButtonBy).isEnabled());
		
		driver.findElement(By.cssSelector("input#login_username")).sendKeys("kusio@gmail.com");
		driver.findElement(By.cssSelector("input#login_password")).sendKeys("12345678");
		
		Assert.assertTrue(driver.findElement(loginButtonBy).isEnabled());
		// Apply WebDriverWait thì không cần sleep cứng
		sleepInSecond(1);
		
		String loginButtonBackgroundHexa = Color.fromString(driver.findElement(loginButtonBy).getCssValue("background-color")).asHex().toUpperCase();
		
		Assert.assertEquals(loginButtonBackgroundHexa, "#C92127");
		
	
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