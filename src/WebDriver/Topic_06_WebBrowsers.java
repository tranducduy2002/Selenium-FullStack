package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_06_WebBrowsers {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	

	@BeforeTest
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
			
		
	}
	

@Test // Test method
public void TC_01_Method() {
	driver.close(); //dùng để close browser/ tab, nếu như chỉ có 1 tabL close browser, nếu như nhiều hơn 1 tab: close tab đang active
	
	driver.quit(); // dùng để close browser không quan tâm số lượng tab xxxxxxxxxxxxxxxxxxxxxxx
	driver.get("url"); // dùng để mở url xxxxxxxxxxxxxx
	
	// ******************* Wait **************************
	driver.findElement(By.xpath("")); // để tìm 1 element xxxxxxxxxxxx
	driver.findElements(By.xpath("")); // để tìm nhiều elements  xxxxxxxxxxx
	
	driver.getCurrentUrl(); // để get url hiện tại
	
	driver.getPageSource(); // get ra source code HTML/ JS/ CSS của page hiện tại
	
	driver.getTitle(); // lấy ra title của page hiện tại
	
	//===================  Windows/ Tabs =============================
	driver.getWindowHandle(); // dùng để xử lý window/ tab: lấy ra ID của window/ tab đang active
	
	driver.getWindowHandles(); // lấy ra id của tất cả các tab mà window đang mở xxxxxxxxxxxxxx
	
	// ********************** Framework *********************
	driver.manage().deleteAllCookies();    // Cookie: lưu lại phiên đăng nhập/ session/ dữ liệu duyệt web / ...... (Framework có 1 bài học về save dữ liệu)
	
	// ********************* Framework - Log *****************
	driver.manage().logs().get("");
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Chờ cho findElement/ findElements xxxxxxxxxxxxxxxxxxxxx
	
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); // chờ cho 1 page load thành công 
	
	driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS); // chờ cho 1 đoạn code JavaScript được thực thi thành công: asynchronous script bất đồng bộ, synchronous đồng bộ
	
	driver.manage().window().fullscreen(); // full hết toàn màn hình
	driver.manage().window().maximize(); // mở rộng hết cửa sổ xxxxxxxxxxxxxxxxx
	
	// Set vị trí của browser so với độ phân giải màn hình 
	driver.manage().window().setPosition(new Point(100, 250)); // 
	driver.manage().window().getPosition();
	
	// Mở browser với kích thước là bao nhiêu => Test responsive 
	driver.manage().window().setSize(new Dimension(1920, 1080));
	driver.manage().window().getSize();
	
	// Tracking history tốt hơn get()
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	driver.navigate().to("https://facebook.com");
	
	
	//********************* Alert ************
	driver.switchTo().alert(); // xxxxxxxxxxxxxxx
	
	driver.switchTo().window(""); // Window /tab xxxxxxxxxxxx
	
	
	
}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
