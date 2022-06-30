package JavaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_DataType {
	// Global variable
	static int  number;
	
	// Primitive type/ value type: nguyên thủy
	
	byte bNumber;
	
	short sNumber;
	
	long lNumber;
	
	float fNumber = 15.98f;
	
	double dNumber = 15.98d;
	
	char cCharacter;
	
	boolean trueorFalse = false;
	
	
	// Referrence Type: Tham chiếu
	// String
		String address = "Ha Noi";
	
	// Array
		String[] studentAddress = {address, "Ha Noi", "Da Nang"};
		Integer[] studentumber = {15, 20, 25};
		
	// Class
		Topic_02_DataType topic;
		
	// Interface
		WebDriver driver;
		
	// Object
		Object aObject;
		
	// Collection
	// List/ Set/ Queue/ Map
		List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
		
		Set<String> allWindows = driver.getWindowHandles();
		
		List<String> productName = new ArrayList<String>();
		
		public void clickToElement() {
			address.trim();
			
			studentAddress.clone();
			
			driver.getCurrentUrl();
			
			aObject.toString();
			
			homePageLinks.size();
			
			allWindows.clear();
			
			Topic_02_DataType topic = new Topic_02_DataType();
			
			topic.address = "Hue";
			
			
		}
		
		
		
	
}
