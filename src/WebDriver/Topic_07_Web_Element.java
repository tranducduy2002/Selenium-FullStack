package WebDriver;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Element {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Define_Element() {
		// Muốn thao tác được với Element thì phải mình phải tìm elemment trước
		// Sau đó mới áp dụng hành vi vào cho Element đó
		
		// 1- Tìm element
		// 2- Với loại locator gì
		// 3- Tương tác lên/ kiểm tra nó
		
		// Muốn thao tác trực tiếp lên element thì không cần khai báo biến
		driver.findElement(By.id(""));
		
		// Thao tác từ 2 lần trở lên thì cần khai báo biến để tránh việc lặp lại
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("email")).isDisplayed();
		
		WebElement emailTextBox = driver.findElement(By.id("email"));
		emailTextBox.clear();
		emailTextBox.sendKeys("");
		emailTextBox.isDisplayed();
			
	}

	@Test
	public void TC_02_Element_Method () {
		WebElement element = driver.findElement(By.id(""));
		
		// Xóa dữ liệu trong những field cho phép nhập
		// Luôn luôn clear hết dữ liệu trước khi thao tác trên field đó
		// Textbox/ TextArea/ Editable Dropdown
		element.clear();  // xxxxxxxxxx
		
		// Nhập dữ liệu 
		element.sendKeys(""); // xxxxxxxxxx
		element.sendKeys(Keys.ENTER); // xxxxxxxxxx
		
		// Element cha: findElement(By.className("footer")
		// Element tiếp theo của con: findElement(By.cssSelector("a[title='My Account']"))
		driver.findElement(By.className("footer")).findElement(By.cssSelector("a[title='My Account']"));
		
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		
		driver.findElement(By.id("Search")).getAttribute("placeholder");
		// Search entire store here...         (http://live.techpanda.org/index.php/customer/account/login/)
		
		// Không khai báo biến, verify trực tiếp
		Assert.assertEquals(driver.findElement(By.id("Search")).getAttribute("placeholder"), "Search entire store here...");  // xxxxxxxxxx
		
		
		// Khai báo biến để dùng nhiều lần
		WebElement searchTextBoxPlaceHolderValue = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		Assert.assertEquals(searchTextBoxPlaceHolderValue, "Search entire store here...");
		
		// GUI: Font Type/ Font size/ Color/ Pixel ...... 
		element.getCssValue("background-color"); // RGB(149, 246, 6)  // xxxxxxxxxx
		element.getCssValue("font-size"); // 13px  // xxxxxxxxxx
		
		// GUI: Position/ Location/ Size of element
		element.getLocation();
		element.getRect();
		element.getSize();
		
		
		// Framework: Attach screenshot to Report HTML
		element.getScreenshotAs(OutputType.FILE);  // xxxxxxxxxx
		
		
		element = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']"));
		element = driver.findElement(By.cssSelector("div[id='advice-validate-email-email']"));
		
		element = driver.findElement(By.cssSelector("#advice-validate-email-email"));
		String emailTextBoxTagName = element.getTagName(); // Output của element này sẽ là input của element khác
		
		// Truyền 1 biến vào trong 1 chuỗi
		driver.findElement(By.xpath("//" + emailTextBoxTagName + "[@id='advice-validate-email-email']"));
		// Chuỗi thứ 1 + biến + chuỗi thứ 2
		
		// Lấy ra text của element hiện tại hoặc của những element con bên trong
		element.getText(); // xxxxxxxxxx
		
		// Mong muốn 1 element hiển thị/ không hiển thị
		// Hiển thị: Người dùng nhìn thấy được chiều rộng/ chiều cao
		// Áp dụng cho tất cả các loại Element: textbox/ text area/ dropdown/ checkbox/ radio/ button .... 
		element.isDisplayed(); // xxxxxxxxxx
		
		// Mong muốn 1 element có thể thao tác được lên hoặc không
		// Ngược lại với disable
		// Thao tác được: Enabled
		// Không thao tác được: Disable
		// Áp dụng cho tất cả các loại Element: textbox/ text area/ dropdown/ checkbox/ radio/ button .... 
		element.isEnabled(); // xxxxxxxxxx
		
		// Mong muốn 1 element được chọn hay chưa
		// Áp dụng cho tất cả các loại Element: dropdown/ checkbox/ radio button .... 
		element.isSelected(); // xxxxxxxxxx
		
		// click vào 1 element
		// Button/ link/ checkbox/ radio/ image/ icon .....
		element.click();  // xxxxxxxxxx
		
		// Hành vi giống Enter ở các form (tagname là form)
		// Dùng cho tagname: form
		element.submit();
		
		
		// Slide: giữ chuột => kéo button
		// Sau đó kéo Slider này 1 tọa độ bao nhiêu pixel
		// Hoặc kéo tới 1 element khác
		// không nằm trong WebDriver và WebElement
		// Nằm trong thư viện Actions

		action.clickAndHold(element).moveToElement(element).perform();
		
		
		
		// text() trong Xpath sẽ lấy text dưới HTML
		// getText() trong WebElement thì sẽ lấy text ở trên UI
		
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
