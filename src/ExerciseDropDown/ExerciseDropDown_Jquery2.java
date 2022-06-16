package ExerciseDropDown;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExerciseDropDown_Jquery2 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, emailAddress, companyName, passwords;
	String day, month, year;
	
	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Kusio";
		lastName = "Hituro";
		emailAddress = "kusio" + generateRandomNumber() + "@gmai.com";
		companyName = "Google";
		passwords = "12345678";
		day = "1";
		month = "May";
		year = "1996";
	}

	@Test
	public void TC_04 () {
		driver.get("https://demo.nopcommerce.com");
		driver.findElement(By.className("ico-register")).click();
		
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.name("FirstName")).sendKeys(firstName);
		driver.findElement(By.name("LastName")).sendKeys(lastName);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		List<WebElement> firstCount = select.getOptions();
		int countDay = firstCount.size();
		System.out.println(countDay);
		select.selectByVisibleText(day);
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		List<WebElement> secondCount = select.getOptions();
		int optionMonth = secondCount.size();
		System.out.println(optionMonth);
		select.selectByVisibleText(month);
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		List<WebElement> thirdCount = select.getOptions();
		int optionYear = thirdCount.size();
		System.out.println(optionYear);
		select.selectByVisibleText(year);
				
		driver.findElement(By.name("Email")).sendKeys(emailAddress);
		driver.findElement(By.name("Company")).sendKeys(companyName);
		driver.findElement(By.name("Password")).sendKeys(passwords);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(passwords);
			
		driver.findElement(By.name("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
		
		driver.findElement(By.className("ico-account")).click();
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);

		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
	
	}

	@Test
	public void TC_05 () {
		driver.get("https://applitools.com/automating-tests-chrome-devtools-recorder-webinar");
		select = new Select(driver.findElement(By.id("Person_Role__c")));
		select.selectByVisibleText("Software Developer");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Software Developer"); 
		
		select = new Select(driver.findElement(By.name("Test_Framework__c")));
		select.selectByVisibleText("*Existing Test Framework");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "*Existing Test Framework"); 
		
		select = new Select(driver.findElement(By.name("Self_Report_Country__c")));
		select.selectByVisibleText("United Kingdom");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "United Kingdom"); 
		
		

		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
