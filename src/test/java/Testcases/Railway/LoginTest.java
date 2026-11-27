package Testcases.Railway;

import PageObjects.Railway.*;
import Common.Constant.Constant;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new EdgeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.loginfail("", Constant.PASSWORD).getLblLoginErrorMsg().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form. ";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.loginfail(Constant.USERNAME, Constant.PASSWORD_WRONG).getLblLoginErrorMsg().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page display when un-logged User clicks on 'Book ticket' tab");
        HomePage homePage = new HomePage();
        homePage.open();
        BookticketPage bookticketPage = homePage.gotoBookticketPage();

        String actualMsg = bookticketPage.getTxtTitle().getText();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "Incorrect page displayed: Login page appeared instead of Book ticket page.");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = "";

        for (int i = 1; i <= 4; i++) {
            Constant.WEBDRIVER.findElement(By.id("password")).clear();
            actualMsg = loginPage.loginfail(Constant.USERNAME, Constant.PASSWORD_WRONG).getLblLoginErrorMsg().getText();
            System.out.println("Incorrect login attempt " + i);
        }

        String expectedMsg = "You have used 4 out of 5 login attempts. " +
                "After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertTrue(homePage.isLogoutTabDisplayed(), "Logout tab is not displayed!");
        Assert.assertTrue(homePage.isChangePasswordTabDisplayed(), "Change Password tab is not displayed!");
        Assert.assertTrue(homePage.isMyTicketTabDisplayed(), "My Ticket tab is not displayed!");

        MyticketPage myticketPage = homePage.gotoMyticketPage();
        String actualMyTicketMsg = myticketPage.getTxtTitleMyTicket().getText();
        String expectedMyTicketMsg = "Manage Tickets";
        Assert.assertEquals(actualMyTicketMsg, expectedMyTicketMsg, "Incorrect page displayed");

        ChangepasswordPage changepasswordPage = myticketPage.gotoChangePasswordPage();
        String actualChangeTicketMsg = changepasswordPage.getTxtTitleChangePass().getText();
        String expectedChangeTicketMsg = "Change password";
        Assert.assertEquals(actualChangeTicketMsg, expectedChangeTicketMsg, "Incorrect page displayed");
    }
}