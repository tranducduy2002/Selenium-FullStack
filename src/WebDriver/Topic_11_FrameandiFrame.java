package WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_FrameandiFrame {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//@Test
	public void TC_01_Frame () {
		// Trang A
		driver.get("https://kyna.vn/");
		// Switch To:
		// Alert
		// Frame/ iFrame
		// Windows/ Tab
		
		// Cach 1: dung index (neu nhu cap nhat lai index thi khong chay duoc)
		//driver.switchTo().frame(0);
		
		// Cach 2: dung id/ name (khong nen dung)
		//driver.switchTo().frame("cs_chat_iframe");
		
		
		// Cach 3: dung WebElement (cho tat ca truong hop)
		// Nhay qua trang B
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.fanpage iframe")));
		String facebookLikes = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
		Assert.assertEquals(facebookLikes, "166K likes");
		
		// Nhay tu B ve A
		driver.switchTo().defaultContent();
		
		// Nhay qua trang C
		driver.switchTo().frame(driver.findElement(By.id("cs_chat_iframe")));
		
		// => Element thuoc C
		driver.findElement(By.cssSelector("div.meshim_widget_Widget")).click();
		sleepInSecond(3);
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("John");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("John");
		select = new Select(driver.findElement(By.cssSelector("select#serviceSelect")));
		select.selectByVisibleText("TƯ VẤN TUYỂN SINH");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Default text");
		sleepInSecond(5);
		
		// C ve A
		driver.switchTo().defaultContent();

		// =>  dang o Element cua A
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInSecond(5);

		List<WebElement> searchResults = driver.findElements(By.cssSelector("div.content>h4"));

		Assert.assertEquals(searchResults.size(), 9);
		
		for (WebElement results : searchResults) {
			System.out.println(results.getText());
			// In ra tat ca ten khoa hoc co tu khoa Excel
			Assert.assertTrue(results.getText().contains("Excel"));
			
		}
		
		
	}
	
	
	@Test
	public void TC_02_iFrame_HDFCBank () {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
		driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("duytranduc");
		driver.findElement(By.cssSelector("a.login-btn")).click();
		sleepInSecond(3);
		
		WebElement passwordTextBox = driver.findElement(By.cssSelector("input#fldPasswordDispId"));
		
		Assert.assertTrue(passwordTextBox.isDisplayed());
		
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
