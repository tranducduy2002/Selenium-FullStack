package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Java_Basic_While_DoWhile_Exercise {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);

    // @Test
    public void TC_01_Input_N() {
        int numberA = scanner.nextInt();
        System.out.print("Input number A:");
        while (numberA < 100) {
            System.out.println(numberA);
            numberA++;
        }
    }

    //@Test
    public void TC_02_Input_N() {
        int numberB = scanner.nextInt();
        int numberC = scanner.nextInt();

        while (numberB < numberC) {
            if (numberB % 3 == 0 || numberB % 5 == 0) {
                System.out.println(numberB);
            }
            numberB++;
        }
    }

    //@Test
    public void TC_03_Input_N() {
        int numberB = scanner.nextInt();
        int i = 0;
        while (numberB > 0) {
            if (numberB % 2 != 0) {
                System.out.println(numberB);
                i += numberB;
            }
            numberB--;
        }
        System.out.println(i);
    }

    @Test
    public void TC_04_Input_N() {
        int numberB = scanner.nextInt();
        int i = 1;
        while (numberB > 0) {
            i *= numberB;
            numberB--;
        }
        System.out.println(i);


    }

    public static void main(String[] args) {
    
    }
}

