package magento.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    String url = "https://magento.softwaretestingboard.com/";
    String output1 = "New Luma Yoga Collection";
    String output2 = "Gwen Drawstring Bike Short";
    String output3 = "30";
    String output4 = "Blue";
    String qty = "2";
    String output5 = "You added Gwen Drawstring Bike Short to your shopping cart.";
    String output6 = "Maya Tunic";
    String output7 = "M";
    String output8 = "Green";
    String qty2 = "3";
    String output9 = "You added Maya Tunic to your shopping cart.";


    @Test
    public void ProductsTest(){
        productsPage.navigateToPage(url);

        productsPage.uClick(productsPage.ShopYoga);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output1), output1);

        productsPage.uSelect(productsPage.Product,1);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output2), output2);
        productsPage.uSelect(productsPage.Size,2);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output3), output3);
        productsPage.uSelect(productsPage.Color,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output4), output4);
        productsPage.uSendKeys(productsPage.Qty,qty);
        productsPage.uClick(productsPage.AddToCart);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output5), output5);

        scroll(300);

        productsPage.uSelect(productsPage.RelatedProducts,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output2), output6);
        productsPage.uSelect(productsPage.Size,2);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output3), output7);
        productsPage.uSelect(productsPage.Color,0);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output4), output8);
        productsPage.uSendKeys(productsPage.Qty,qty2);
        productsPage.uClick(productsPage.AddToCart);
        Assert.assertEquals(productsPage.returnOutput(productsPage.Output5), output9);

        productsPage.uClick(productsPage.Cart);
        productsPage.uClick(productsPage.Checkout);
    }
}
