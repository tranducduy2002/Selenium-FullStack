package User_Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Actions_API {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	
	@BeforeClass
	public void beforeClass () {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	@Test
	public void TC_01_Hover () {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		
		// Move to element then click
		WebElement inputAge = driver.findElement(By.cssSelector("input#age"));
		
		action.moveToElement(inputAge).perform();
		sleepInMiliSecond(3000);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
		// Click directly on the element - not move
		// driver.findElement(By.xpath("")).click();
	}
	
	@Test
	public void TC_02_Hover() {
		driver.get("https://www.myntra.com/");
		WebElement kidsMenu = driver.findElement(By.cssSelector("a[data-group='kids']"));
		
		action.moveToElement(kidsMenu).perform();
		sleepInMiliSecond(3000);

		action.click(driver.findElement(By.xpath("//a[text()='Home & Bath']"))).perform();
		sleepInMiliSecond(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Kids Home Bath']")).isDisplayed());
		
	}
	
	
	@Test
	public void TC_03_Hover() {
		driver.get("https://www.fahasa.com/");
		driver.manage().window().maximize();

		WebElement homeMenu = driver.findElement(By.cssSelector("span.icon_menu"));
		action.moveToElement(homeMenu).perform();
		sleepInMiliSecond(3000);

		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sách Trong Nước']"))).perform();
		sleepInMiliSecond(3000);

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='fhs_menu_content fhs_column_left']")).isDisplayed());
		
		
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
