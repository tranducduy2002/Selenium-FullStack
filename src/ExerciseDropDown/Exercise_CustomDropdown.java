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

public class Exercise_CustomDropdown {

	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		// Luôn khởi tạo sau driver => vì cần giá trị drivẻ để khởi tạo explicitWait lên
		// Wait cho các element theo điều kiện có sẵn: visible/ invisible/ presence/ clickable ....
		explicitWait = new WebDriverWait(driver,15);
		
		// Wait cho việc tìm element: findelement/ findElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
	}

	@Test
	public void TC_01() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		// * CHỌN ITEM 5 * /
		selectItemInCustomDropdown("number-button", "ul#number-menu>li>div", "5");
		
		// * CHỌN ITEM 10 */
		selectItemInCustomDropdown("number-button", "ul#number-menu>li>div", "10");
	
	}
	
	public void selectItemInCustomDropdown (String parentLocator, String childLocator, String expectedTextItem) {
		driver.findElement(By.id(parentLocator)).click();
		sleepInSecond(1);
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
	
		List<WebElement> allDropdownItems = driver.findElements(By.cssSelector(childLocator));
		
		for (WebElement item : allDropdownItems) {
			String actualTextItem = item.getText();
			
			if (actualTextItem.equals(expectedTextItem)) {
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
