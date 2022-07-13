package Windows_Tabs;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WindowsandTabs {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	
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
	
	@Test
	public void TC_01_Windows() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		String getTabID = driver.getWindowHandle();
		System.out.println("Tab ID:" + getTabID);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(5);
		
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			// id là biến tạm để duyệt qua từng giá trị trong vòng lặp
			if(!id.equals(getTabID)) {
				driver.switchTo().window(id);
			}
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("input[title='Tìm kiếm']")).sendKeys("Google");
	}
	
	@Test
	public void TC_02_MultipleTabs() {
		// Driver đang ở trang A
		driver.get("https://automationfc.github.io/basic-form/index.html");
		String initialTabID = driver.getWindowHandle();
		System.out.println("Initial Tab ID: " + initialTabID);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		String secondTabID = driver.getWindowHandle();
		
		System.out.println("Initial Tab ID: " + secondTabID);
		
		// Switch Driver qua trang B
		switchToWindowByID(secondTabID);
		
		// Driver đang ở trang B
		driver.findElement(By.cssSelector("input[title='Tìm kiếm']")).sendKeys("Google");
		
		String googleTabID = driver.getWindowHandle();
		
		// Switch driver về lại trang A
		switchToWindowByID(googleTabID);
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
