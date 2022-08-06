package Exercises;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_DropDown_VueJS {

	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		explicitWait = new WebDriverWait(driver,15); 
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
      

	@Test
	public void TC_03_Vuejs() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "First Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
	
		selectCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Second Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
		
		selectCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Third Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
	}
	

	@Test
	public void TC_04_DefaultDropdown_Nopcommerce() {
		driver.get("https://demo.nopcommerce.com/register");
		
		selectCustomDropdown("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "10");
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='10']")).isSelected());
	
	}
	
	public void selectCustomDropdown(String firstMenu, String secondMenu, String option) {
		driver.findElement(By.cssSelector(firstMenu)).click();
		sleepInSecond(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(secondMenu)));
		
		List<WebElement> dropdownMenu = driver.findElements(By.cssSelector(secondMenu));
		
		for (WebElement item : dropdownMenu) {
			String itemName = item.getText();
			System.out.println("Item Name:" + itemName);
			if (itemName.equals(option)) {
				item.click();
				break;
				}
		}
				
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
