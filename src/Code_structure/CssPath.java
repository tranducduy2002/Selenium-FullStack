package Code_structure;

public class CssPath {
  // http://live.techpanda.org/index.php/customer/account/login/
	// Xpath: //a[@title='Create an Account']/span/span
	// //input[@id='email']
	
	
	// CSS: a[title='Create an Account']>span>span
	// form[id='login-form'] a[title='Create an Account']>span>span
	// input[id='email'] hoặc input#email hoặc #email
	// ký tự đặc biêt hay dùng: > + . * $ #
	
	
	// Xpath: //p[@class='form-instructions']
	// CSS:   p[class='form-instructions'] hoặc p.form-instructions hoặc .form-instructions
	
	//Xpath: //input[@id='email' and @name='login[username]']
	// CSS: input[id='email'][name='login[username]'][title='Email Address']
	
	//Xpath: li[6]
	// CSS: li:nth-child(6)
	
	// li[1]
	// li:first-child
	
	// li[last]
	// li:last-child
	
	// Xpath://li[6]/following-sibling::li
	//  CSS single node: ol li:nth-child(6) + li
	//  CSS multiple nodes: ol li:nth-child(6) ~ li
	
	//Xpath: //a[contains(@title,'an Account')]
	// CSS: a[title*='an Account']
	
	//Xpath: //a[start-with(@title,'Create an')]
	// CSS: a[title^='Create an']
	
	//Xpath: End-with không hỗ trợ thay bằng contains
	// CSS: $=  ví dụ a[title$='ccount']
	
	// CSS Special characters:
	// #: id
	// .: class
	// *: contains
	// ^: start-with
	// $: end-with
	// +: following-sibling   (single node)
	// ~: following-sibling   (multiple nodes)
	// >: child node  (1 node)
	// space: sub-child (n nodes)
	// ,: or
	//[][]: and
	// :not([attribue='value'])  phủ định lại điều kiện   //input[not(@id='email')]   input:not([id='email'])
	
	
	// Xpath: contains có thể work với cả text nhưng CSS thì ko work với text
	// Xpath: có thể đi ngược lên nhưng CSS thì không thể đi lên được
	
	
	//Console: 
	// Count: 1. Nhập liệu vào các field cần verify => Get dữ liệu ra và kiểm tra bằng với các dữ liệu vừa nhập
	//  2. Click button Reset để xóa hết đi => Get dữ liệu ra và kiểm tra bằng empty
	//$(document.evaluate("//input[@id='email']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).value
	//$(document.evaluate("//input[@id='email']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).val()
	//$(document.evaluate("//input[@id='email']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).stringValue);
	//$(document.evaluate("//input[@id='email']",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).sstringValue).value()
	// $("input[id='email']").value
	// 'duy.tran@gmail.com'
	
	// cach 1: get element with fast loading icon => Netwrok => throttle => Slow -> Catch element
	// cach 2: debug tab Source => Pause when loading icon => back to Element tab => catch element
	// cach 3: vào Source => add new Snipset => tạo file Debug =>  setTimeout(() => {debugger;}, 4000); => Save => press Play => hover or click loading icon
	
	
	
	
	
	
	
	
	
	
}
