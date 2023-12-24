package magento.tests;

import magento.pages.EtEPage;
import magento.pages.ProductsPage;
import magento.pages.RegisterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public final int TIMEOUT = 15;
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    RegisterPage registerPage;
    ProductsPage productsPage;
    EtEPage etEPage;
    Actions actions;


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIMEOUT);
        js = (JavascriptExecutor)driver;
        registerPage = new RegisterPage(driver,wait);
        productsPage = new ProductsPage(driver, wait);
        etEPage = new EtEPage(driver, wait);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown(){
        sleep(3000);
        driver.quit();
    }

    public void sleep(int milliSeconds){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scroll(int x){
        js.executeScript("window.scrollBy(0,"+x+")");
    }


    static Robot robot;
    public static void min(){
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);

    }


}
