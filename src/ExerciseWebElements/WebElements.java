package ExerciseWebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElements {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_ValidateElementsDisplayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		WebElement mailTextBox = driver.findElement(By.cssSelector("#mail"));
		if (mailTextBox.isDisplayed()) {
			mailTextBox.sendKeys("Automation Testing");
			System.out.println("Mail Textbox is displayed");
		}
		else {
			System.out.println("Mail Textbox is NOT displayed");
		}
		
		
		WebElement emailTextBox = driver.findElement(By.cssSelector("#email"));
		if (emailTextBox.isDisplayed()) {
		emailTextBox.sendKeys("Automation Testing");		
		System.out.println("Email Textbox is displayed");
		}
		else {
		System.out.println("Email Textbox is NOT displayed");
		}
		
		
		WebElement under18 = driver.findElement(By.cssSelector("#under_18"));
		if (under18.isDisplayed()) {
			under18.click();
			System.out.println("Age Under 18 radio is displayed");
		} else {
			System.out.println("Age Under 18 radio is not displayed");
		}
		
		WebElement edu = driver.findElement(By.cssSelector("#edu"));
		if (edu.isDisplayed()) {
			edu.sendKeys("Automation Testing");		
			System.out.println("Education textarea is displayed");
			}
			else {
			System.out.println("Education textarea is NOT displayed");
			}
		
		WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if (user5Text.isDisplayed()) {
			System.out.println("User5 is displayed");
			}
			else {
			System.out.println("User5 is NOT displayed");
			}
	}
	
	// @Test
	public void TC_02_ValidateElementsEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");


		WebElement mailTextBox = driver.findElement(By.cssSelector("#mail"));
		Assert.assertTrue(mailTextBox.isEnabled());
	
		WebElement emailTextBox = driver.findElement(By.cssSelector("#email"));
		Assert.assertTrue(emailTextBox.isEnabled());

		
		
		WebElement under18 = driver.findElement(By.cssSelector("#under_18"));
		Assert.assertTrue(under18.isEnabled());

		
		WebElement edu = driver.findElement(By.cssSelector("#edu"));
		Assert.assertTrue(edu.isEnabled());

		
		WebElement job01DropDown = driver.findElement(By.cssSelector("#job1"));
		Assert.assertTrue(job01DropDown.isEnabled());
		
		WebElement developmentRadio = driver.findElement(By.xpath("//label[@for='development']"));
		Assert.assertTrue(developmentRadio.isEnabled());

		
		
		
	}

	// @Test
	public void TC_03_ValidateElementsSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		WebElement ageUnder18Radio = driver.findElement(By.cssSelector("#under_18"));
		WebElement javaLanguageRadio = driver.findElement(By.cssSelector("#java"));
		
		ageUnder18Radio.click();
		javaLanguageRadio.click();
		
		// Verify 2 fields là selected
		
		Assert.assertTrue(ageUnder18Radio.isSelected());
		Assert.assertTrue(javaLanguageRadio.isSelected());
		if (ageUnder18Radio.isSelected()) {
			System.out.println("Age Under 18 is selected");
		}
		else {
			System.out.println("Age Under 18 is not selected");
		}
		
		if (javaLanguageRadio.isSelected()) {
			System.out.println("Java checkbox 18 is selected");
		}
		else {
			System.out.println("Java checkbox 18 is not selected");
		}
		
		ageUnder18Radio.click();
		javaLanguageRadio.click();
		Assert.assertTrue(ageUnder18Radio.isSelected());
		Assert.assertFalse(javaLanguageRadio.isSelected());
		
		if (ageUnder18Radio.isSelected()) {
			System.out.println("Age Under 18 is selected");
		}
		else {
			System.out.println("Age Under 18 is not selected");
		}
		
		if (javaLanguageRadio.isSelected()) {
			System.out.println("Java checkbox 18 is selected");
		}
		else {
			System.out.println("Java checkbox 18 is not selected");
		}
		
	}
	
	@Test
	public void TC_04_RegisterFunction() {
		driver.get("https://login.mailchimp.com/signup/");
		sleepInSecond(2);		

		
		driver.findElement(By.cssSelector("input#email")).sendKeys("kusio@gmail.com");
		sleepInSecond(1);		

		WebElement userName = driver.findElement(By.cssSelector("input#new_username"));
		userName.click();
		userName.clear();
		sleepInSecond(1);
		userName.sendKeys("kusiohituro");
		sleepInSecond(1);

		WebElement passwordTextBox = driver.findElement(By.cssSelector("input#new_password"));
		
		passwordTextBox.sendKeys("auto"); // lowercase
		sleepInSecond(1);	
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='small-meta selfclear']//li[@class='lowercase-char completed']")).isEnabled());
		sleepInSecond(1);
		
		passwordTextBox.clear();
		sleepInSecond(1);		
		passwordTextBox.sendKeys("AUTO"); // Uppercase
		sleepInSecond(1);		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='small-meta selfclear']//li[@class='uppercase-char completed']")).isEnabled());
		
		passwordTextBox.clear();
		sleepInSecond(1);		

		passwordTextBox.sendKeys("12345"); // Number
		sleepInSecond(1);		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='small-meta selfclear']//li[@class='number-char completed']")).isEnabled());
		
		
		passwordTextBox.clear();
		sleepInSecond(1);		
		passwordTextBox.sendKeys("$@#"); // Special characters
		sleepInSecond(1);		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='small-meta selfclear']//li[@class='special-char completed']")).isEnabled());
		
		
		passwordTextBox.clear();
		sleepInSecond(1);		
		passwordTextBox.sendKeys("12345678"); // 8 characters
		sleepInSecond(1);		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='small-meta selfclear']//li[@class='8-char completed']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='small-meta selfclear']//li[@class='number-char completed']")).isEnabled());
		
		passwordTextBox.clear();
		sleepInSecond(1);		
		passwordTextBox.sendKeys("Auto@123"); // All correct
		sleepInSecond(1);		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()=\"Your password is secure and you're all set!\"]")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
