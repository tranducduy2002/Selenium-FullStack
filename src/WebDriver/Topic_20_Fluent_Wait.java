package WebDriver;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import net.bytebuddy.asm.Advice.Local;

public class Topic_20_Fluent_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	FluentWait<WebDriver> fluentDriver;
	
	FluentWait<WebElement> fluentElement;
	private long sumTime = 30;
	private long pollTime = 1;
	
	
	@BeforeClass
	public void beforeClass () {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver");
		} else {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}
		driver = new EdgeDriver();
	
	}
	
	
	public void TC_01_Fluent_Wait() {
		// Find Element với tổng thời gian là 15s
		// Tần số lặp lại để tìm nếu không thấy là 1s/ 1 lần
		fluentDriver.withTimeout(Duration.ofSeconds(15))
		// Polling time: lặp lại để tìm điều kiện nếu như chưa thỏa mãn
		.pollingEvery(Duration.ofSeconds(1))
		// Nếu gặp exception là find không thấy element sẽ bỏ qua
		.ignoring(NoSuchElementException.class)
		
		// Điều kiện
		.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@name='btnI-fail']"));
			}
		});
		
		// =======================================**======================
		WebElement loginButton = driver.findElement(By.xpath(""));
		
		fluentElement = new FluentWait<WebElement>(loginButton);
		
		// Setting Time
		fluentElement.withTimeout(Duration.ofSeconds(15))
		.pollingEvery(Duration.ofSeconds(1))
		.ignoring(ElementNotVisibleException.class);
		
		// Apply điều kiện và trả về String
		String loginButtonText = fluentElement.until(new Function<WebElement, String>(){
			public String apply(WebElement element) {
				return element.getText();
			}
			
		});
		
		Assert.assertEquals(loginButtonText, "");
		
		// Apply điều kiện trả về kiểu boolean
		boolean loginButtonStatus = fluentElement.until(new Function<WebElement, Boolean>(){
			public Boolean apply(WebElement element) {
				return element.isDisplayed();
			}
			
		});
		
		Assert.assertTrue(loginButtonStatus);
	}
	
	@Test
	public void TC_01_Fluent_Wait_Excersise() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		fluentDriver = new FluentWait<WebDriver>(driver);
		
		driver.findElement(By.cssSelector("div#start button")).click();
		
		fluentDriver.withTimeout(Duration.ofSeconds(15))
		.pollingEvery(Duration.ofSeconds(1))
		.ignoring(NoSuchElementException.class)
		.until(new Function<WebDriver, Boolean>(){
		public Boolean apply(WebDriver driver) {
			boolean textStatus = driver.findElement(By.cssSelector("div#finish h4")).isDisplayed();
			System.out.println(textStatus);
			return textStatus;					
		}
		});
	}
	
	
	@Test
	public void TC_02_Fluent_Wait_Excersise_WithFunction() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		fluentDriver = new FluentWait<WebDriver>(driver);
		
		clickToElement(By.xpath("//div[@id='start']/button"));
		isElementDisplayed(By.xpath("//div[@id='finish']/h4"));
		
	}
	public WebElement findElement(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sumTime)).pollingEvery(Duration.ofSeconds(pollTime))
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}
	
	public void clickToElement(By locator) {
		WebElement element = findElement(locator);
		element.click();
	}
	
	public WebElement waitElementVisible(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sumTime)).pollingEvery(Duration.ofSeconds(pollTime))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
								
	}
	
	public boolean isElementDisplayed(By locator) {
		WebElement element = waitElementVisible(locator);
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element).withTimeout(Duration.ofSeconds(sumTime)).pollingEvery(Duration.ofSeconds(pollTime))
				.ignoring(NoSuchElementException.class);
		boolean isDisplayed = wait.until(new Function<WebElement, Boolean>(){
			public Boolean apply(WebElement element) {
				boolean flag = element.isDisplayed();
				return flag;
			}
		});
		return isDisplayed;
	}
	
	public String getCurrentTime() {
		Date date = new Date();
		return date.toString();
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
