package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BookticketPage extends GeneralPage {
    private final By _selDepartDate = By.name("Date");
    private final By _selDepartFrom = By.name("DepartStation");
    private final By _selArriveAt = By.name("ArriveStation");
    private final By _selSiteType = By.name("SeatType");
    private final By _selTicketAmount = By.name("TicketAmount");
    private final By _btnBookTicket = By.xpath("//div[@id='content']//input[@type='submit']");
    private final By _txtTitle = By.xpath("//h1[@align='center']");
    private final By _tblBookedTickets = By.xpath("//table[@class='MyTable WideTable']");
    private final String cellXPath = "//table[@class='MyTable WideTable']//tr[2]/td[%s]";
    private String selectedDepartDate;

    public WebElement getDepartDateSelect() { return Constant.WEBDRIVER.findElement(_selDepartDate); }
    public WebElement getDepartStationSelect() { return Constant.WEBDRIVER.findElement(_selDepartFrom); }
    public WebElement getArriveStationSelect() { return Constant.WEBDRIVER.findElement(_selArriveAt); }
    public WebElement getSiteTypeSelect() { return Constant.WEBDRIVER.findElement(_selSiteType); }
    public WebElement getTicketAmountSelect() { return Constant.WEBDRIVER.findElement(_selTicketAmount); }
    public WebElement getBtnBookTicket() { return Constant.WEBDRIVER.findElement(_btnBookTicket); }
    public WebElement getTxtTitle() { return Constant.WEBDRIVER.findElement(_txtTitle); }
    public WebElement getTblBookedTickets() { return Constant.WEBDRIVER.findElement(_tblBookedTickets); }

    public String getCellText(int index) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(cellXPath, index))).getText();
    }

    public String getDepartStation() { return getCellText(1); }
    public String getArriveStation() { return getCellText(2); }
    public String getSeatType() { return getCellText(3); }
    public String getDepartDate() { return getCellText(4); }
    public String getAmount() { return getCellText(7); }

    public void selectDepartDatePlusDays(int plusDays) {
        Select departDateSelect = new Select(Constant.WEBDRIVER.findElement(_selDepartDate));
        LocalDate targetDate = LocalDate.now().plusDays(plusDays);
        String targetDateStr = targetDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

        for (WebElement option : departDateSelect.getOptions()) {
            if (option.getText().equals(targetDateStr)) {
                option.click();
                this.selectedDepartDate = targetDateStr;
                return;
            }
        }
        throw new RuntimeException("Ngày " + targetDateStr + " không có trong dropdown!");
    }

    public void selectDepartFrom(String station) {
        new Select(getDepartStationSelect()).selectByVisibleText(station);
    }

    public void selectArriveAt(String station) {
        new Select(getArriveStationSelect()).selectByVisibleText(station);
    }

    public void selectSeatType(String seat) {
        new Select(getSiteTypeSelect()).selectByVisibleText(seat);
    }

    public void selectTicketAmount(String amount) {
        new Select(getTicketAmountSelect()).selectByVisibleText(amount);
    }

    public void clickBookTicket() { getBtnBookTicket().click(); }

    public void bookTicket(int plusDays, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        selectDepartDatePlusDays(plusDays);
        selectDepartFrom(departFrom);
        selectArriveAt(arriveAt);
        selectSeatType(seatType);
        selectTicketAmount(ticketAmount);
        clickBookTicket();
    }

    public String getSelectedDepartDate() { return selectedDepartDate; }
}