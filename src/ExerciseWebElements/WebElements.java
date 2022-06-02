package ExerciseWebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
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
	@Test
	public void TC_02_ValidateElementsEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");


		WebElement mailTextBox = driver.findElement(By.cssSelector("#mail"));
		if (mailTextBox.isEnabled()) {
			System.out.println("Mail Textbox is enabled");
		}
		else {
			System.out.println("Mail Textbox is disabled");
		}
		
		WebElement emailTextBox = driver.findElement(By.cssSelector("#email"));
		if (emailTextBox.isEnabled()) {
		emailTextBox.sendKeys("Automation Testing");		
		System.out.println("Email Textbox is enabled");
		}
		else {
		System.out.println("Email Textbox is disabled");
		}
		
		
		WebElement under18 = driver.findElement(By.cssSelector("#under_18"));
		if (under18.isEnabled()) {
			under18.click();
			System.out.println("Age Under 18 radio is enabled");
		} else {
			System.out.println("Age Under 18 radio is disabled");
		}
		
		WebElement edu = driver.findElement(By.cssSelector("#edu"));
		if (edu.isEnabled()) {
			edu.sendKeys("Automation Testing");		
			System.out.println("Education textarea is enabled");
			}
			else {
			System.out.println("Education textarea is disabled");
			}
		
		WebElement job01DropDown = driver.findElement(By.cssSelector("#job1"));
		if (job01DropDown .isEnabled()) {
			job01DropDown .click();		
			System.out.println("Job Role 01 dropdown is enabled");
			}
			else {
			System.out.println("Job Role 01 dropdown is disabled");
			}
		
		WebElement developmentRadio = driver.findElement(By.xpath("//label[@for='development']"));
		if (developmentRadio.isEnabled()) {
			developmentRadio.click();		
			System.out.println("Development Radio is enabled");
			}
			else {
			System.out.println("Development Radio is disabled");
			}
		
		
		
	}

	@Test
	public void TC_03_ValidateElementsSelected() {
		
	}
	
	@Test
	public void TC_04_RegisterFunction() {
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
}
