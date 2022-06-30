package JavaBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Topic_05_Referrence_Casting {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student name = " + studentName);
	}
	
	public static void main(String[] args) {
		Topic_05_Referrence_Casting employeeOne = new Topic_05_Referrence_Casting();
		
		Topic_05_Referrence_Casting employeeTwo = new Topic_05_Referrence_Casting();
		
		employeeOne.setStudentName("Nguyen Van A");
		employeeTwo.setStudentName("Nguyen Van B");
		
		employeeOne.showStudentName();
		employeeTwo.showStudentName();
		
		// Ép kiểu
		employeeTwo = employeeOne;
		
		employeeOne.showStudentName();
		employeeTwo.showStudentName();		
		
		employeeTwo.setStudentName("Nguyen Van C");
		
		employeeOne.showStudentName();
		employeeTwo.showStudentName();	
		
		WebDriver driver = null;
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	}
	
}
