package booking.blocks;

import WebElements.ExtendedMineWebElement;
import WebElements.MineWebElement;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

/**
 * Created by zsmirnova on 4/7/18.
 */
public interface HotelItem extends ExtendedMineWebElement {

    @Description("Hotel name")
    @FindBy(".//span[contains(@class, 'sr-hotel__name')]")
    MineWebElement hotelName();

}
