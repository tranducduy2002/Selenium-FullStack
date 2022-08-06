package Exercises;

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

public class TextBoxGuru {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, userID, loginPasswords, loginUrl, genderOutput, customerName;
	String doBInput, doBOutput, addressInput, addressOutput, city, state, pinCode, phoneNumber;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		jsExecutor = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		
		loginUrl = driver.getCurrentUrl();		
		emailAddress = "kusio" + generateRandomNumber() + "@gmail.com";
		customerName = "Kusio";
		genderOutput = "male";
		doBInput = "08/31/1990"; 
		doBOutput = "1990-08-31";
		addressInput = "3945\nGoosetown\nDrive";
		addressOutput = "3945 Goosetown Drive";
		city = "Hendersonville";
		state = "North Carolina";
		pinCode = "123456";
		phoneNumber = "9102004133";
	}
	
	public int generateRandomNumber () {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	@Test
	public void TC_01_Register () {
		driver.findElement(By.xpath("//a[@href='http://demo.guru99.com/']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		loginPasswords = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
			
	}

	@Test
	public void TC_02_Login () {
		driver.get(loginUrl);
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginPasswords);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("tr.heading3>td")).getText(), "Manger Id : " + userID);

	}
	
	@Test
	public void TC_03_CreateNewCustomer () {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();		
		
		driver.findElement(By.name("name")).sendKeys(customerName);
		driver.findElement(By.xpath("//input[@value='m']")).click();	
		
		WebElement doBTextBox = driver.findElement(By.id("dob"));
		jsExecutor.executeScript("arguments[0].removeAttribute('type')", doBTextBox);
		doBTextBox.sendKeys(doBInput);
		
		driver.findElement(By.name("addr")).sendKeys(addressInput);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pinCode);
		driver.findElement(By.name("telephoneno")).sendKeys(phoneNumber);
		driver.findElement(By.name("emailid")).sendKeys(emailAddress);
		driver.findElement(By.name("password")).sendKeys(loginPasswords);
		driver.findElement(By.name("sub")).click();

		
		//Output => Verify
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p.heading3")).getText(), "Customer Registered Successfully!!!");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), genderOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), doBOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), addressOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinCode);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phoneNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), emailAddress);

		
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
		driver.quit();
	}
	
}
