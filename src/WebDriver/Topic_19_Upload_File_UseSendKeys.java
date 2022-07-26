package WebDriver;


import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_File_UseSendKeys {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	String uploadFileFolderPath = projectPath + File.separator + "uploadFiles" + File.separator;
	
	String vietnam = "vietnam.jpg";
	String indo = "indonesia.jpg";
	String bridge = "bridge.jpg";
	
	String vietFilePath = uploadFileFolderPath + vietnam;
	String indoFilePath = uploadFileFolderPath + indo;
	String bridgeFilePath = uploadFileFolderPath + bridge;
	
	
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
	
	//@Test
	public void TC_01_Upload_SendKeys_OneFilePerTime() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(vietFilePath);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(indoFilePath);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(bridgeFilePath);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= '" + vietnam + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= '" + indo + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= '" + bridge + "']")).isDisplayed());

		List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
		for (WebElement startButton : startButtons ) {
			startButton.click();
			sleepInSecond(3);
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + vietnam + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + indo + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='" + bridge + "']")).isDisplayed());
		
			
	}
	
	@Test
	public void TC_02_Upload_Multiple_FilesPerTime() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(vietFilePath + "\n" + indoFilePath + "\n" + bridgeFilePath);
				
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
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
