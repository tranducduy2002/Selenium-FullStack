package User_Interactions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

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
	String jsFileContent;
	
	@BeforeClass
	public void beforeClass () {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
//	@Test
	public void TC_01_DragAndDropHMTL4() {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		WebElement dropCircle = driver.findElement(By.cssSelector("div#droptarget"));
		WebElement dragCircle = driver.findElement(By.cssSelector("div#draggable"));

		action.dragAndDrop(dragCircle, dropCircle).perform();
		sleepInMiliSecond(3000);

		Assert.assertEquals(dropCircle.getText(), "You did great!");

		String dropCircleBackgroundHexa = Color.fromString(dropCircle.getCssValue("background-color")).asHex()
				.toUpperCase();
		Assert.assertEquals(dropCircleBackgroundHexa, "#03A9F4");
	}
	
	@Test
	public void TC_02_DragAndDropHTML5() throws IOException {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		
		jsFileContent = getContentFile(projectPath + "\\dragAndDrop\\drag_and_drop_helper.js");

		jsFileContent = jsFileContent + "$('div#column-a').simulateDragDrop({ dropTarget: 'div#column-b'});";
		
		//Drag A to B
		jsExecutor.executeScript(jsFileContent);
		sleepInMiliSecond(3000);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");
		
		// Drag B to A
		jsExecutor.executeScript(jsFileContent);
		sleepInMiliSecond(3000);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "A");
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "B");
		
	}
	
		public String getContentFile(String filePath) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(filePath);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
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
