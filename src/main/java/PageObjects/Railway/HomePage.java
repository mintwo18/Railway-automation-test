package PageObjects.Railway;

import Common.Constant.Constant;

public class HomePage extends GeneralPage {
    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public boolean isLogoutTabDisplayed() {
        try { return getTabLogout().isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public boolean isChangePasswordTabDisplayed() {
        try { return getTabChangepassword().isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public boolean isMyTicketTabDisplayed() {
        try { return getTabMyticket().isDisplayed(); }
        catch (Exception e) { return false; }
    }
}