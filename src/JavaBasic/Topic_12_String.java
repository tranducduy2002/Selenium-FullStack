package JavaBasic;

import org.openqa.selenium.Keys;

public class Topic_12_String {

    public static void main(String[] args){
       String schoolName = "Automation Testing";
       String courseName = schoolName.toLowerCase();

       String schoolAddress = "Ho Chi Minh City";

       System.out.println(schoolName.length());
       System.out.println("Lấy ra 1 ký tự: " + schoolName.charAt(0));
       System.out.println("Nối 2 chuỗi: " + schoolName.concat(schoolAddress));
       System.out.println("Nối 2 chuỗi: " + schoolName + schoolAddress);
       System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối: " + schoolName.equalsIgnoreCase(schoolAddress));
       System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối: " + schoolName.equals(schoolAddress));
       System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối: " + schoolName.equals("Ho Chi Minh City"));
       System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự: " + schoolName.startsWith("Automation"));
       System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự: " + schoolName.startsWith("T"));
       System.out.println("Có chứa bằng 1 ký tự/ chuỗi ký tự: " + schoolName.contains("Automation"));
       System.out.println("Có chứa bằng 1 ký tự/ chuỗi ký tự: " + schoolName.contains("Testing"));
       System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự: " + schoolName.endsWith("Testing"));
       System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự: " + schoolName.indexOf("utomation"));
       System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự: " + schoolName.indexOf("Automation"));
       System.out.println("Vị trí của 1 ký tự/ chuỗi ký tự: " + schoolName.indexOf("Testing"));
       System.out.println("Tách 1 ký tự/ chuỗi ký tự trong chuỗi: " + schoolName.substring(11));
       System.out.println("Tách 1 ký tự/ chuỗi ký tự trong chuỗi: " + schoolName.substring(11, 15));

        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        String productPrice = "$100";
        productPrice = productPrice.replace("$", "");
        System.out.println(productPrice);

        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        productPrice = String.valueOf(productPriceF);
        System.out.println(productPrice);

        String osName = System.getProperty("os.name");
        System.out.println(osName);

        if (osName.toLowerCase().contains("windows")){
            Keys key = Keys.CONTROL;
        } else {
            Keys key = Keys.COMMAND;
        }

        String helloWorld = "  \n  \t  Hello World!         ";
        System.out.println(helloWorld);
        System.out.println(helloWorld.trim());

        helloWorld = " ";
        System.out.println("Empty = " + helloWorld.isEmpty());
        System.out.println("Empty = " + helloWorld.isBlank());

        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println("Click to Login button: " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
        System.out.println("Click to Search button: " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
        System.out.println("Click to Register button: " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));

    }


}
