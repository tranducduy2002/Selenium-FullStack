package WebDriver;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic19_UploadFiles_UseFunction {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	String uploadFileFolderPath = projectPath + File.separator + "uploadFiles" + File.separator;
	
	List<String> fileNames = getFileNameInFolder();

	

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
	public void TC_01_Upload_SendKeys_OneFilePerTime() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		for (String fileName : fileNames) {
			driver.findElement(By.cssSelector("input[type='file']")).sendKeys(uploadFileFolderPath + fileName);
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= '" + fileName + "']")).isDisplayed());
			
		}


	}
	
	//@Test
	public void TC_02_Upload_Multiple_FilesPerTime() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	
		
		
		
	}
	
	public List<String> getFileNameInFolder() {
		File directoryPath = new File(uploadFileFolderPath);
		String contents[] = directoryPath.list();
		
		List<String> fileNames = new ArrayList<String>();
		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);
			fileNames.add(contents[i]);
		}
		return fileNames;
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
