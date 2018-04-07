package booking.pages;

import WebElements.MineWebElement;
import booking.blocks.HotelItem;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;

/**
 * Created by zsmirnova on 4/6/18.
 */
public interface ResultPage extends WebPage {

    @Description("List of hotels")
    @FindBy("//tr[contains(@class, 'entire_row_clickable')]//ancestor::div[contains(@class, 'sr_item_default')]")
    ExtendedList<HotelItem> hotelList();

    @Description("Filter prices")
    @FindBy("//div[@id='filter_price']//span[contains(@class,'filter_label')]")
    ExtendedList<MineWebElement> filterPrices();

    @Description("Filter prices")
    @FindBy("//div[@id='filter_review']//span[contains(@class,'filter_label')]")
    ExtendedList<MineWebElement> filterScores();

    @Description("Overlay message")
    @FindBy("//div[@class='sr-usp-overlay__message']")
    MineWebElement overlayMessage();
}
