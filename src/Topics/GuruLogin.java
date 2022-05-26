package Topics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GuruLogin {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void Getaccount() {
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//a[@href='http://demo.guru99.com/']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("duy.tran@gmail.co");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		String loginPasswords = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginPasswords);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee")).getText(),"Welcome To Manager's Page of Guru99 Bank");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
