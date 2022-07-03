package User_Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragandDrop {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	JavascriptExecutor jsExecutor;
	Alert alert;
	@BeforeClass
	public void beforeClass () {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	@Test
	public void TC_01_DragAndDropHMTL$ () {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		WebElement dropCircle = driver.findElement(By.cssSelector("div#droptarget"));
		WebElement dragCircle = driver.findElement(By.cssSelector("div#draggable"));
		
		action.dragAndDrop(dragCircle, dropCircle).perform();
		sleepInMiliSecond(3000);
		
		Assert.assertEquals(dropCircle.getText(), "You did great!");
		
		String dropCircleBackgroundHexa = Color.fromString(dropCircle.getCssValue("background-color")).asHex().toUpperCase();
		Assert.assertEquals(dropCircleBackgroundHexa, "#03A9F4");
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
