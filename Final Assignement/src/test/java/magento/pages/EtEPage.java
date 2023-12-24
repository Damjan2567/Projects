package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EtEPage {

    WebDriver driver;
    WebDriverWait wait;
    public By SignOut = By.xpath("//*[@class='authorization-link']//a"); //Same for Sign In
    public By LiEmail = By.id("email");
    public By LiPassword = By.id("pass");
    public By LiButton = By.id("send2");
    public By Output1 = By.xpath("/html/body/div/main/div[1]/h1/span");
    public By footerLinks1 = By.xpath("//*[@class='links']//div//li");
    public By lumaPrivacyPolicy = By.xpath("//*[@class='about-info cms-content']//ul//li[3]//a");

    public By footerLinks2 = By.xpath("/html/body/div[1]/footer/div/ul//li");
    public By contactUs = By.xpath("/html/body/div[1]/footer/div/ul/li[4]/a");
    public By contactUsLO = By.xpath("/html/body/div[1]/footer/div/ul/li[5]/a");
    public By SearchBar = By.id("search");
    public By SearchResouls = By.xpath("//*[@class='products wrapper grid products-grid']//li");
    public By ProductName = By.className("base");
    public By SortBy = By.xpath("//*[@class='sorter-options']//option");
    public By SortByAsc = By.xpath("/html/body/div[1]/main/div[3]/div[1]/div[2]/div[1]/div[4]/a");
    public By MoreInformation = By.id("tab-label-additional");
    public By OutputMI = By.xpath("/html/body/div[1]/main/div[2]/div/div[3]/div/div[4]/div/table/tbody/tr[1]/th");
    public By Reviews = By.id("tab-label-reviews-title");
    public By OutputCR = By.xpath("/html/body/div[1]/main/div[2]/div/div[3]/div/div[6]/div[1]/div/div[1]/strong");
    public By WhatsNew = By.id("ui-id-3");
    public By NewInWomens = By.xpath("//*[@class='categories-menu']//ul[1]//li");
    public By NewInMens = By.xpath("//*[@class='categories-menu']//ul[2]//li");
    public By ShoppingOptions = By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div");
    public By Training = By.xpath("//*[@class='level0 nav-5 category-item level-top parent ui-menu-item']//a");
    public By ErinRecommends = By.xpath("//*[@class='blocks-promo']//a");
    public By WishList = By.xpath("//*[@class='action towishlist']");
    public By Compare = By.xpath("//*[@class='action tocompare']");
    public By CompareTab = By.xpath("//*[@class='action compare']");
    public By addToCart = By.xpath("//*[@class='action tocart primary']");
    public By HeartIcon = By.xpath("//*[@class='action towishlist']");



    public EtEPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }


    public void navigateToPage(String url){driver.get(url);}

    public void uSendKeys(By sendKeys,String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(sendKeys)).sendKeys(username);
    }

    public void uSearch(By sendKeys,String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(sendKeys)).sendKeys(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(sendKeys)).sendKeys(Keys.ENTER);
    }

    public void uClick(By click){
        wait.until(ExpectedConditions.presenceOfElementLocated(click)).click();
    }

    public void uClickA(String n){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/a["+n+"]/div"))).click();
    }

    public void uClickLi(String n){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div[3]/div[1]/div[2]/ol/li["+n+"]/a"))).click();
    }

    public void uClickStyle(String n){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li["+n+"]/a"))).click();
    }

    public void uSelect(By select, int index){
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(select));
        list.get(index).click();
    }

    public String returnOutput(By output) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(output)).getText();
    }
}
