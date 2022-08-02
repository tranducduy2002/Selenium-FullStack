package WebDriver;

import java.io.File;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Explicit_Wait {
	WebDriver driver;
	
	// Wait rõ ràng: vs các điều kiện / status cụ thể
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By loadingIcon = By.cssSelector("div#loading");
	By helloText = By.cssSelector("div#finish h4");
	String uploadFileFolderPath = projectPath + File.separator + "uploadFiles" + File.separator;

	String uploadFile1 = "10MB.jpg";
	String uploadFile2 = "abcd1234.jpg";
	String uploadFile3 = "bridge.jpg";
	
	String file1Path = uploadFileFolderPath + uploadFile1;
	String file2Path = uploadFileFolderPath + uploadFile2;
	String file3Path = uploadFileFolderPath + uploadFile3;
	
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
		
		// Wait ngầm định: không có 1 element/ điều kiện/ status nào rõ ràng
		// Ngầm định cho việc tìm element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//@Test
	public void TC_01_Invisible() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.findElement(By.cssSelector("div#start button")).click();
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(), "Hello World!");

	}
	
	//@Test
	public void TC_02_Visible() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.findElement(By.cssSelector("div#start button")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(), "Hello World!");

	}
	
	//@Test
	public void TC_03_Number() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.findElement(By.cssSelector("div#start button")).click();
		
		explicitWait.until(ExpectedConditions.numberOfElementsToBe(helloText, 1));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish h4")).getText(), "Hello World!");

	}
	
	//@Test
	public void TC_04_Exercise_Ajax_Loading() {
		explicitWait = new WebDriverWait(driver, 30);
		
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		// Wait cho Date Picker xuất hiện
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceholder1_Panel1")));
		
		WebElement selectedDate = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
		
		Assert.assertEquals(selectedDate.getText(), "No Selected Dates to display.");
		
		// Click vào 1 ngày bất kỳ
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='Tuesday, August 16, 2022']"))).click();
		// Wait loading icon biến mất
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
				
		// Verify được ngày đã chọn
		selectedDate = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")); // cần find lại do sau khi click đã bị update
		
		Assert.assertEquals(selectedDate.getText(), "Tuesday, August 16, 2022");
		
		// Verify ngày được update
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='Tuesday, August 16, 2022']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//td[@title='Tuesday, August 16, 2022']")).isDisplayed());
		
	}
	
	public void TC_05_Upload_GoFile() {
		explicitWait = new WebDriverWait(driver, 90);
		driver.get("https://gofile.io/uploadFiles");
		
		By uploadFileBy =  By.cssSelector("input[type='file']");
		
		driver.findElement(uploadFileBy).sendKeys(file1Path + "\n" + file2Path + "\n" + file3Path);
		
		// Wait cho các file được upload thành công
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress"))));
		
		WebElement uploadedText = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Your files have been successfully uploaded']")));
		Assert.assertTrue(uploadedText.isDisplayed());
		
		driver.findElement(By.cssSelector("a#rowUploadSuccess-downloadPage")).click();
		
		switchToWindowByTitle("");
		
	}
	
	public void switchToWindowByTitle(String expectedPageTitle) {
		Set<String> allwindowIDs = driver.getWindowHandles();
		for (String id : allwindowIDs) {
			driver.switchTo().window(id);
			
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				break;
			}
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
