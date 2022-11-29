package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    private By by;

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
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverClick(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]"));

        //1.2 call selectMenu method and pass the menu = “Desktops”
        selectMenu("Desktops");

        //1.3 Verify the text ‘Desktops’
        verifyText("Desktops", By.xpath("//h2[contains(text(),'Desktops')]"));
    }

    @After
    public void testDown(){
        closeBrowser();
    }


}
