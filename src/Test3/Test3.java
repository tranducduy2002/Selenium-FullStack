package Test3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test3 {
WebDriver driver;
String projectpath = System.getProperty("user.dir");

@BeforeClass
public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.manage().window().fullscreen();
	driver.get("https://duytran.online.sit.getzpass.com");
	
}


@Test
public void ValidateSelectStart( ) {
	Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='text-center intro-headtext-modal']")).isDisplayed());
}

@Test
public void SelectService( ) {
	System.setProperty("webdriver.chrome.driver","./browserDrivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.findElement(By.xpath("//h4[@img[@src='/Content/Images/custom/pumpkin/icon-pickup.svg']")).click();

}

@AfterClass
public void afterClass() {
	driver.quit();
}
}
