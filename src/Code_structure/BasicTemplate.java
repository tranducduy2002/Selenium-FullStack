package Code_structure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicTemplate {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		
		String titleCreateAccount = driver.findElement(By.cssSelector("div.page-title h1")).getText();
		System.out.println(titleCreateAccount);
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
