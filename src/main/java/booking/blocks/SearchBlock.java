package booking.blocks;

import WebElements.ExtendedMineWebElement;
import WebElements.MineWebElement;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

/**
 * Created by zsmirnova on 4/6/18.
 */
public interface SearchBlock extends ExtendedMineWebElement, WithCalendar {

    @Description("Search input")
    @FindBy(".//input[contains(@class, 'sb-searchbox__input')]")
    MineWebElement searchInput();

    @Description("Open calendar button")
    @FindBy(".//div[@data-calendar2-title='Check-in']")
    MineWebElement openCalendarButton();

    @Description("Guest button")
    @FindBy(".//div[contains(@class, 'xp__guests')]")
    MineWebElement openGuestSettingsButton();

    @Description("Group selector")
    @FindBy(".//select[@name = 'group_adults']")
    MineWebElement groupSelector();

    @Description("Child selector")
    @FindBy(".//select[@name= 'group_children']")
    MineWebElement childSelector();

    @Description("Child age selector")
    @FindBy(".//select[@name='age']")
    MineWebElement childAgeSelector();

    @Description("Room selector")
    @FindBy(".//select[@name='no_rooms']")
    MineWebElement roomSelector();

    @Description("For work checkbox")
    @FindBy(".//input[@name = 'sb_travel_purpose']")
    MineWebElement forWorkTravelCheckbox();

    @Description("Search button")
    @FindBy(".//button[contains(@class, 'sb-searchbox__button')]")
    MineWebElement searchButton();

}
