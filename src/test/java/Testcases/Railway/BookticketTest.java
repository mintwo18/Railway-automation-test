package Testcases.Railway;

import PageObjects.Railway.*;
import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

public class BookticketTest {
    JavascriptExecutor jsExecutor;
    String email, password, pid;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new EdgeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
    public void TC14() {
        pid = Constant.PID;
        email = Constant.USERNAME;
        password = Constant.PASSWORD;
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        System.out.println("TC14 - User can book 1 ticket at a time");
        LoginPage loginPage = registerPage.gotoLoginPage();
        loginPage.login(email, password);
        BookticketPage bookticketPage = homePage.gotoBookticketPage();
        bookticketPage.bookTicket(5, "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        Assert.assertEquals(bookticketPage.getDepartDate(), bookticketPage.getSelectedDepartDate(), "Depart Date is incorrect");
        Assert.assertEquals(bookticketPage.getDepartStation(), "Sài Gòn", "Depart Station is incorrect");
        Assert.assertEquals(bookticketPage.getArriveStation(), "Nha Trang", "Arrive Station is incorrect");
        Assert.assertEquals(bookticketPage.getSeatType(), "Soft bed with air conditioner", "Seat type is incorrect");
        Assert.assertEquals(bookticketPage.getAmount(), "1", "Amount is incorrect");

        String actualMsg = bookticketPage.getTxtTitle().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not displayed as expected");
    }

    @Test
    public void TC15() {
        email = randomTestEmail();
        password = randomTestPassword();
        pid = Constant.PID;

        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        System.out.println("TC15 - User can open 'Book ticket' page from 'Train timetable'");
        LoginPage loginPage = registerPage.gotoLoginPage();
        loginPage.login(email, password);
        TimetablePage timetablepage = homePage.gotoTimetablePage();
        timetablepage.goToBookTicketPage("Huế", "Sài Gòn");

        Assert.assertEquals(timetablepage.getDepartStationSelected(), "Huế", "Depart Station is incorrect");
        Assert.assertEquals(timetablepage.getArriveStationSelected(), "Sài Gòn", "Arrive Station is incorrect");
    }

    @Test
    public void TC16() {
        email = randomTestEmail();
        password = randomTestPassword();
        pid = Constant.PID;

        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        System.out.println("TC16 - User can cancel a ticket");
        LoginPage loginPage = registerPage.gotoLoginPage();
        loginPage.login(email, password);
        BookticketPage bookticketPage = homePage.gotoBookticketPage();
        bookticketPage.bookTicket(5, "Sài Gòn", "Đà Nẵng", "Soft bed", "1");

        String url = Constant.WEBDRIVER.getCurrentUrl();
        String ticketId = url.split("id=")[1];

        MyticketPage myticketPage = bookticketPage.gotoMyticketPage();
        myticketPage.cancelTicket(ticketId);

        Assert.assertTrue(myticketPage.isTicketCanceled(ticketId), "Canceled ticket should disappear from the list");
    }
}