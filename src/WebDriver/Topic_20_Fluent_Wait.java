package WebDriver;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.base.Function;

public class Topic_20_Fluent_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	FluentWait<WebDriver> fluentDriver;
	
	FluentWait<WebElement> fluentElement;
	 
	
	
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
	
	public void TC_01_Fluent_Wait_Excersise() {
		
		
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
