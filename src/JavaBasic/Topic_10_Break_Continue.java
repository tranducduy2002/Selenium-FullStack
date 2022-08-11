package JavaBasic;

import org.testng.annotations.Test;

public class Topic_10_Break_Continue {

    @Test
    public void TC_01_Break() {
        for (int i = 0; i < 5; i++) {
            System.out.println("For thứ nhất: " + i);
            break;
        }
    }

    @Test
    public void TC_02_Continue() {
        for (int j = 0; j < 6; j++) {
            System.out.println("For thứ hai: " + j);
            for (int n = 0; n <= 5; n++) {
                if (n == 4) {
                    continue;
                }
                System.out.println("For thứ ba: " + n);
            }

        }
    }
}
