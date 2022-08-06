package Exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dropdown_02 {
	WebDriver driver;
	Select select;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_NopCommerce() {
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(By.id("FirstName")).sendKeys();
		driver.findElement(By.id("LastName")).sendKeys();
	
		// Dropdown
		// Khi nào dùng để thao tác với element thì mới khởi tạo
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		
		// thao tác với dropdown
		
		// Index: là thứ tự của thẻ option
		select.selectByIndex(1);
		select.selectByIndex(5);
		
		// Value: là giá trị của thuộc tính "value"
		select.selectByValue("1");
		select.selectByValue("5");
		
		// Text: là item text
		select.selectByVisibleText("Day");
		select.selectByVisibleText("5");

	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
