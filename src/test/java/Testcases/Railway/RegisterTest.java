package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;

public class RegisterTest {
    JavascriptExecutor jsExecutor;
    String email, password, pid, email_notactivate;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new EdgeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        jsExecutor = (JavascriptExecutor) Constant.WEBDRIVER;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    private String randomTestEmail() {
        return "testuser" + new Random().nextInt(100000) + "@mailsac.com";
    }

    private String randomTestPassword() {
        return "test-password-" + new Random().nextInt(100000);
    }

    @Test
    public void TC07() {
        email = randomTestEmail();
        password = randomTestPassword();
        pid = Constant.PID;

        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register(email, password, password, pid).getLblRegisterSuccess().getText();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not displayed as expected");
    }

    @Test
    public void TC08() {
        email_notactivate = randomTestEmail();
        password = randomTestPassword();

        System.out.println("TC08 - User can't login with an account that hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.loginfail(email_notactivate, password).getLblLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC09() {
        email = randomTestEmail();
        password = randomTestPassword();
        pid = Constant.PID;

        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        System.out.println("TC09 - User can change password");
        LoginPage loginPage = registerPage.gotoLoginPage();
        loginPage.login(email, password);
        ChangepasswordPage changepasswordPage = homePage.gotoChangePasswordPage();

        String actualMsg = changepasswordPage.changepassword(password, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD)
                .getLblChangeSuccess().getText();
        String expectedMsg = "Your password has been updated";
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not displayed as expected");
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with Confirm password is not the same with Password");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD_WRONG, Constant.PID)
                .getLblRegisterErrorMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC11() {
        email = randomTestEmail();

        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, "", "", "");

        String actualMsg = registerPage.getLblRegisterErrorMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

        String actualPassMsg = registerPage.getLblRegisterErrorPassMsg().getText();
        String expectedPassMsg = "Invalid password length.";
        Assert.assertEquals(actualPassMsg, expectedPassMsg, "Error message is not displayed as expected");

        String actualPidMsg = registerPage.getLblRegisterErrorPidMsg().getText();
        String expectedPidMsg = "Invalid ID length.";
        Assert.assertEquals(actualPidMsg, expectedPidMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC12() {
        email = randomTestEmail();
        password = randomTestPassword();
        pid = Constant.PID;

        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        System.out.println("TC12 - Errors display when password reset token is blank");
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        ForgotpasswordPage forgotpasswordPage = loginPage.gotoForgotPasswordPage();
        forgotpasswordPage.forgotpass(email);

        Assert.assertTrue(false, "Error page displays after clicking 'Send Instructions'. Error prevents testing remaining steps.");
    }

    @Test
    public void TC13() {
        email = randomTestEmail();
        password = randomTestPassword();
        pid = Constant.PID;

        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        System.out.println("TC13 - Errors display when password reset token is blank");
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        ForgotpasswordPage forgotpasswordPage = loginPage.gotoForgotPasswordPage();
        forgotpasswordPage.forgotpass(email);

        Assert.assertTrue(false, "Error page displays after clicking 'Send Instructions'. Error prevents testing remaining steps.");
    }
}