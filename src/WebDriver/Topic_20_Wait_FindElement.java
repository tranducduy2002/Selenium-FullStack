package WebDriver;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_FindElement {
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

	}
	
	@Test
	public void TC_01_Find_Element () {
		// - Có duy nhất 1 element
		// Nếu như element xuất hiện ngay -> thì trả về element đó không cần chờ hết timeout
		// Nếu như element chưa xuất hiện -> thì sau 0.5s sẽ tìm lại cho đến khi hết time thì thôi
		System.out.println("Start time =" + getCurrentTime());
		driver.findElement(By.xpath("//input[@id='email']")); // Trả về duy nhất 1 element
		System.out.println("End time =" + getCurrentTime());
		
		// - Không có element nào hết
		
		// - Có nhiều hơn 1 element
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
	
	public String getCurrentTime() {
		Date date = new Date();
		return date.toString();
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
