package JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Topic_Eclipse_IDE {
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.out.println();
		
		WebElement loginButton = driver.findElement(By.xpath(""));
		WebElement nameTextBox = driver.findElement(By.cssSelector(""));
		
		Assert.assertTrue(false);
	}
}
