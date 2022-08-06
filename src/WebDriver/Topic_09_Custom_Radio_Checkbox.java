package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Custom_Radio_Checkbox {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		jsExecutor = (JavascriptExecutor) driver;
	}

	@Test
	public void TC_01_CustomCheckBoxandRadioButton() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		
		// Hàm isSelected() chỉ work với loại element là checkbox/ radio/ radio (phải là thẻ input)
		
		// Case 1:
		// Thẻ input không click được
		// Thẻ input dùng verify được => Failed
		// driver.findElement(By.xpath("//span[text()='\"Checked\"']/preceding-sibling::span/input")).click();
		
		// Case 2:
		// Không dùng thẻ input để click => Passed
		// Không dùng thẻ input để verify => Failed
		//By checkedCheckbox= By.xpath("//span[text()='Checked']");
		//driver.findElement(checkedCheckbox).click();
		//sleepInMiliSecond(3000);
		//Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
		
		
		// Case 3
		// Không dùng thẻ input để click => Passed
		// Thẻ input dùng để verify được => Passed 

		// Vấn đề: 1 element mà phải define tới 2 locator/ by
		// Maintain code nó sẽ sinh ra nhiều phụ thuộc
		//	By checkedCheckboxText= By.xpath("//span[text()='Checked']");
		// driver.findElement(checkedCheckboxText).click();
		// sleepInMiliSecond(3000);
		// By checkboxChecked = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
		// Assert.assertTrue(driver.findElement(checkboxChecked).isSelected());
		
		// Case 4: Thỏa mãn hết điều kiện (vừa click vừa verify được)
		// Không dùng thẻ input để click => Passed (JavascriptExecutor)
		// JavascriptExecutor: không quan tầm element bị che hay không (vẫn click được)
		// Thẻ input dùng để verify được => Passed 
		By checkboxChecked = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkboxChecked));
		Assert.assertTrue(driver.findElement(checkboxChecked).isSelected());
		
		
		By beforeRadio = By.xpath("//span[text()='Before']/preceding-sibling::span/input");
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(beforeRadio));
		Assert.assertTrue(driver.findElement(beforeRadio).isSelected());
	}
	
	@Test
	public void TC_02_GoogleDocs() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		// Radio
		By hanoiRadio = By.xpath("//div[@aria-label='Hà Nội']");
		driver.findElement(hanoiRadio).click();
		sleepInMiliSecond(3000);
		
		Assert.assertEquals(driver.findElement(hanoiRadio).getAttribute("aria-checked"), "true");
		
		
		
		// Checkbox
		By miquangCheckbox = By.xpath("//div[@aria-label='Mì Quảng']/parent::div");
		driver.findElement(miquangCheckbox).click();
		sleepInMiliSecond(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Mì Quảng']")).getAttribute("aria-checked"), "true");
		
	}
	

	public void sleepInMiliSecond(long timeInMiliSecond) {
	try {
		Thread.sleep(timeInMiliSecond);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
}
