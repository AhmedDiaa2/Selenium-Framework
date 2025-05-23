import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.NoSuchElementException;


public class TestBase {

    public static WebDriver driver;

    //Temporary variable
    public String email = "gg87d5s99fdj@gmail.com";
    public String loginEmail = "ahfded.12god@gmail.com";

    WebDriverWait wait;
    Wait<WebDriver> Fwait;

    @BeforeClass
    @Parameters(("browser"))
    public void startDriver(@Optional("chrome") String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        Fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    @AfterClass
    public void stopDriver(){

        driver.quit();
    }

    @AfterMethod
    public void TakeScreenShotOnFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            CaptureScreenShot(driver,result.getName());
        }
    }


    public static void CaptureScreenShot(WebDriver driver, String SS_name){
        Path dir = Paths.get("./screenshots" , SS_name +".png");
        try{
            Files.createDirectories(dir.getParent());
            FileOutputStream out = new FileOutputStream(dir.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
}
