package Interface;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAttirbute {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		jsExecutor = (JavascriptExecutor) driver;
	}
	
	@Test
	public void TC_01_LIVEPanda() {
		driver.get("https://warranty.rode.com");
		sleepInSecond(2);
		String firstName = driver.findElement(By.id("firstname")).getAttribute("validationMessage");
		System.out.println(firstName);
		
		driver.findElement(By.id("firstname")).sendKeys("ABCD");
		driver.findElement(By.id("surname")).sendKeys("ABCD");
		driver.findElement(By.xpath("//div[contains(text(),'Register')]/following-sibling::div//input[@id='email']")).sendKeys("ABCD");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		String emailAddress = driver.findElement(By.xpath("//div[contains(text(),'Register')]/following-sibling::div//input[@id='email']")).getAttribute("validationMessage");
		
		System.out.println(emailAddress);

		
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
}
