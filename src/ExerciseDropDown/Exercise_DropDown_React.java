package ExerciseDropDown;

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

public class Exercise_DropDown_React {

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
	public void TC_01_Jquery2() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectCustomDropdown("i.dropdown", "div.item>span", "Christian");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Christian");
	
		selectCustomDropdown("i.dropdown", "div.item>span", "Justen Kitsune");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(), "Justen Kitsune");
	}
	
	public void selectCustomDropdown(String firstMenu, String secondMenu, String option) {
		driver.findElement(By.cssSelector(firstMenu)).click();
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(secondMenu)));
		
		List<WebElement> dropdownMenu = driver.findElements(By.cssSelector(secondMenu));
		
		for (WebElement item : dropdownMenu) {
			String itemName = item.getText();
			if (itemName.equals(option)) {
				item.click();
				sleepInSecond(1);
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
