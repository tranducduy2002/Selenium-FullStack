package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Thrird_Class {
    WebDriver driver;
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01(){
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();

        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
