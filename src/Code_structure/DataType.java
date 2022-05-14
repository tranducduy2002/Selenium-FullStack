package Code_structure;

public class DataType {

	public static void main(String[] args) {
		// Khai báo biến: Kiểu dữ liệu + Tên biến: viết thường từ đầu tiên, từ tiếp theo sẽ viết hoa chữ đầu tiên
		//int studentNumber;
		
		// Khởi tạo dữ liệu
		//studentNumber = 100;
		
		// Khai báo + khởi tạo
		int teacherNumber = 20;
		
		// boolean
		boolean studentSex= true;
		
		// byte
		byte bEmplopyee = 10; // not used
		
		// short
		short sEmployee = 10; // not used
		
		// int
		int iEmployee = 10;
		
		// long
		long lEmployee = 1000;
		
		// float
		float fEmployee = 7.5f;
		
		// double
		double dEmployee = 8.5d;
		
		// char 1 ký tự
		char abb = 'B'; // not used
		
		// Kiểu dữ liệu
		
		// I> Nguyên thủy - Primitive type: 8 loại
		// 1. boolean: luận lý/ logic => 2 giá trị (true/ false)
		
		// 2. Số nguyên: không có phần thập phân:
		// byte
		// short
		// int
		// long
		
		
		// 3. số thực: có phần thập phân:
		// float
		// double
		
		// 4. kiểu ký tự:
		// char
		
		
		// II> Tham chiếu - Reference type
		// Array
		//int[] studentNumbers = {15, 50, -7, 19};
		//String[] studentNames = {"Nguyễn Văn Nam", "Ngô Văn Tới"};
		
		// Class / Interface
		// => WebDriver driver = new ChromeDriver(); // Interface
		// => Actions action = new Actions(driver); // Class
		
		// Collection: List (ArrayList/ LinkedList)/ Set/ Queue
		// => ArrayList<String> studentCountry = new ArrayList<String>;
		
		// Object
		//Object phone;

		// chuỗi ký tự: số/ chữ /ký tự đặc biệt
		String a = "Hoang";
		System.out.println(a);
		
		String b = a;
		System.out.println(a);
		System.out.println(b);
		
		b = "An";
		a = b;
		System.out.println(a);
		System.out.println(b);
	
		
		//String studentName = "B";
		//String companyName = "Cong Ty TNHH 1 thanh vien @ Copyright 2022";
				
		// 
	}
	
}
