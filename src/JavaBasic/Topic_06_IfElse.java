package JavaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_06_IfElse {

	public static void main(String[] args) {
		boolean status = 5 > 3;
		System.out.println(status);
		
		// Hàm if sẽ nhận vào 1 điều kiện đúng
		if (status) {
			// Đúng thì vào phần thân của if
			// Sai thì bỏ qua
			System.out.println("Go to if");
			
		}
		
		WebDriver driver = new FirefoxDriver();
		
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}
		
		// Element không có trong DOM khi popup không hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		//	Check element không hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
			
		}
	}
}
