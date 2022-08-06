package Exercises;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Alert_Exercise {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String autoITChrome = projectPath + "\\autoITAuthentication\\authen_chrome.exe";
	Select select;
	Alert alert;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	
	}
	
	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepInSecond(2);
		
		// Nó chỉ nên khởi tạo khi element/ alert đó xuất hiện
		
		
		// Muốn thao tác được với Alert đang bật lên đó thì cẩn phải switch vào nó
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		// Accept cái Alert
		alert.accept();
		
		// Verfiry alert được accept thành công
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
	}
	
	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		alert.dismiss();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
		
		
	}
	
	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS prompt");

		String text = "Prompt message";
		
		alert.sendKeys(text);
		sleepInSecond(2);
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + text);
	}
	
	//@Test
	public void TC_04_Authentication_Alert_Trick() {
		// Selenium cho pheps pass user/ pass trực tiếp vào URl trước khi open link
		// Format: https//Username:Password@domain
		String username = "admin";
		String password = "admin";
		String url = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth" ;
			
		driver.get(url);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div#content p")).getText().contains("Congratulations! You must have the proper credentials."));
		
	}
	

	public void TC_05_Authentication_Alert_AutoIT() throws IOException {
		String username = "admin";
		String password = "admin";
		
		// Trước khi mở URL lên
		// Cho nó execute cái file exe Auto IT trước để chờ alert bật lên trước
		Runtime.getRuntime().exec(new String[] {autoITChrome, username, password});
		
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div#content p")).getText().contains("Congratulations! You must have the proper credentials."));
	}
	
	@Test
	public void TC_06_Authentication_Alert_Trick_Navigate_From_Other_Page() throws IOException {
		String username = "admin";
		String password = "admin";
		
		driver.get("http://the-internet.herokuapp.com");

		//Không nên click vào link để cho nó show Dialog ra
		// Nên get Url của link đó
		String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		// http://the-internet.herokuapp.com/basic_auth
		
		// 1 - Tách link này ra thành nhiều chuỗi
		String[] authenLinkArray = basicAuthenLink.split("//");
		// http:
		// the-internet.herokuapp.com/basic_auth
		
		// 2 - Lấy chuỗi cộng vào
		String newAuthenLinkUrl = authenLinkArray[0] + "//" + username + ":" + password + "@" + authenLinkArray[1];
		
		driver.get(newAuthenLinkUrl);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div#content p")).getText().contains("Congratulations! You must have the proper credentials."));
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
