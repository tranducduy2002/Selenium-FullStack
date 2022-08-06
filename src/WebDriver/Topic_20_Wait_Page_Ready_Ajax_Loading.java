package WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_Page_Ready_Ajax_Loading {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
		action = new Actions(driver);
	}
	
	//@Test
	public void TC_01_Orange_HRM_Implicit () {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://api.orangehrm.com/#api-_");


		Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");
	}
	
	//@Test
	public void TC_02_Orange_HRM_Explicit () {		
		driver.get("https://api.orangehrm.com/#api-_");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 15);
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");
	}
	
	//@Test
	public void TC_03_Orange_HRM_Page_Ready () {
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
			
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Assert.assertTrue(isPageLoadedSuccess());
		Assert.assertTrue(driver.findElement(By.cssSelector("div#div_graph_display_emp_distribution")).isDisplayed());
	}
	@Test
	public void TC_04_Test_Project_Page_Ready () {
		driver.get("https://blog.testproject.io/");

		// Handle popup
		if (driver.findElement(By.cssSelector("div#mailch-bg")).isDisplayed()) {
			driver.findElement(By.cssSelector("div#close-mailch")).click();
		}
		// Hove mouse to Search text box
		action.moveToElement(driver.findElement(By.cssSelector("section#search-2 input.search-field"))).perform();
		
		Assert.assertTrue(isPageLoadedSuccess());
		driver.findElement(By.cssSelector("section#search-2 input.search-field")).sendKeys("Selenium");
		driver.findElement(By.cssSelector("section#search-2 span.glass")).click();
		
		Assert.assertTrue(isPageLoadedSuccess());
		List<WebElement> firstAllPostTitle = driver.findElements(By.cssSelector("div#post-content a"));
		for (WebElement postTitle : firstAllPostTitle) {
			Assert.assertTrue(postTitle.getText().contains("Selenium"));
			
		}
	
	}
	public boolean isPageLoadedSuccess() {
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery !=null) && (jQuery.active === 0);");
			}
		};
		
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
	
	
}
