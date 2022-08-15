package tech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_05_Multiple_Browsers {
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

    @Test(dataProvider = "user_pass")
    public void TC_01_LoginToSystem(String username, String password) throws InterruptedException{
        driver.get("http://live.index.php/customer/account/login");
        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();

        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
        Thread.sleep(2000);

    }

    @DataProvider(name = "user_pass")
    public Object[][] UserAndPasswordData(){
        return new Object[][]{
                {"selenium_11_01@gmail.com", "111111"},
                {"selenium_11_02@gmail.com", "111111" },
                {"selenium_11_03@gmail.com", "111111"}};
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}
