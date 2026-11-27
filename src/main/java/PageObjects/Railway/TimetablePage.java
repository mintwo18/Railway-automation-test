package PageObjects.Railway;

import org.openqa.selenium.By;
import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimetablePage {
    private String bookTicketLink = "//table[@class='MyTable WideTable']//tr[td[2]='%s'and td[3]='%s']" +
            "//td[count(//table[@class='MyTable WideTable']//th[text()='Book ticket']/preceding-sibling::th)+1]/a";
    private final By _selDepartFrom = By.name("DepartStation");
    private final By _selArriveAt = By.name("ArriveStation");

    public void goToBookTicketPage(String departStation, String arriveStation) {
        String xpath = String.format(bookTicketLink, departStation, arriveStation);
        WebElement element = Constant.WEBDRIVER.findElement(By.xpath(xpath));
        ((JavascriptExecutor) Constant.WEBDRIVER)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.click();
    }

    public String getDepartStationSelected() {
        return Constant.WEBDRIVER.findElement(_selDepartFrom)
                .findElement(By.xpath(".//option[@selected='selected']")).getText();
    }

    public String getArriveStationSelected() {
        return Constant.WEBDRIVER.findElement(_selArriveAt)
                .findElement(By.xpath(".//option[@selected='selected']")).getText();
    }
}