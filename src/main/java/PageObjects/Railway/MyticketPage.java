package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MyticketPage extends GeneralPage {
    private final By _txtTitleMyTicket = By.xpath("//h1[@align='center']");
    private String cancelBtnXPath = "//table[@class='MyTable']//tr[td/input[contains(@onclick,'DeleteTicket(%s)')]]"
            + "/td[count(//table[@class='MyTable']//tr[@class='TableSmallHeader']/th[text()='Operation']/preceding-sibling::th)+1]/input";

    public WebElement getTxtTitleMyTicket() {
        return Constant.WEBDRIVER.findElement(_txtTitleMyTicket);
    }

    public WebElement getCancelButton(String ticketId) {
        String xpath = String.format(cancelBtnXPath, ticketId);
        return Constant.WEBDRIVER.findElement(By.xpath(xpath));
    }

    public void cancelTicket(String ticketId) {
        WebElement cancelButton = getCancelButton(ticketId);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", cancelButton);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].click();", cancelButton);
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean isTicketCanceled(String ticketId) {
        try {
            this.getCancelButton(ticketId);
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }
}