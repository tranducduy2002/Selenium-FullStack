package WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_ClickandHold {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	JavascriptExecutor jsExecutor;
	Alert alert;
	
	  @BeforeClass public void beforeClass () {
	  System.setProperty("webdriver.edge.driver", projectPath +
	  "\\browserDrivers\\msedgedriver.exe"); driver = new EdgeDriver(); jsExecutor
	  = (JavascriptExecutor) driver; action = new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  }
	 
	 
	
	@Test
	public void TC_01_ClickandHold () {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		// Store all 12 elements
		List<WebElement> clickable =  driver.findElements(By.cssSelector("ol#selectable>li"));
		Assert.assertEquals(clickable.size(), 12);
		
		// Click và giữ chuột tại số thứ 1
		action.clickAndHold(clickable.get(0))
		
		// kéo tới số 11
		.moveToElement(clickable.get(10))
		
		// thả chuột trái ra
		.release()
		
		// thực thi
		.perform();
		
		 clickable =  driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		 
		 Assert.assertEquals(clickable.size(), 9);
	}
	
	@Test
	public void TC_01_ClickandHoldRandom () {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		// Store all 12 elements
		List<WebElement> clickable =  driver.findElements(By.cssSelector("ol#selectable>li"));
		Assert.assertEquals(clickable.size(), 12);
		
		// nhấn phím Control xuống
		action.keyDown(Keys.CONTROL).perform();

		action.click(clickable.get(0))
		.click(clickable.get(2))
		.click(clickable.get(5))
		.click(clickable.get(7))
		.click(clickable.get(10))
	
		// thực thi
		.perform();
		
		clickable =  driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		 
		 Assert.assertEquals(clickable.size(), 5);
	}
	
	@Test
	public void TC_03_DoubleClick () {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double click me']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", doubleClick);
		action.doubleClick(doubleClick).perform();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
		
		
	}
	
	@Test
	public void TC_04_RightClick () {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		sleepInMiliSecond(3000);
		
		WebElement deleteBefore = driver.findElement(By.cssSelector("li.context-menu-icon-delete"));
		action.moveToElement(deleteBefore).perform();
		sleepInMiliSecond(3000);

		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-delete.context-menu-hover.context-menu-visible")).isDisplayed());
		
		action.click(deleteBefore).perform();
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "clicked: delete");
		alert.accept();
		sleepInMiliSecond(3000);

		Assert.assertFalse(deleteBefore.isDisplayed());
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
