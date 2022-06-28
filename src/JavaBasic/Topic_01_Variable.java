package JavaBasic;

public class Topic_01_Variable {
	String homePageUrl = ""; // Biến toàn cục
	static int studentNumber;
	static boolean status;
	static final String browserName = "Chrome";// constant
	static final String HANG_SO = "Firefox"; // constant
	
	String studentName = "Automation"; // Biến toàn cục
	
	static int studentPrice;
	
	public static void main(String[] args) {
		System.out.println(studentNumber);
		System.out.println(status);
		System.out.println(status);
		
		String homePageCurrentUrl = ""; // Biến cục bộ sử dụng trong phạm vi của block code
		
		// Blockcode
		if (status) {
			
		}
		
		int studentPrice = 5;
		System.out.println(studentPrice);
	
		/* This is comments on multiple rows
		 * 
		 * 
		 * 
		 * 
		 */
		
		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println(topic.studentName);
	}
	
	// Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ getPosition
	public String getStudentName() {
		return this.studentName;
	}
	
	// Setter: click/ SendKeys/ clear/ select/ back/ forward/ refresh/ get/ ...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
