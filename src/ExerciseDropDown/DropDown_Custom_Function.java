package ExerciseDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown_Custom_Function {

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
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
				
		selectCustomDropdown("selectize-input", "div.dropdown-menu>a", "CIVIC E (Đen ánh/ Xám phong cách)");
		sleepInSecond(1);

		selectCustomDropdown("province", "select#province>option", "Đà Nẵng");
		sleepInSecond(1);

		selectCustomDropdown("registration_fee", "select#registration_fee>option", "Khu vực III");
		sleepInSecond(1);

	}
	
	public void selectCustomDropdown(String firstMenu, String secondMenu, String option) {
		driver.findElement(By.id(firstMenu)).click();
		
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
