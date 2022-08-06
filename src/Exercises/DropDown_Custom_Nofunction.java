package Exercises;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown_Custom_Nofunction {

	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		// Luôn khởi tạo sau driver => vì cần giá trị drivẻ để khởi tạo explicitWait lên
		// Wait cho các element theo điều kiện có sẵn: visible/ invisible/ presence/ clickable ....
		explicitWait = new WebDriverWait(driver,15);
		
		// Wait cho việc tìm element: findelement/ findElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
	}

	@Test
	public void TC_01() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		// 1. Click vào dropdown cho sổ hết tất cả các item con bên trong ra => click
		driver.findElement(By.id("number-button")).click();
		
		// 2. Chờ cho tất cả các item con bên trong được load ra => WebDriverWait
			// By locator = đại diejn cho tất cả các item con bên trong
			// Lấy cái locator đến cái thẻ chưa text item
			// Case 1: Click step 1 ở trên xong => Xổ ra nó load hết ra luôn => không cần wait
			// Case 2: dữ liệu nhiều thì nó load vài nghĩn record => lâu
			// Chưa lấy ra hết item thì chưa chọn được 
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu>li>div")));
				
		// 3. Tìm item mong muốn (nếu như không hiển thị thì cần cuộn chuột xuống để tìm) => Vòng lặp để lấy hết tất cả item rồi duyệt qua - getText từng cái
			// Khai báo từng elemtn thì rất là nhiều
			// Lấy hết tất cả các item ra lưu vào 1 List Elements
		List<WebElement> allDropdownItems = driver.findElements(By.cssSelector("ul#number-menu>li>div"));
		
		// Duyệt qua gọn: vòng lặp
		for (WebElement item : allDropdownItems) {
			String actualTextItem = item.getText();
			
			// 4. Thấy item cần chọn thì click vào => So sánh với item mong muốn sau đó Click vào
			if (actualTextItem.equals("5")) {
				item.click();
				// Thoát ra khỏi vòng lặp (6-19)
				break;
			}
			
		}
		
		
		// 5. Item này sẽ đổ dữ liệu vào dropdown này => Verify chọn thành công
	
	}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
}
