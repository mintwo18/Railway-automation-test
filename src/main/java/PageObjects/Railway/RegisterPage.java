package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By _txtEmail = By.id("email");
    private final By _txtPassWord = By.id("password");
    private final By _txtConfirmPass = By.id("confirmPassword");
    private final By _txtPid = By.id("pid");
    private final By _btnRegister = By.xpath("//input[@type='submit' and @value='Register']");
    private final By _lblRegisterSuccess = By.xpath("//div[@id='content']/p");
    private final By _lblRegisterErrorMsg = By.xpath("//div[@id='content']//p[@class='message error']");
    private final By _lblRegisterErrorPassMsg = By.xpath("//div[@id='content']//label[@for='password' and @class='validation-error']");
    private final By _lblRegisterErrorPidMsg = By.xpath("//div[@id='content']//label[@for='pid' and @class='validation-error']");

    public WebElement getTxtEmail() { return Constant.WEBDRIVER.findElement(_txtEmail); }
    public WebElement getTxtPassWord() { return Constant.WEBDRIVER.findElement(_txtPassWord); }
    public WebElement getTxtConfirmPass() { return Constant.WEBDRIVER.findElement(_txtConfirmPass); }
    public WebElement getTxtPid() { return Constant.WEBDRIVER.findElement(_txtPid); }
    public WebElement getBtnRegister() { return Constant.WEBDRIVER.findElement(_btnRegister); }
    public WebElement getLblRegisterSuccess() { return Constant.WEBDRIVER.findElement(_lblRegisterSuccess); }
    public WebElement getLblRegisterErrorMsg() { return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg); }
    public WebElement getLblRegisterErrorPassMsg() { return Constant.WEBDRIVER.findElement(_lblRegisterErrorPassMsg); }
    public WebElement getLblRegisterErrorPidMsg() { return Constant.WEBDRIVER.findElement(_lblRegisterErrorPidMsg); }

    public RegisterPage register(String email, String password, String confirmPassword, String pid) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassWord().sendKeys(password);
        this.getTxtConfirmPass().sendKeys(confirmPassword);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegister().click();
        return new RegisterPage();
    }
}