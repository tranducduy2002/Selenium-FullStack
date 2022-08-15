package tech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_05_Multiple_Servers {
    WebDriver driver;
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");
    String projectPath = System.getProperty("user.dir");

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        switch (browserName){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Parameters("server")
    @Test
    public void TC_01_LoginToSystem(@Optional("LIVE") String serverName) throws InterruptedException{
        serverName = getServerUrl(serverName);
        driver.get("http://" + serverName +"/index.php/customer/account/login");
        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();

        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
        Thread.sleep(2000);
    }
    private String getServerUrl(String serverName){
        switch (serverName){
            case "LIVE":
                serverName = "live.techpanda.org";
                break;
            case "TESTING":
                serverName ="testing.techpanda.org";
                break;
            case "STAGING":
                serverName = "staging.techpanda.org";
                break;
        }
        return serverName;
    }

       @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
