package magento.tests;

import magento.utils.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    String url = "https://magento.softwaretestingboard.com/";
    String output = "Contact Information";


    //4 out of 9 test should pass (1,5,6 and 8)
    //You can change rhe value of x by 1 in the RegistrationDataProvider class

    @Test(dataProvider = "CreateNewCustomerAccount", dataProviderClass = RegistrationDataProvider.class)
    public void AccountCreation(String FirstName, String LastName, String Email, String Password, String Type){
        registerPage.navigateToPage(url);
        min();
        registerPage.uClick(registerPage.CreateAccountLink);
        System.out.println("Type: " + Type + ", FirstName: " + FirstName + ", LastName: " + LastName + ", Email: " + Email + ", Password: " + Password + ", Output: " + output);
        registerPage.uSendKeys(registerPage.FirstName,FirstName);
        registerPage.uSendKeys(registerPage.LastName,LastName);
        registerPage.uClick(registerPage.Newsletter);
        registerPage.uSendKeys(registerPage.Email,Email);
        registerPage.uSendKeys(registerPage.Password,Password);
        registerPage.uSendKeys(registerPage.ConfirmPassword,Password);
        registerPage.uClick(registerPage.CreateAccount);
        Assert.assertEquals(registerPage.returnOutput(),output);
        registerPage.uClick(registerPage.HomePage);
    }

}
