package magento.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.prefs.Preferences;

public class EtETest extends BaseTest{

    private Preferences prefs = Preferences.userRoot().node("emailnum");
    private int x = prefs.getInt("x", 1);
    String url= "https://magento.softwaretestingboard.com/";
    String firstName = "John";
    String lastName = "Doe";
    String password = "6Hv67&3Xg0VK";
    String output = "Contact Information";
    String output1 = "New Luma Yoga Collection";
    String output2 = "Gwen Drawstring Bike Short";
    String output3 = "30";
    String output4 = "Blue";
    String qty = "2"; //(1-10000)
    String output5 = "You added Gwen Drawstring Bike Short to your shopping cart.";
    String output6 = "Maya Tunic";
    String output7 = "M";
    String output8 = "Green";
    String qty2 = "3"; //(1-10000)
    String output9 = "You added Maya Tunic to your shopping cart.";
    String signedOut = "You are signed out";
    String aboutUs = "About us";
    String whoops = "Whoops, our bad...";
    String customerService = "Customer Service";
    String searchTerms = "Popular Search Terms";
    String privacyAndCookiePolicy = "Privacy Policy";
    String advancedSearch = "Advanced Search";
    String ordersAndReturns = "Orders and Returns";
    String contactUs = "Contact Us";
    String search = "Kenobi Trail Jacket";
    String searchResoult1 = "Compete Track Tote";
    String searchResoult2 = "Adrienne Trek Jacket";
    String searchResoult3 = "Maxima Drawstring Short";
    String moreInfoOutput = "Style";
    String ReviewsOutput = "Customer Reviews";
    String MensProductName = "Stark Fundamental Hoodie";
    String WomensProductName = "Cassia Funnel Sweatshirt";
    String erinRecommends = "Erin Recommends";
    String videoDownload = "Video Download";
    String wish = "Kenobi Trail Jacket";
    String wishList = "My Wish List";
    String compareProducts = "Compare Products";

