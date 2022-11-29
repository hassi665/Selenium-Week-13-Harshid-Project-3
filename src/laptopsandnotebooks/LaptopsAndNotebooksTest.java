package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        Thread.sleep(500);
        mouseHoverClick(By.xpath("//div[@class = 'collapse navbar-collapse navbar-ex1-collapse']/ul[1]/li[2]/a[1]"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Thread.sleep(500);
        Select select = new Select(dropDown);
        //finding element by value
        select.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        Thread.sleep(800);

        //1.4 Verify the Product price will arrange in High to Low order.
        verifyText("Price (High > Low)", By.xpath("//option[contains(text(),'Price (High > Low)')]"));

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        Thread.sleep(500);
        mouseHoverClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Thread.sleep(500);
        Select select = new Select(dropDown);
        //finding element by value
        select.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        Thread.sleep(800);

        //2.4 Select Product “MacBook”
        mouseHoverClick(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        //2.5 Verify the text “MacBook”
        Thread.sleep(800);
        verifyText("MacBook",By.xpath("//h1[contains(text(),'MacBook')]"));
        //body/div[@id='product-category']/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]

        Thread.sleep(1000);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Thread.sleep(1000);
        verifyText("Success: You have added MacBook to your shopping cart!\n" + "×", By.xpath("//body/div[@id='product-product']/div[1]"));

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //2.9 Verify the text "Shopping Cart"

        verifyText("Shopping Cart  (0.00kg)", By.xpath("//h1[contains(text(),' (0.00kg)')]"));

        //2.10 Verify the Product name "MacBook"
        Thread.sleep(1000);
        verifyText("MacBook", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

        //2.11 Change Quantity "2"
        clearBody(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));
        Thread.sleep(800);

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Thread.sleep(500);
        verifyText("Success: You have modified your shopping cart!\n" + "×", By.xpath("//body/div[@id='checkout-cart']/div[1]"));

        //2.14 Verify the Total £737.45
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        mouseHoverClick(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        Thread.sleep(500);
        verifyText("£737.45", By.xpath("//tbody/tr[1]/td[6]"));

        //2.15 Click on “Checkout” button
        Thread.sleep(800);
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text “Checkout”
        verifyText("Checkout", By.xpath("//a[contains(text(),'Checkout')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.17 Verify the Text “New Customer”
        Thread.sleep(800);
        verifyText("New Customer", By.xpath("//h2[contains(text(),'New Customer')]"));

        //2.18 Click on “Guest Checkout” radio button
        Thread.sleep(500);
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Jayesh");
        sendTextToElement(By.id("input-payment-lastname"), "jordar");
        sendTextToElement(By.id("input-payment-email"), "Jayesh.j@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "099887766554");
        sendTextToElement(By.id("input-payment-address-1"), "london");
        sendTextToElement(By.id("input-payment-city"), "london");
        sendTextToElement(By.id("input-payment-postcode"), "En13jh");
        selectByValue(By.id("input-payment-country"), "222");
        selectByValue(By.id("input-payment-zone"), "3559");

        //2.21 Click on “Continue” Button
        Thread.sleep(800);
        clickOnElement(By.xpath("//input[@id='button-guest']"));


        //2.22 Add Comments About your order into text area
        Thread.sleep(500);
        sendTextToElement(By.name("comment"), "Order dispached me fast");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));

        //2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));

        //2.25 Verify the message “Warning: Payment method required!”
        Thread.sleep(800);
        verifyText("Warning: Payment method required!\n" + "×", By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"));

    }


    @After
    public void testDown(){
        closeBrowser();
    }
}
