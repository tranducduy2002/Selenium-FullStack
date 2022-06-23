package Button_Alert;

import java.util.List;
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

public class Exercise_Checkbox_01 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
	}

	@Test
	public void TC_01_DefaultCheckBoxandRadioButton() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input.k-checkbox"));
		
		for (WebElement checkbox : allCheckboxes) {
			if (checkbox.isEnabled()) {
				if (!checkbox.isSelected()) {
					checkbox.click();
					sleepInMiliSecond(300);
										
				}
				Assert.assertTrue(checkbox.isSelected());
			}
			
		}
		
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		
		WebElement enginethree = driver.findElement(By.cssSelector("input#engine3"));
		if (!enginethree.isSelected()) {
			enginethree.click();
			sleepInMiliSecond(500);
		}
		Assert.assertTrue(enginethree.isSelected());
	
	}


	public void sleepInMiliSecond(long timeInMiliSecond) {
	try {
		Thread.sleep(timeInMiliSecond);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
