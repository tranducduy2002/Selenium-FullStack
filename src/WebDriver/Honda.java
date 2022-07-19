package WebDriver;

public class Honda extends Car {
	
	public static void main(String[] args) {
		Honda honda = new Honda();
		honda.setCarName("Civic 2022");
		System.out.println(honda.getCarName());
	}
	// 1 class chỉ được phép kế thừa 1 class
	// 1 class có thể kế thừa nhiều interface
}
