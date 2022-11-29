package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        if (option.equalsIgnoreCase("Register")) {
            clickOnElement(By.xpath("//li[@class='dropdown open']/ul/li[1]"));
        } else if (option.equalsIgnoreCase("Login")) {
            clickOnElement(By.xpath("//li[@class='dropdown open']/ul/li[2]"));
        }
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”
        verifyText("Register Account", By.xpath("//h1[contains(text(),'Register Account')]"));
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //2.3 Verify the text “Returning Customer”.
        verifyText("Returning Customer", By.xpath("//h2[contains(text(),'Returning Customer')]"));

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        Thread.sleep(500);
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Princess");

        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Patel");

        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Princess.patel@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "099886745365");

        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "patel111");

        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "patel111");
        Thread.sleep(500);

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));


        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));


        //3.12 Verify the message “Your Account Has Been Created!”
        Thread.sleep(500);
        verifyText("Your Account Has Been Created!", By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));


        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(500);

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverClick(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //Thread.sleep(1000);

        //3.16 Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"));

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Princess.patel@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "patel111");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        Thread.sleep(800);

        //4.7 Verify text “My Account”
        verifyText("My Account", By.xpath("//h2[contains(text(),'My Account')]"));


        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        Thread.sleep(500);

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverClick(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        Thread.sleep(500);

        //4.10 Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"));

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @After
    public void testDown(){
        closeBrowser();
    }

}
