package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By _txtUserName = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@type='submit' and @value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    public WebElement getTxtUserName() { return Constant.WEBDRIVER.findElement(_txtUserName); }
    public WebElement getTxtPassword() { return Constant.WEBDRIVER.findElement(_txtPassword); }
    public WebElement getBtnLogin() { return Constant.WEBDRIVER.findElement(_btnLogin); }
    public WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg); }

    public HomePage login(String username, String password) {
        this.getTxtUserName().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();
    }

    public LoginPage loginfail(String username, String password) {
        this.getTxtUserName().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        return new LoginPage();
    }

    public LoginPage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAYLOGIN_URL);
        return this;
    }
}