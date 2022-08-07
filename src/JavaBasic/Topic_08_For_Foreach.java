package JavaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Test
	public void TC_01_For() {
		int number = 100;
		for (int i = 0; i <= number; i++) {
			System.out.println(i);
		}
	
	
	
	// Array/ List/ Set/ Queue (Index)
	// i start = 0
	
	String[] cityNames = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong"};
	
	for (int i =0; i < cityNames.length; i++) {
		System.out.println(cityNames[i]);
	}
	
	// For kết hợp if : thỏa mãn điều kiện mới action
	// Biến đếm để thỏa mãn điều kiện filter
	for (int i =0; i < cityNames.length; i++) {
		if(cityNames[i].equals("Da Nang")) {
			System.out.println("Da Nang");
			break;
		}
	}
	
	// Dùng để chạy qua hết tất cả các giá trị
	for (String city : cityNames) {
		System.out.println(city);
	}
	
	// Kết hợp foreach và if => Không dùng
	int y = 0;
	for (String city : cityNames) {
		if (cityNames[y].equals("Da Nang")) {
			System.out.println(city);
			break;
		}
		y++;
	}
}

	
	
	@Test
	public void TC_02() {
	String[] cityNames = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong"};
	
	// Java Collection
	// Class: ArrayList / LinkedList/ Vector/ ...
	// Interface: List/ Set/ Queue
	List<String> cityAddress = new ArrayList<String>();
	System.out.println(cityAddress.size());

	// Compile
	cityAddress.add("Bac Kan");
	cityAddress.add("Bac Giang");
	cityAddress.add("Bac Ninh");

	System.out.println(cityAddress.size());

	// Runtime (Running)
	for (String city : cityNames) {
		cityAddress.add(city);
	}
	
	System.out.println(cityAddress.size());
	
	List<WebElement> links = driver.findElements(By.xpath("//a"));
	
	
	// Xử lý dữ liệu/ get text/ value/ css/ attribute
	for (WebElement link : links) {
		// Không được dùng để: 
		// Chuyển Page
		// Refresh DOM/ HTML
		// Không còn tồn đại element
		// Fail => StatElementException		
		}

	}
	
	
}