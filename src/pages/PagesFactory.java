/**
 * Pages factory class implementation.
 * Author: Jony, Date: September 12, 2018
 */


package pages;

import org.openqa.selenium.support.PageFactory;

import helper.DriverActions;

import helper.DriverWaits;

import pageobjects.*;
import browserutility.Browser;

public final class PagesFactory {

    private static <T> T GetPage(Class<T> className) {
        return PageFactory.initElements(Browser.getWebDriver(), className);
    }

    public static DriverActions getDriverActionsObject() {
        return GetPage(DriverActions.class);
    }

    public static DriverWaits getDriverWaitsObject() {
        return GetPage(DriverWaits.class);
    }

    public static LoginPage getLoginPage() {
        return GetPage(LoginPage.class);
    }

    public static HomePage getHomePage() {
        return GetPage(HomePage.class);
    }

    public static DashboardPage getDashboardPage() {return GetPage(DashboardPage.class);}

    public static MarketplacePage getMarketplacePage() {return GetPage(MarketplacePage.class);}

    public static HotDealsPage getHotDealsPage() {return GetPage(HotDealsPage.class);}

    public static ProfilePage getProfilePage() {return GetPage(ProfilePage.class);}

}
