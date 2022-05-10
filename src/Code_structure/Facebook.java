package Code_structure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Facebook {
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
		driver.get("https://facebook.com");
	}
	
	@Test
	public void Strutures() {
		//Email Address textbox (HTML)
		//ElementL tage name + attribute name + attribute value
		//<input type="text" class="inputtext_55r1_6luy" name="email"
		//id="email" data-testid="royal_email" placeholder="Email address or phone number"
		// autofocus="1" aria-lable="Email address or phone number">
		
		//Selenium has 8 locator types
		//Id
		driver.findElement(By.id("email")).sendKeys("duy@gmail.com");
		
		//Class
		//<img class="fb_logo_8ilh img"
		// src="https://static.xxfbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg alt="Facebook">
		driver.findElement(By.className("fb_logo")).isDisplayed();
		
		//Name
		driver.findElement(By.name("email")).isDisplayed();
		
		//TagName
		driver.findElement(By.tagName("a"));
		
		//Link Text
		driver.findElement(By.linkText("Tiếng Việt"));		
		
		//Partial Link Text
		driver.findElement(By.partialLinkText("Tiếng Việt"));
		driver.findElement(By.partialLinkText("iếng Việ"));
		driver.findElement(By.partialLinkText("Việt"));
		driver.findElement(By.partialLinkText("Tiếng"));
		
		//Css
		driver.findElement(By.cssSelector("input[id='email']"));
		driver.findElement(By.cssSelector("input#email"));
		driver.findElement(By.cssSelector("#email"));
		
		driver.findElement(By.cssSelector("img[class='fb_logo 8ilh img']"));
		driver.findElement(By.cssSelector("img.fb_logo"));
		driver.findElement(By.cssSelector(".fb_logo"));
		
		driver.findElement(By.cssSelector("input[name='email']"));
		
		driver.findElement(By.cssSelector("a"));
		
		//Css does not work with text (use different element of tag a to operate)
		driver.findElement(By.cssSelector("a[title='Vietnamese']"));
		driver.findElement(By.cssSelector("a[onclick*='vi_VN']"));
		driver.findElement(By.cssSelector("a[title*='Vietnam']"));
				
		
		//Xpath
		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//img[@class='fb_logo 8ilh img']"));
		driver.findElement(By.xpath("img[contain(@class,'fb_logo']"));
		driver.findElement(By.xpath("//img[start-with(@class,'fb_logo']"));
		driver.findElement(By.xpath("//input[@name='email']"));
		driver.findElement(By.xpath("//a"));
		driver.findElement(By.xpath("//a[text()='Vietnamese']"));
		driver.findElement(By.xpath("//a[contain(text(),'Tiếng Việt']"));
		driver.findElement(By.xpath("//a[contain(text(),'Tiếng']"));
		

	}
}

