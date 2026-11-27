package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookticket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabChangepassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabMyticket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabForgotpassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    protected WebElement getTabLogin() { return Constant.WEBDRIVER.findElement(tabLogin); }
    protected WebElement getTabLogout() { return Constant.WEBDRIVER.findElement(tabLogout); }
    protected WebElement getTabBookticket() { return Constant.WEBDRIVER.findElement(tabBookticket); }
    protected WebElement getTabRegister() { return Constant.WEBDRIVER.findElement(tabRegister); }
    protected WebElement getTabChangepassword() { return Constant.WEBDRIVER.findElement(tabChangepassword); }
    protected WebElement getTabMyticket() { return Constant.WEBDRIVER.findElement(tabMyticket); }
    protected WebElement getTabForgotpassword() { return Constant.WEBDRIVER.findElement(tabForgotpassword); }
    protected WebElement getTabTimetable() { return Constant.WEBDRIVER.findElement(tabTimetable); }
    protected WebElement getLblWelcomeMessage() { return Constant.WEBDRIVER.findElement(lblWelcomeMessage); }

    public String getWelcomeMessage() { return this.getLblWelcomeMessage().getText(); }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookticketPage gotoBookticketPage() {
        this.getTabBookticket().click();
        return new BookticketPage();
    }

    public RegisterPage gotoRegisterPage() {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public ChangepasswordPage gotoChangePasswordPage() {
        this.getTabChangepassword().click();
        return new ChangepasswordPage();
    }

    public MyticketPage gotoMyticketPage() {
        this.getTabMyticket().click();
        return new MyticketPage();
    }

    public ForgotpasswordPage gotoForgotPasswordPage() {
        this.getTabForgotpassword().click();
        return new ForgotpasswordPage();
    }

    public TimetablePage gotoTimetablePage() {
        this.getTabTimetable().click();
        return new TimetablePage();
    }
}