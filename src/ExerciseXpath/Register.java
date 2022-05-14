package ExerciseXpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@Test
	public void Register_01_EmptyData() {
		// Mở app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// Click vào button Đăng Ký
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Kiểm tra message lỗi hiển thị ở các field bắt buộc
		driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText();
		
		// Kiểm tra 1 điều kiện trả về là đúng
		//Assert.assertTrue(true);
		
		// Kiểm tra 1 điều kiện trả về là sai
		//Assert.assertFalse(true);
		
		// Kiểm tra 1 điều kiện trả về là bằng tới điều kiện mong muốn
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
		
	}
	

	@Test
	public void Register_02_InvalidEmail() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Duy Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("duy.tran@@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("12345678");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
		
		
	}

	@Test
	public void Register_03_IncorrectConfirmEmail() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Duy Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("duy.tran@gmai.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("12345678");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
	}

	@Test
	public void Register_04_PasswordsBelow6Characters() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Duy Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("12345");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void Register_05_IncorrectConfirmPassword() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Duy Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("1234567");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void Register_06_InvalidPhoneNumber() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Duy Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("duy.tran@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("12345678");
		driver.findElement(By.id("txtPhone")).sendKeys("098765432");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
