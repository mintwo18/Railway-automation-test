package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotpasswordPage {
    private final By _txtEmailAddress = By.id("email");
    private final By _btnSendInstruction = By.xpath("//div[@id='content']//input[@type='submit' and @value='Send Instructions']");

    public WebElement getTxtEmailAddress() { return Constant.WEBDRIVER.findElement(_txtEmailAddress); }
    public WebElement getBtnSendInstruction() { return Constant.WEBDRIVER.findElement(_btnSendInstruction); }

    public ForgotpasswordPage forgotpass(String emailaddress) {
        this.getTxtEmailAddress().sendKeys(emailaddress);
        this.getBtnSendInstruction().click();
        return this;
    }
}