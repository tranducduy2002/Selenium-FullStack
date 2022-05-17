package Code_structure;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Structure {
	//Khai báo biến driver đại diện cho Selenium Driver
WebDriver driver;
String projectPath = System.getProperty("user.dir");

@BeforeClass
public void beforeClass() {
	
//Set up môi trường cho geckodriver để giao tiếp giữa browser và code
System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

//Bật trình duyệt Firefox
driver = new FirefoxDriver();

//Đặt thời gian để tìm element
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//Mở cửa sổ browser tối đa (to nhất)
driver.manage().window().maximize();

//Truy cập trang web cần test
driver.get("https://demo.guru99.com/v4/");
}

@Test
public void Structures() {
	//Css
	//Xpath (learn)
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
	driver.findElement(By.xpath("//h4[@class='barone']/span[text()='Steps To Generate Access']"));
	driver.findElement(By.name("uid")).sendKeys("duy@g.com");
		
}

@Test
public void AutoPractsite() {
	driver.get("http://automationpractice.com/index.php");
	driver.findElement(By.xpath("//span[text()='Total']/preceding-sibling::span")).getText();
}

@Test
public void PacktPub() {
	driver.findElement(By.xpath("//div[@class='product-title mb-3']/ancestor::*[contain(@class,'body')]/child::*/following-sibling::*"));

}

}

