package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;
    public By ShopYoga = By.className("blocks-promo");
    public By Output1 = By.id("page-title-heading");
    public By Product = By.xpath("//*[@class='products list items product-items']//li");
    public By Output2 = By.className("base");
    public By Size = By.xpath("//*[@class='swatch-attribute size']//div//div");
    public By Output3 = By.xpath("//*[@class='swatch-attribute size']//span[2]");
    public By Color = By.xpath("//*[@class='swatch-attribute color']//div//div");
    public By Output4 = By.xpath("//*[@class='swatch-attribute color']//span[2]");
    public By Qty = By.id("qty");
    public By AddToCart = By.id("product-addtocart-button");
    public By Output5 = By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/div/div");
    public By RelatedProducts = By.xpath("//*[@class='products wrapper grid products-grid products-related']//li");
    public By Cart = By.xpath("/html/body/div[1]/header/div[2]/div[1]/a");
    public By Checkout = By.id("top-cart-btn-checkout");




    public ProductsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToPage(String url){driver.get(url);}

    public void uSendKeys(By sendKeys,String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(sendKeys)).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(sendKeys)).sendKeys(username);
    }

    public void uClick(By click){
        wait.until(ExpectedConditions.presenceOfElementLocated(click)).click();
    }

    public void uSelect(By select, int index){
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(select));
        list.get(index).click();
    }

    public String returnOutput(By output) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(output)).getText();
    }
}
