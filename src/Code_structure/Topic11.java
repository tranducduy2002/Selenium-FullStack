package Code_structure;

public class Topic11 {
	
	public static void main(String[] args) {
	boolean answerPersonA;
	boolean answerPersonB;

	
	// AND
	answerPersonA = true;
	answerPersonB = false;
	System.out.println("1. A && B =" + (answerPersonA && answerPersonB));
	System.out.println("1. A && B =" + (answerPersonA || answerPersonB));

	// Phủ định
	//li[not(contains(@class,'ui-selected'))]
	
	boolean answerPersonC = true;
	System.out.println(answerPersonC);
	System.out.println(!answerPersonC);
	
	// https://automationfc.github.io/jquery-selectable/
	//li[last()]
	
	// Các thẻ mình đang cần lấy đều nằm trong 1 thẻ cha đểu có thể index trực tiếp
	// ex: https://automationfc.github.io/jquery-selectable/ //li[6]
	// inside parent //span[text()='Add to Cart'][1] => ra kết quả đầu của mỗi parent
	// inside parent //span[text()='Add to Cart'][2] => không ra kết quả do không có thêm node 2 của parent
	// inside parent (//span[text()='Add to Cart'])[1] => kết quả 1
	// inside parent (//span[text()='Add to Cart'])[2] => kết quả 2

	
	// https://www.amazon.com/s?bbn=16225007011&rh=n%3A16225007011%2Cn%3A172456&dc&qid=1652536779&rnid=16225007011&ref=lp_16225007011_nr_n_0
	// //div[contains(@class,'s-main-slot')]//div[@data-component-type='s-search-result'][last()];
	// //div[contains(@class,'s-main-slot')]//div[@data-component-type='s-search-result'][position()=24];
	
	// Bản thân nó không thể định danh nó là duy nhất được mà nó cần các mối quan hệ xung quanh:
	// ancestor - child
	// parent - child
	// self - older brother (preceding-sibling)
	// self - younger brother (following-sibling)
	// self - descendant (cháu)
	// self - child
	
	// http://live.techpanda.org/index.php/mobile.html
	// //a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/button[@title='Add to Cart']
	// => không cần dùng index vẫn lấy được
	// => nếu như vị trí của item có thay đổi vẫn lấy được
	// tên IPhone là bất biến => ổn định để tham chiếu tới và lấy Add to Cart
	
	
	}

}