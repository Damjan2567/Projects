package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;
    public By CreateAccountLink = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a");
    public By FirstName = By.id("firstname");
    public By LastName = By.id("lastname");
    public By Newsletter = By.id("is_subscribed");
    public By Email = By.id("email_address");
    public By Password = By.id("password");
    public By ConfirmPassword = By.id("password-confirmation");
    public By CreateAccount = By.xpath("/html/body/div[1]/main/div[3]/div/form/div/div[1]/button");
    public By Output = By.className("box-title");
    public By CustomerDropdownMenu = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button");
    public By HomePage = By.xpath("/html/body/div[1]/header/div/a");




    public RegisterPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }


    public void navigateToPage(String url){driver.get(url);}

    public void uSendKeys(By sendKeys,String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(sendKeys)).sendKeys(username);
    }

    public void uClick(By click){
        wait.until(ExpectedConditions.presenceOfElementLocated(click)).click();
    }

    public String returnOutput() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(Output)).getText();
    }



















    public By EmailT = By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div/div[1]/h1");
    public By AcceptAll = By.xpath("/html/body/div/div[1]/div/div/div[2]/button[2]");
    public By PasswortT = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/form/div[2]/div/div/div[1]/div[1]");
    public By LogInT = By.className("g-btn m-rounded m-block m-md mb-0");
    public By Street = By.xpath("//*[@id=payment-form]/div[3]/div/div/div[1]/div[1]/input");

    public void uSearch(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]"))).sendKeys(Keys.TAB);
    }





}
