package MP_and_Logs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Get_Paid_Date_ForPOS {
    WebDriver driver;
    String accountName = "";
    String password = "";
    By selectStore = By.xpath("//select[@name='dinein_outletIndex']");
    By selectOrderType = By.xpath("//select[@name='DineInSortByTypeKey']");
    By startDate = By.xpath("//input[@id='dtpStartDinein']");
    By endDate = By.xpath("//input[@id='dtpEndDinein']");
    By spinIconOrders = By.xpath("//div[@class='loading']/i");
    By pagingTotalCount = By.xpath("//span[contains(@class,'table-paging-total')]");

    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 15);

    }

    @Test
    public void GetOrderCode(){
        driver.get("https://sit.merchant.getz.co/");
        driver.findElement(By.xpath("//a[text()='Login as employee']")).click();
        driver.findElement(By.cssSelector("input#BusinnessEmployee")).sendKeys("Uncle Leong Signatures");
        driver.findElement(By.cssSelector("input#UserName")).sendKeys(accountName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#btnLogin")).click();

        driver.get("https://merchant.getz.co/Product#/orders/2");
        driver.findElement(selectStore).click();
        driver.findElement(By.xpath("//select[@name='dinein_outletIndex']//option[text()='Uncle Leong Signatures (Hougang)']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(spinIconOrders));

        driver.findElement(selectOrderType).click();
        driver.findElement(By.xpath("//select[@name='DineInSortByTypeKey']//option[text()='POS']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(spinIconOrders));

       /* // If want to change year
        driver.findElement(By.xpath("//div[contains(@class,'bootstrap-datetimepicker')]//th[@title='Select Month']"))*/

        driver.findElement(startDate).click();
        // Select date for current month
        driver.findElement(By.xpath("//div[contains(@class,'bootstrap-datetimepicker')]//td[text()='13']")).click();

        driver.findElement(endDate).click();
        // Select date for current month
        driver.findElement(By.xpath("//div[contains(@class,'bootstrap-datetimepicker')]//td[text()='13']")).click();
        driver.findElement(By.xpath("//select[@id='SelectFilterTimeDinein']")).click();
        driver.findElement(By.xpath("//select[@id='SelectFilterTimeDinein']//option[text()='Purchase Date']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(spinIconOrders));
    }

    @Test
    public void Get_All_Order_Pages(){
        if (driver.findElement(pagingTotalCount).isDisplayed()){
            List<WebElement> totalPages = driver.findElements(By.xpath("//span[contains(@class,'table-paging-total')]/parent::div/preceding-sibling::div//span"));
            for (WebElement page : totalPages){
                explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(spinIconOrders));

                ArrayList<WebElement> allOrderCodes = new ArrayList<WebElement>(driver.findElements(By.xpath("//tbody//a")));
                for (WebElement orderCode : allOrderCodes){
                    String orderUrl = orderCode.getAttribute("href");
                    String orderID = orderUrl.substring(41);
                    System.out.println(orderID);
                }
            }
        }

    }




    @AfterClass
    public void afterClass(){
       // driver.quit();
    }
}
