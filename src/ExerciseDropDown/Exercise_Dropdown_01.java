package ExerciseDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_Dropdown_01 {
	WebDriver driver;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, passwords;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Lucas";
		lastName = "Murer";
		day = "20";
		month = "April";
		year = "1986";
		emailAddress = "kusio1236@gmail.com";
		companyName = "Google"; 
		passwords = "12345678";
	}

	@Test
	public void TC_01_NopCommerce() {
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		// Day
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText(day);
		
		// Kiểm tra đã chọn được hay chưa
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		// Kiểm tra 1 dropdown có phải là Multiple hay không
		Assert.assertFalse(select.isMultiple());
		
		// Month
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);

		
		// Year
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(passwords);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(passwords);
		driver.findElement(By.id("register-button")).click();
		
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

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
