package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangepasswordPage extends GeneralPage {
    private final By _txtCurrentPassWord = By.id("currentPassword");
    private final By _txtNewPassWord = By.id("newPassword");
    private final By _txtConfirmPass = By.id("confirmPassword");
    private final By _txtTitleChangePass = By.xpath("//h1[@align='center']");
    private final By _btnChangePass = By.xpath("//input[@type='submit' and @value='Change Password']");
    private final By _lblChangeSuccess = By.xpath("//p[@class='message success']");

    public WebElement getTxtCurrentPassWord() { return Constant.WEBDRIVER.findElement(_txtCurrentPassWord); }
    public WebElement getTxtNewPassWord() { return Constant.WEBDRIVER.findElement(_txtNewPassWord); }
    public WebElement getTxtConfirmPass() { return Constant.WEBDRIVER.findElement(_txtConfirmPass); }
    public WebElement getTxtTitleChangePass() { return Constant.WEBDRIVER.findElement(_txtTitleChangePass); }
    public WebElement getBtnChangePass() { return Constant.WEBDRIVER.findElement(_btnChangePass); }
    public WebElement getLblChangeSuccess() { return Constant.WEBDRIVER.findElement(_lblChangeSuccess); }

    public ChangepasswordPage changepassword(String currentpassword, String newpassword, String confirmpassword) {
        this.getTxtCurrentPassWord().sendKeys(currentpassword);
        this.getTxtNewPassWord().sendKeys(newpassword);
        this.getTxtConfirmPass().sendKeys(confirmpassword);
        this.getBtnChangePass().click();
        return this;
    }
}