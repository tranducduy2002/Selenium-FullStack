package Topic_01_Test2;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Test2 {
WebDriver driver;
String projectPath = System.getProperty("user.dir");

@BeforeClass
public void beforeClass() {

System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://demo.guru99.com/v4/");
}
 
@Test
public void TC_01_ValidateCurrentUrl() {
// Login Page Url matching
String loginPageUrl = driver.getCurrentUrl();
Assert.assertEquals(loginPageUrl, "https://demo.guru99.com/v4/");
}
 
@Test
public void TC_02_ValidatePageTitle() {
// Login Page title
String loginPageTitle = driver.getTitle();
Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
}
 
@Test
public void TC_03_LoginFormDisplayed() {
// Login form displayed
Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
}

@Test
public void TC_04_DescriptionDisplayed() {
	driver.findElement(By.xpath("//h4[@class='barone']/span")).getText();

		
}

@AfterClass
public void afterClass() {
	driver.quit();
}

}