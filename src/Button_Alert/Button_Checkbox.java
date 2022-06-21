package Button_Alert;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void TC_01_Button() {
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

	@Test
	public void TC_02_Checbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		// 1- Chọn (Choice) - Click
		driver.findElement(By.cssSelector("input[value='Emotional Disorder']")).click();
		driver.findElement(By.cssSelector("input[value='Digestive Problems']")).click();
		driver.findElement(By.cssSelector("input[value='Venereal Disease']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("input[value='5+ days']")).click();
		driver.findElement(By.cssSelector("input[value=\"I don't have a diet plan\"]")).click();
		driver.findElement(By.cssSelector("input[value=\"3-4 glasses/day\"]")).click();
		sleepInSecond(3);
		
		// 2 - Verify (Chọn rồi hay chưa chọn thành công)
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Emotional Disorder']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Digestive Problems']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Venereal Disease']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='5+ days']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value=\"I don't have a diet plan\"]")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='3-4 glasses/day']")).isSelected());
		
		// 3 - Bỏ chọn (De-select)
		driver.findElement(By.cssSelector("input[value='Emotional Disorder']")).click();
		driver.findElement(By.cssSelector("input[value='Digestive Problems']")).click();
		driver.findElement(By.cssSelector("input[value='Venereal Disease']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("input[value='5+ days']"));
		driver.findElement(By.cssSelector("input[value=\"I don't have a diet plan\"]"));
		driver.findElement(By.cssSelector("input[value='3-4 glasses/day']"));
		sleepInSecond(3);
		
		// 4 - 
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='Emotional Disorder']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='Digestive Problems']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='Venereal Disease']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='5+ days']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value=\"I don't have a diet plan\"]")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='3-4 glasses/day']")).isSelected());
		
	
	}
	
	@Test
	public void TC_03_Select_All_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (WebElement checkbox : allCheckboxes) {
			if (!checkbox.isSelected()) {
			checkbox.click();
			sleepInSecond(1);
			}
			Assert.assertTrue(checkbox.isSelected()); // Verify

		}
		
		// Verify all checkboxes are deselected
		for (WebElement checkbox : allCheckboxes) {
			if (checkbox.isSelected()) {
				checkbox.click();
				sleepInSecond(1);
			}
			Assert.assertFalse(checkbox.isSelected());

		}
		
		
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