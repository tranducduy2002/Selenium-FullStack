package ExerciseTextBox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxOrange {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String initialFirstName, initialLastName, modifiedFirstName, modifiedLastName, employeeID;
	String username, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		username = "Admin";
		password = "admin123";
		initialFirstName = "Lucas";
		initialLastName = "Murher";
		modifiedFirstName = "Michael";
		modifiedLastName = "Jordan";
	}

	@Test
	public void TC_01_InputName() {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		driver.findElement(By.id("firstName")).sendKeys(initialFirstName);
		driver.findElement(By.id("lastName")).sendKeys(initialLastName);
		
		employeeID = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
				
	}

	@Test
	public void TC_02_VerifyName() {
		WebElement firstNameBox = driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement lastNameBox = driver.findElement(By.id("personal_txtEmpLastName"));
		WebElement employeeIDBox = driver.findElement(By.id("personal_txtEmployeeId"));
		
		Assert.assertEquals(firstNameBox.getAttribute("value"), initialFirstName);
		Assert.assertEquals(lastNameBox.getAttribute("value"), initialLastName);
		Assert.assertEquals(employeeIDBox.getAttribute("value"), employeeID);
		
		Assert.assertFalse(firstNameBox.isEnabled());
		Assert.assertFalse(lastNameBox.isEnabled());
		Assert.assertFalse(employeeIDBox.isEnabled());
		
		
		driver.findElement(By.id("btnSave")).click();
		sleepInSecond(1);
		firstNameBox.clear();
		firstNameBox.sendKeys(modifiedFirstName);
		
		lastNameBox.clear();
		lastNameBox.sendKeys(modifiedLastName);
		
		Assert.assertTrue(firstNameBox.isEnabled());
		Assert.assertTrue(lastNameBox.isEnabled());
		
	}
	
	@Test
	public void TC_03_VerifyModifiedName() {
	
		driver.findElement(By.id("btnSave")).click();
		sleepInSecond(3);
		WebElement firstNameBox2 = driver.findElement(By.id("personal_txtEmpFirstName"));
		WebElement lastNameBox2 = driver.findElement(By.id("personal_txtEmpLastName"));
		WebElement employeeIDBox2 = driver.findElement(By.id("personal_txtEmployeeId"));


		Assert.assertEquals(firstNameBox2.getAttribute("value"), modifiedFirstName);
		Assert.assertEquals(lastNameBox2.getAttribute("value"), modifiedLastName);

		Assert.assertFalse(firstNameBox2.isEnabled());
		Assert.assertFalse(lastNameBox2.isEnabled());
		Assert.assertFalse(employeeIDBox2.isEnabled());
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
