package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_1_Assert {
	WebDriver driver;
	
	@Test
	public void Assert_01 () {
		// 3 Hàm assert hay dùng
		// Kiểm tra tính đúng đắn của dữ liệu
		
		// 1- Kiểm tra dữ liệu mình mong muốn là ĐÚNG
		// Email textbox hiển thị
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
				
		// 2- Kiểm tra dữ liệu mong muốn là SAI
		Assert.assertFalse(driver.findElement(By.id("email")).isDisplayed());
		
	
		// 3- Kiểm tra dữ liệu mong muốn với dữ liệu thực tế là BẰNG NHAU
		
		// TUYỆT ĐỐI: 2 cái bằng nhau
		Assert.assertEquals(driver.findElement(By.id("Search")).getAttribute("placeholder"), "Search entire store here...");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		
		
		// TƯƠNG ĐỐI
		String benefitText = driver.findElement(By.cssSelector("ul.benefits")).getText();
		Assert.assertTrue(benefitText.contains("Faster checkout"));
		Assert.assertTrue(benefitText.contains("Save multiple shipping address"));
		Assert.assertTrue(benefitText.contains("View and track orders and more"));
		
		
		
	}
	
}
