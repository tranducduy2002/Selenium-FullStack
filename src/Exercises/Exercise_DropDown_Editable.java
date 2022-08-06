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

public class Exercise_DropDown_Editable {

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
	public void TC_05_EditableDropdown() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		enterItemDropdown("input.search", "div.item>span", "Bangladesh");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Bangladesh");
	
	}
	

	public void enterItemDropdown(String editableLocator, String childLocator, String expectedTextItem) {
		driver.findElement(By.cssSelector(editableLocator)).sendKeys(expectedTextItem);
		sleepInSecond(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List<WebElement> dropdownMenu = driver.findElements(By.cssSelector(childLocator));
		
		for (WebElement item : dropdownMenu) {
			String itemName = item.getText();
			System.out.println("Item Name:" + itemName);
			if (itemName.equals(expectedTextItem)) {
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
