package WebDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_12_WindowsandTabs {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;
	
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//@Test
	public void TC_01_Windows() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		String parentID = driver.getWindowHandle();
		System.out.println("Tab ID:" + parentID);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(5);
		
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			// id là biến tạm để duyệt qua từng giá trị trong vòng lặp
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
			}
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("input[title='Tìm kiếm']")).sendKeys("Google");
		
		closeAllWindowWithoutParent(parentID);
	}
	
	//@Test
	public void TC_02_MultipleTabs() {
		// Driver đang ở trang A
		driver.get("https://automationfc.github.io/basic-form/index.html");
		String parentID = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		switchToWindowByTitle("GOOGLE");
		sleepInSecond(2);
		
		// Driver đang ở trang B
		driver.findElement(By.cssSelector("input[title='Tìm kiếm']")).sendKeys("Google");
			
		// Switch driver về lại trang A
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
			
		switchToWindowByTitle("Facebook – log in or sign up");
		sleepInSecond(2);
		
		driver.findElement(By.id("email")).sendKeys("kusio@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345678");
		sleepInSecond(2);
		
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		sleepInSecond(2);

		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		sleepInSecond(2);

		switchToWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		sleepInSecond(2);
		closeAllWindowWithoutParent(parentID);

	}
	
	//@Test
	public void TC_03_Techpanda() {
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");
		
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

		driver.findElement(By.cssSelector("button[title='Compare']")).click();
		sleepInSecond(3);
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		
		Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		
		driver.findElement(By.cssSelector("button[title='Close Window']")).click();
		sleepInSecond(3);

		switchToWindowByTitle("Mobile");
		driver.findElement(By.xpath("//a[text()='Clear All']")).click();
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The comparison list was cleared.");
	}
	
	@Test
	public void TC_04_Cambridge() {
		driver.get("https://dictionary.cambridge.org/vi/");
		driver.findElement(By.xpath("//span[contains(@class,'cdo-login-button')]")).click();
		sleepInSecond(3);
		
		switchToWindowByTitle("Login");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		sleepInSecond(2);

		Assert.assertEquals(driver.findElement(By.xpath("//input[@data-gigya-placeholder='Email']/following-sibling::span")).getText(), "This field is required");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@data-gigya-placeholder='Password']/following-sibling::span")).getText(), "This field is required");
		driver.findElement(By.cssSelector("input[data-gigya-placeholder='Email']")).sendKeys("automationfc.com@gmail.com");
		driver.findElement(By.cssSelector("input[data-gigya-placeholder='Password']")).sendKeys("Automation000***");
		sleepInSecond(3);

		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		sleepInSecond(3);

		switchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Automation FC']")).isDisplayed());
	}

	
	// Dùng được cho 2 hoặc nhiều hơn 2 tabs/ windows
	public void switchToWindowByTitle(String expectedPageTitle) {
		Set<String> allwindowIDs = driver.getWindowHandles();
		
		// Dùng vòng lặp để duyejt qua từng ID
		for (String id : allwindowIDs) {
			driver.switchTo().window(id);
			
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				// Thoát khỏi vòng lặp không duyệt nữa
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(String parentID) {
		Set<String> allwindowIDs = driver.getWindowHandles();
		for (String id : allwindowIDs) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}

	}
	
	// Chỉ dùng cho 2 Tabs
	public void switchToWindowByID(String parentID) {
		Set<String> allwindowIDs = driver.getWindowHandles();
		for (String id : allwindowIDs) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
			}
			
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
