package WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_Demo {
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
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

	}
	
	//@Test
	public void TC_01_Visible() {
		// Có trong DOM và trên UI => Visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
	}
	
	//@Test
	public void TC_02_Invisible_In_DOM() {
		// Invisible: Không có trên UI và có trong DOM (ko bắt buộc)
		// Kết quả như nhau nhưng thời gian mỗi case khác nhau
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		// chạy chưa đầy 1s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));	
		
		// Không hiển thị - PAS
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).isDisplayed());
		sleepInSecond(2);
		
	}
	
	//@Test
	public void TC_02_Invisible_Not_In_DOM() {
		// Invisible: Không có trên UI và có trong DOM (ko bắt buộc)
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		sleepInSecond(3);
		
		// chạy mất 15s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));	
		
		// Không hiển thị - Failed => 15s
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).isDisplayed());

		
	}
	
	@Test
	public void TC_03_Presence() {
		// Presence: Có trong DOM/ HTML và có trên UI => PASS
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email']")));
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		sleepInSecond(2);
		
		// Presence: Có trong DOM/ HTML và không có trên UI => PASS
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));	

	}
	@Test
	public void TC_04_Staleness() {
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		sleepInSecond(2);
		// Tại thời điểm này element này đang có trong DOM
		WebElement confirmationEmailAddressTextBox = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		
		// Đóng Registration Form lại
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		sleepInSecond(3);
		
		// Wait cho Confirmation Email Address Text Box không còn trong DOM nữa
		// Vì một lý do gì đó mà cần Wait cho đến khi element này không còn tồn tại nữa
		explicitWait.until(ExpectedConditions.stalenessOf(confirmationEmailAddressTextBox));
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	
	public int generateRandomNumber () {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
