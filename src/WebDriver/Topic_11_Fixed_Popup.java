package WebDriver;

import static org.testng.Assert.assertFalse;

import java.util.List;
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

public class Topic_11_Fixed_Popup {
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//@Test
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
	
	//@Test
	public void TC_02_FixedPopupInDOM() {
		driver.get("https://kyna.vn");
		
		WebElement loginKyna = driver.findElement(By.cssSelector("div#k-popup-account-login"));
		
		Assert.assertFalse(loginKyna.isDisplayed());
		
		driver.findElement(By.xpath("//div[@class='mobile-button-wrap']/a[contains(text(),'Đăng nhập')]")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(loginKyna.isDisplayed());
		
		driver.findElement(By.cssSelector("input#user-login")).sendKeys("duy.tran1234@gmai.com");
		driver.findElement(By.cssSelector("input#user-password")).sendKeys("12345678");
		
		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
		
		driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
		sleepInSecond(3);

		Assert.assertFalse(loginKyna.isDisplayed());

	}

	@Test
	public void TC_03_FixedPopupNotInDOM_Tiki() {
		driver.get("https://tiki.vn/");
		
		// Khi mới mở thì không có popup trong DOM, nên không findelement được
		// findElement should not be used to look for non present elements
		// Show ra lỗi NosuchElementException sau khoảng thời gian là xx giây (implicitWait)
		// 15s sau sẽ fail
		// WebElement loginTiki = driver.findElement(By.cssSelector("div[role='dialog']"));
		
		
		// Trong trường hợp popup không có trong DOM thì findElements này sẽ tìm thấy 0 element
		//  Và cũng chờ hết timeout của implicitWait nhưng không có đánh fail testcase và cũng ko show Exception
		// Empty list = 0 element
		List<WebElement> loginTiki = driver.findElements(By.cssSelector("div.ReactModalPortal"));
		
		// Undisplayed
		Assert.assertEquals(loginTiki.size(), 0);
		
		// Click vào đăng nhập để show popup lên
		driver.findElement(By.xpath("//span[text()='Đăng Nhập / Đăng Ký']")).click();
		sleepInSecond(3);
		
		// Display (Single Element: findElement)
		Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModalPortal")).isDisplayed());
		sleepInSecond(3);
		
		// Display (Multiple Elements: findElements)
		loginTiki = driver.findElements(By.cssSelector("div.ReactModalPortal"));
		Assert.assertEquals(loginTiki.size(), 1);
		Assert.assertTrue(loginTiki.get(0).isDisplayed());
		
		// CLick để đóng popup
		driver.findElement(By.cssSelector("img.close-img")).click();
		sleepInSecond(3);
		
		loginTiki = driver.findElements(By.cssSelector("div.ReactModalPortal"));
		Assert.assertEquals(loginTiki.size(), 0);
		
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
