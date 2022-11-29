package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu) {

        switch (menu) {
            case "Desktops":
                clickOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]/div/a"));
                break;
            case "Laptops & Notebooks":
                clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
                break;
            case "Components":
                clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
                break;
            case "Tablets":
                clickOnElement(By.xpath("//a[contains(text(),'Tablets')]"));
                break;
            case "Software":
                clickOnElement(By.xpath("//a[contains(text(),'Software')]"));
                break;
            case "Phones & PDAs":
                clickOnElement(By.xpath("//a[contains(text(),'Phones & PDAs')]"));
                break;
            case "Cameras":
                clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[7]/a[1]"));
                break;
            case "MP3 Players":
                clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[8]/a[1]"));
                break;
            default:
                System.out.println("Selection not valid");
                break;
        }

    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]"));

        //1.2 call selectMenu method and pass the menu = “Desktops”
        selectMenu("Desktops");

        //  1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Thread.sleep(800);
        Select select = new Select(dropDown);
        //finding element by value
        select.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");
        Thread.sleep(800);

        //  1.4 Verify the Product will arrange in Descending order
        verifyText("Name (Z - A)", By.xpath("//option[contains(text(),'Name (Z - A)')]"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]"));

        //2.2 Click on “Show All Desktops”
        selectMenu("Desktops");

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Thread.sleep(800);
        Select select = new Select(dropDown);
        //finding element by value
        select.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
        Thread.sleep(800);

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        verifyText("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"));

        //2.6 Select Delivery Date "2022-11-30"
        Thread.sleep(1000);
        clearBody(By.id("input-option225"));
        sendTextToElement(By.id("input-option225"), "2022-11-30");

        //2.7.Enter Qty "1” using Select class.
        clearBody(By.id("input-quantity"));
        sendTextToElement(By.id("input-quantity"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        Thread.sleep(1000);

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyText("Success: You have added HP LP3065 to your shopping cart!\n" + "×", By.xpath("//body/div[@id='product-product']/div[1]"));

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //2.11 Verify the text "Shopping Cart"
        verifyText("Shopping Cart  (1.00kg)", By.xpath("//h1[contains(text(),' (1.00kg)')]"));

        //2.12 Verify the Product name "HP LP3065"
        verifyText("HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

        //2.13 Verify the Delivery Date "2022-11-30"
        verifyText("Delivery Date: 2022-11-30", By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"));

        //2.14 Verify the Model "Product21"
        Thread.sleep(800);
        verifyText("Product 21", By.xpath("//td[contains(text(),'Product 21')]"));

        //2.15 Verify the Total "£74.73"
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        mouseHoverClick(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        verifyText("£74.73", By.xpath("//tbody/tr[1]/td[6]"));

    }

    @After
    public void testDown(){
        closeBrowser();
    }
}
