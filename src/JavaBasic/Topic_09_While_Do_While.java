package JavaBasic;


import org.openqa.selenium.WebDriver;

public class Topic_09_While_Do_While {
    WebDriver driver;

    // Function
    public static void main(String[] args) {
        int i = 0;

        for (i = 0; i < 5; i++) {
            System.out.println("For: " + i);
            if (i == 3) {
                break;
            }
        }

        // i = 5 không thỏa mãn điều kiện của while
        while (i < 5) {
            System.out.println("While: " + i);
            i++;
            if (i == 3) {
                break;
            }
        }

        // Chạy ít nhất 1 lần rồi mơ kiểm tra điều kiện
        do {
            System.out.println("Do While: " + i);
            i++;
        } while (i < 5);

    }
}
