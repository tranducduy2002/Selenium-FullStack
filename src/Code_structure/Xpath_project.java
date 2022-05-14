package Code_structure;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Xpath_project {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// Hàm này sẽ áp dụng cho việc tìm element (findElement/ findElements) set 1 lần duy nhất ở đây
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@Test
	public void TC_01() {
		// TÌm (Find) - số ít - trả về 1 cái
		// Thao tác trực tiếp ko khai báo biến - sử dụng 1 lần/ ko dùng lại element này
		driver.findElement(By.id("")).clear();
		driver.findElement(By.id("")).click();
		driver.findElement(By.id("")).isDisplayed();// 3 thao tác => ko tối ưu
		
		// Khai báo biến, có thể dùng lại element nhiều lần => khai báo biến
		WebElement loginButton = driver.findElement(By.id(""));
		loginButton.clear();
		loginButton.click();
		loginButton.isDisplayed();
		
		// TÌm (Finds) - số nhiều - trả về 1 hoặc lớn hơn 2
		driver.findElements(By.id("")).size(); // đếm số lượng 
		
		// Lặp lại nhiều lần (click vào nhiều checkbox) => khai báo biến
		List<WebElement> loginCheckboxes = driver.findElements(By.id(""));
		
		for (int i = 0; i < loginCheckboxes.size(); i++) {
			loginCheckboxes.get(i).click(); // tick vào toàn bộ các checkboxes
		}
		
		// Thao tác (Action): click/ type/ select/ hover/ .....
	

		// Kiểm tra (Verify/ Assert):getText/ getAttribute/ getCss/ ....
		
		// Thao tác với Email textbox
		
		
		// Tháo tác với Password textbox
		
		
		// Thao tác login
		driver.findElement(By.xpath("//input[@id='newsletter]"));
		driver.findElement(By.xpath("//input[@id=\"newsletter"));
		// JAVA: "" đại diện cho 1 chuỗi (String)
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='footer']")).getText(),"My Account");
		//div[starts-with(@class,'page-title')]	
		// //span[text()='Hello "John", What's happened?'] => sai
		// //span[text()="Hello "John", What's happened?"] => sai
		// concat nối 2 chuỗi với nhau
		// //span[text()=concat('Hello "John", What',""'s happened?"] nháy đơn thay bằng nháy đôi và nháy đôi thay bằng nhấy đơn
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
