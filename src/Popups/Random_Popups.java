package Popups;

import java.util.List;
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

public class Random_Popups {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;
	String jsFileContent;
	
	@BeforeClass
	public void beforeClass () {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//@Test
	public void TC_01_Radom_Popup_InDOM_KMPlayer() {
		driver.get("http://www.kmplayer.com/");
		
		WebElement popupKMPL = driver.findElement(By.cssSelector("div.pop-layer"));
		
		// Phải luôn chạy được testcase dù popup có hiển thị hay không
		// Đang trong đợt sale nó hiển thị thì script mình phải đóng nó đi để chạy tiếp
		// Hết đợt sale không hiển thị thì script chạy luôn
		if (popupKMPL.isDisplayed()) {
			// Close nó đi để chạy tiếp step tiếp theo
			// driver.findElement(By.cssSelector("area#btn-r")).click(); => ko click được do button bị che
			
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("area#btn-r")));
			sleepInSecond(3);
		}
		
		driver.findElement(By.cssSelector("p.donate-coffee")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.buymeacoffee.com/kmplayer?ref=hp&kind=top");
		
	}
	
	@Test
	public void TC_02_Radom_Popup_NotInDOM_KMPlayer() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(3);
		List<WebElement> popupDeHieu = driver.findElements(By.cssSelector("div.popup-content"));

		if (popupDeHieu.get(0).isDisplayed()) {
			driver.findElement(By.id("popup-name")).sendKeys("duy");
			driver.findElement(By.id("popup-email")).sendKeys("duy.tran@gmail.com");
			driver.findElement(By.id("popup-phone")).sendKeys("12345678");
			sleepInSecond(3);
			driver.findElement(By.cssSelector("button#close-popup")).click();
			sleepInSecond(3);
		}
		sleepInSecond(3);

		driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
		sleepInSecond(3);

		Assert.assertEquals(driver.getCurrentUrl(), "https://dehieu.vn/khoa-hoc");
		
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