    @Test(invocationCount = 1)  // <---The value of invocationCount can be changed to any number without changing any other part of the code (I made it so that the value for x is stored automatically, no need to change it manually every time you run the code)
    public void EndToEndTest1(){
        String numberStr = String.valueOf(x);
        String email = "john.doe"+numberStr+"@gmail.com";
        x++;
        prefs.putInt("x", x);

        registerPage.navigateToPage(url);
        min();

        //Register New User
        registerPage.uClick(registerPage.CreateAccountLink);
        registerPage.uSendKeys(registerPage.FirstName,firstName);
        registerPage.uSendKeys(registerPage.LastName,lastName);
        registerPage.uClick(registerPage.Newsletter);
        registerPage.uSendKeys(registerPage.Email,email);
        registerPage.uSendKeys(registerPage.Password,password);
        registerPage.uSendKeys(registerPage.ConfirmPassword,password);
        registerPage.uClick(registerPage.CreateAccount);
        Assert.assertEquals(registerPage.returnOutput(),output);

        //Customer Dropdown Menu
        registerPage.uClick(registerPage.CustomerDropdownMenu);
        //Sign Out
        etEPage.uClick(etEPage.SignOut);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), signedOut);

        //Log In
        etEPage.uClick(etEPage.SignOut);
        etEPage.uSendKeys(etEPage.LiEmail,email);
        etEPage.uSendKeys(etEPage.LiPassword,password);
        etEPage.uClick(etEPage.LiButton);



        //Wish
        etEPage.uSearch(etEPage.SearchBar,search);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), wish);
        etEPage.uClick(etEPage.WishList);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), wishList);

        //Compare
        etEPage.uSearch(etEPage.SearchBar,search);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), wish);

        //Compare Tab
        etEPage.uClick(etEPage.Compare);
        etEPage.uClick(etEPage.CompareTab);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), compareProducts);

        //Compare Add to Cart Button
        etEPage.uClick(etEPage.addToCart);
        sleep(100);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), wish);

        //Compare Add to Wish List
        etEPage.uClick(etEPage.CompareTab);
        etEPage.uClick(etEPage.HeartIcon);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), wishList);

        //Home Page
        registerPage.uClick(registerPage.HomePage);

        //Open Yoga Products
        productsPage.uClick(productsPage.ShopYoga);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output1), output1);
        //Select Product
        productsPage.uSelect(productsPage.Product,1);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output2), output2);
        //Select Product Size (0-4)
        productsPage.uSelect(productsPage.Size,2);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output3), output3);
        //Select Product Color (0-2)
        productsPage.uSelect(productsPage.Color,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output4), output4);
        //Select Product Quantity (1-10000)
        productsPage.uSendKeys(productsPage.Qty,qty);
        //Add to cart
        productsPage.uClick(productsPage.AddToCart);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output5), output5);

        scroll(300);

        //Select Product from Related Products
        productsPage.uSelect(productsPage.RelatedProducts,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output2), output6);
        //Select Product Size (0-4)
        productsPage.uSelect(productsPage.Size,2);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output3), output7);
        //Select Product Color (0-2)
        productsPage.uSelect(productsPage.Color,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output4), output8);
        //Select Product Quantity (1-10000)
        productsPage.uSendKeys(productsPage.Qty,qty2);
        //Add to cart
        productsPage.uClick(productsPage.AddToCart);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output5), output9);
        //Show Products in Cart
        productsPage.uClick(productsPage.Cart);
        //Checkout
        productsPage.uClick(productsPage.Checkout);

        sleep(2000);
        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);
        scroll(2000);

        //About Us
        etEPage.uSelect(etEPage.footerLinks1,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), aboutUs);
        scroll(500);

        //Luma Privacy Policy
        etEPage.uClick(etEPage.lumaPrivacyPolicy);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), whoops);
        scroll(500);

        //Customer Service
        etEPage.uSelect(etEPage.footerLinks1,1);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), customerService);
        scroll(500);

        //Search Terms
        etEPage.uSelect(etEPage.footerLinks2,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), searchTerms);
        scroll(500);

        //Privacy and Cookie Policy
        etEPage.uSelect(etEPage.footerLinks2,1);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), privacyAndCookiePolicy);
        scroll(3000);

        //Advanced Search
        etEPage.uSelect(etEPage.footerLinks2,2);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), advancedSearch);
        scroll(500);

        //Can't check Orders and Returns if logged in
        //Orders and Returns
        /*etEPage.uSelect(etEPage.footerLinks2,3);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), ordersAndReturns);
        scroll(500);*/

        //Contact Us
        etEPage.uClick(etEPage.contactUs);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), contactUs);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);
        scroll(2000);

        //Search Bar
        etEPage.uSearch(etEPage.SearchBar,search);
        //Sort By Relevance Ascending order
        etEPage.uClick(etEPage.SortByAsc);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), searchResoult1);

        etEPage.uSearch(etEPage.SearchBar,search);
        //Sort By Product Name
        etEPage.uSelect(etEPage.SortBy,0);
        //Sort By Relevance Ascending order
        etEPage.uClick(etEPage.SortByAsc);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), searchResoult2);

        etEPage.uSearch(etEPage.SearchBar,search);
        //Sort By Price
        etEPage.uSelect(etEPage.SortBy,1);
        //Sort By Relevance Ascending order
        etEPage.uClick(etEPage.SortByAsc);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), searchResoult3);

        scroll(200);

        //More Information Tab
        etEPage.uClick(etEPage.MoreInformation);
        Assert.assertEquals(etEPage.returnOutput(etEPage.OutputMI), moreInfoOutput);
        //Reviews Tab
        etEPage.uClick(etEPage.Reviews);
        Assert.assertEquals(etEPage.returnOutput(etEPage.OutputCR), ReviewsOutput);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        //What's New Tab
        etEPage.uClick(etEPage.WhatsNew);
        //New In Men's Menu
        etEPage.uSelect(etEPage.NewInMens,0);

        //Select Size
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        //Select Price
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select color
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        int m = 1;
        while (m <= 4) {
            sleep(100);
            etEPage.uSelect(etEPage.ShoppingOptions,0);
            etEPage.uClickLi(String.valueOf(1));
            m++;
        }
        m = 1;

        //The site crashes if you continue filtering at this point
        /*//Select New
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Sale
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Pattern
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Climate
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));*/
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), MensProductName);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        //What's New Tab
        etEPage.uClick(etEPage.WhatsNew);
        //New In Women's Menu
        etEPage.uSelect(etEPage.NewInWomens,0);

        //Select Style
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickStyle(String.valueOf(1));

        //Select Size
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        //Select Price
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select color
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        int w = 1;
        while (w <= 3) {
            sleep(100);
            etEPage.uSelect(etEPage.ShoppingOptions,0);
            etEPage.uClickLi(String.valueOf(1));
            w++;
        }
        w = 1;

        //The site crashes if you continue filtering at this point
        //Select Erin Recommends
        /*sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select New
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Sale
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Pattern
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Climate
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));*/
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), WomensProductName);

        //All tests NOT logged in

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        //Customer Dropdown Menu
        registerPage.uClick(registerPage.CustomerDropdownMenu);
        //Sign Out
        etEPage.uClick(etEPage.SignOut);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), signedOut);

        //Home Page
        registerPage.uClick(registerPage.HomePage);

        //Open Yoga Products
        productsPage.uClick(productsPage.ShopYoga);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output1), output1);
        //Select Product
        productsPage.uSelect(productsPage.Product,1);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output2), output2);
        //Select Product Size (0-4)
        productsPage.uSelect(productsPage.Size,2);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output3), output3);
        //Select Product Color (0-2)
        productsPage.uSelect(productsPage.Color,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output4), output4);
        //Select Product Quantity (1-10000)
        productsPage.uSendKeys(productsPage.Qty,qty);
        //Add to cart
        productsPage.uClick(productsPage.AddToCart);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output5), output5);

        scroll(300);

        //Select Product from Related Products
        productsPage.uSelect(productsPage.RelatedProducts,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output2), output6);
        //Select Product Size (0-4)
        productsPage.uSelect(productsPage.Size,2);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output3), output7);
        //Select Product Color (0-2)
        productsPage.uSelect(productsPage.Color,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output4), output8);
        //Select Product Quantity (1-10000)
        productsPage.uSendKeys(productsPage.Qty,qty2);
        //Add to cart
        productsPage.uClick(productsPage.AddToCart);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output5), output9);
        //Show Products in Cart
        productsPage.uClick(productsPage.Cart);
        //Checkout
        productsPage.uClick(productsPage.Checkout);

        sleep(2000);
        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        scroll(2000);

        //About Us
        etEPage.uSelect(etEPage.footerLinks1,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), aboutUs);
        scroll(500);

        //Luma Privacy Policy
        etEPage.uClick(etEPage.lumaPrivacyPolicy);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), whoops);
        scroll(500);

        //Customer Service
        etEPage.uSelect(etEPage.footerLinks1,1);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), customerService);
        scroll(500);

        //Search Terms
        etEPage.uSelect(etEPage.footerLinks2,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), searchTerms);
        scroll(500);

        //Privacy and Cookie Policy
        etEPage.uSelect(etEPage.footerLinks2,1);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), privacyAndCookiePolicy);
        scroll(3000);

        //Advanced Search
        etEPage.uSelect(etEPage.footerLinks2,2);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), advancedSearch);
        scroll(500);

        //Orders and Returns
        etEPage.uSelect(etEPage.footerLinks2,3);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), ordersAndReturns);
        scroll(500);

        //Contact Us
        etEPage.uClick(etEPage.contactUsLO);
        Assert.assertEquals(etEPage.returnOutput(etEPage.Output1), contactUs);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);
        scroll(2000);

        //Search Bar
        etEPage.uSearch(etEPage.SearchBar,search);
        //Sort By Relevance Ascending order
        etEPage.uClick(etEPage.SortByAsc);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), searchResoult1);

        etEPage.uSearch(etEPage.SearchBar,search);
        //Sort By Product Name
        etEPage.uSelect(etEPage.SortBy,0);
        //Sort By Relevance Ascending order
        etEPage.uClick(etEPage.SortByAsc);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), searchResoult2);

        etEPage.uSearch(etEPage.SearchBar,search);
        //Sort By Price
        etEPage.uSelect(etEPage.SortBy,1);
        //Sort By Relevance Ascending order
        etEPage.uClick(etEPage.SortByAsc);
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), searchResoult3);

        scroll(200);

        //More Information Tab
        etEPage.uClick(etEPage.MoreInformation);
        Assert.assertEquals(etEPage.returnOutput(etEPage.OutputMI), moreInfoOutput);
        //Reviews Tab
        etEPage.uClick(etEPage.Reviews);
        Assert.assertEquals(etEPage.returnOutput(etEPage.OutputCR), ReviewsOutput);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        //What's New Tab
        etEPage.uClick(etEPage.WhatsNew);
        //New In Men's Menu
        etEPage.uSelect(etEPage.NewInMens,0);

        //Select Size
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        //Select Price
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select color
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        while (m <= 4) {
            sleep(100);
            etEPage.uSelect(etEPage.ShoppingOptions,0);
            etEPage.uClickLi(String.valueOf(1));
            m++;
        }

        //The site crashes if you continue filtering at this point
        /*//Select New
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Sale
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Pattern
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Climate
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));*/
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), MensProductName);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        //What's New Tab
        etEPage.uClick(etEPage.WhatsNew);
        //New In Women's Menu
        etEPage.uSelect(etEPage.NewInWomens,0);

        //Select Style
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickStyle(String.valueOf(1));

        //Select Size
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));

        //Select Price
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select color
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickA(String.valueOf(1));


        while (w <= 3) {
            sleep(100);
            etEPage.uSelect(etEPage.ShoppingOptions,0);
            etEPage.uClickLi(String.valueOf(1));
            w++;
        }

        //The site crashes if you continue filtering at this point
        //Select Erin Recommends
        /*sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select New
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Sale
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Pattern
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));

        //Select Climate
        sleep(100);
        etEPage.uSelect(etEPage.ShoppingOptions,0);
        etEPage.uClickLi(String.valueOf(1));*/
        etEPage.uSelect(etEPage.SearchResouls,0);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), WomensProductName);

        //Return to Homepage
        registerPage.uClick(registerPage.HomePage);

        etEPage.uClick(etEPage.Training);
        etEPage.uSelect(etEPage.ErinRecommends,1);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), erinRecommends);

        etEPage.uClick(etEPage.Training);
        scroll(100);
        etEPage.uSelect(etEPage.ErinRecommends,2);
        Assert.assertEquals(etEPage.returnOutput(etEPage.ProductName), videoDownload);
    }



    @Test
    public void Help(){
        registerPage.navigateToPage("https://onlyfans.com/my/payments/add_card");
        registerPage.uClick(registerPage.AcceptAll);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("2z28qw1s2@qiott.com").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Contraseña123!").perform();
        sleep(10000);
        actions.sendKeys(Keys.ENTER).perform();

        registerPage.uClick(registerPage.EmailT);


        //After Clicking somewhere in the middle of the page like next to ADD CART press tab 3 times to get to State
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Bizkaia").perform();
        //For City
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Bilbo").perform();
        //For ZIP
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("48006").perform();
        //For E-mail
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("2z28qw1s2@qiott.com").perform();
        //For Name on the card
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("DAwwol aKkmaka").perform();
        //For Card Number
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("9846 5164 9841 4981").perform();
        //For Expiration Month
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("11").perform();
        //For Expiration Year
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("24").perform();
        //For CVC
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("888").perform();
        //For Street
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys("Goyo Nadal Kalea 1").perform();






    }
}
