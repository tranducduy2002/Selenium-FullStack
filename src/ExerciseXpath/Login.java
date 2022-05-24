package ExerciseXpath;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, middleName, lastName, emailAddress, password, fullName;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_LgoinEmptyEmailandPassword() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("send2")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
		
	}

	@Test
	public void TC_02_LoginInvalidEmail() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("12341234@123.123");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	}

	@Test
	public void TC_03_LoginwithBelow6Characters() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1234");
		driver.findElement(By.id("send2")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

	}
	@Test
	public void TC_04_LoginIncorrectEmailandPassword() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.id("send2")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li[class='error-msg'] span")).getText(), "Invalid login or password.");
				
	}

	public int generateRandomNumber () {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	@Test
	public void TC_05_CreateNewAccount() {
		firstName = "Kusio";
		middleName = "Hi";
		lastName = "Turo";
		fullName = firstName + " " + middleName + " " + lastName;
		emailAddress = "kusio" + generateRandomNumber() + "@gmail.com";
		password = "123456789";
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.cssSelector("div.buttons-set a")).click();
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("middlename")).sendKeys(middleName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email_address")).sendKeys(emailAddress);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmation")).sendKeys(password);
		driver.findElement(By.cssSelector("div.buttons-set span")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
		
		String contactInfoText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue(contactInfoText.contains(fullName));
		Assert.assertTrue(contactInfoText.contains(emailAddress));
		
		driver.findElement(By.cssSelector("a[class*='skip-account'] span.label")).click();
		driver.findElement(By.cssSelector("div.links a[title='Log Out']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'This is demo site for')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "THIS IS DEMO SITE FOR   " );
	
	}
	
	@Test
	public void TC_06_LoginwithValidEmailPassword() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.name("login[username]")).sendKeys(emailAddress);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
		String contactInfoText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue(contactInfoText.contains(fullName));
		Assert.assertTrue(contactInfoText.contains(emailAddress));
		driver.quit();
	}


	
}
