package booking.steps;

import WebElements.MineWebElement;
import io.qameta.htmlelements.WebPageFactory;
import booking.pages.BookingMainPage;
import org.openqa.selenium.WebDriver;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;

/**
 * Created by zsmirnova on 4/6/18.
 */
public class MainBookingPageSteps {

    private BookingMainPage bookingMainPage;

    public MainBookingPageSteps(WebDriver webDriver){
        WebPageFactory factory = new WebPageFactory();
        bookingMainPage = factory.get(webDriver, BookingMainPage.class);
    }

    public void openBooking(){
        bookingMainPage.go();
    }

    public MainBookingPageSteps inputDestination(String destination) {
        MineWebElement input = bookingMainPage.searchBlock().searchInput();
        input.waitUntil(displayed()).clear();
        input.sendKeys(destination);
        return this;
    }

    public MainBookingPageSteps setCurrency(String currency) {
        bookingMainPage.headerPanel().openCurrencyButton().waitUntil(displayed()).click();
        bookingMainPage.headerPanel().currency(currency).waitUntil(displayed()).click();
        return this;
    }

    public MainBookingPageSteps setLanguage(String language) {
        bookingMainPage.headerPanel().openLanguageButton().waitUntil(displayed()).click();
        bookingMainPage.headerPanel().language(language).waitUntil(displayed()).click();
        return this;
    }

    public MainBookingPageSteps setCheckInDate(String month, String day){
        bookingMainPage.searchBlock().openCalendarButton().waitUntil(displayed()).click();
        bookingMainPage.searchBlock().calendarMonth(month).waitUntil(displayed()).dayOfMonth(day).waitUntil(displayed()).click();
        return this;
    }

    public MainBookingPageSteps openGroupSettings(){
        //if view main page will be new
        if(bookingMainPage.searchBlock().openGuestSettingsButton().is(displayed())) {
            bookingMainPage.searchBlock().openGuestSettingsButton().click();
        }
        return this;
    }

    public MainBookingPageSteps selectGroup(String group){
        bookingMainPage.searchBlock().groupSelector().waitUntil(displayed()).selectValue(group);
        return this;
    }

    public MainBookingPageSteps selectCountOfChild(String countOfChild){
        bookingMainPage.searchBlock().childSelector().waitUntil(displayed()).selectValue(countOfChild);
        return this;
    }

    public MainBookingPageSteps selectAgeOfChild(String ageOfChild){
        bookingMainPage.searchBlock().childAgeSelector().waitUntil(displayed()).selectValue(ageOfChild);
        return this;
    }

    public MainBookingPageSteps selectCountOfRooms(String countOfRoom){
        bookingMainPage.searchBlock().roomSelector().waitUntil(displayed()).selectValue(countOfRoom);
        return this;
    }

    public MainBookingPageSteps setCheckboxTravelingForWork(){
        //if view main page will be old
        if(bookingMainPage.searchBlock().forWorkTravelCheckbox().is(displayed())) {
            bookingMainPage.searchBlock().forWorkTravelCheckbox().waitUntil(displayed()).click();
        }
        return this;
    }

    public void clickToSearchButton(){
        bookingMainPage.searchBlock().searchButton().waitUntil(displayed()).click();
    }

}
