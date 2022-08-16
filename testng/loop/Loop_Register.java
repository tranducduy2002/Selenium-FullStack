package loop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Loop_Register {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    String projectPath = System.getProperty("user.dir");
    String emailAddress, userID, loginPasswords, loginUrl, genderOutput, customerName;
    String doBInput, doBOutput, addressInput, addressOutput, city, state, pinCode, phoneNumber;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();

        jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");
        loginUrl = driver.getCurrentUrl();
        emailAddress = "kusio" + generateRandomNumber() + "@gmail.com";

    }

    @Test(invocationCount = 3)
    public void Register(){
        driver.get(loginUrl);

        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
        loginPasswords = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

        System.out.println(userID);;
        System.out.println(loginPasswords);;

    }

    public int generateRandomNumber () {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}
