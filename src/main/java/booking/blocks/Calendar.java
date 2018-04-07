package booking.blocks;

import WebElements.ExtendedMineWebElement;
import WebElements.MineWebElement;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;

/**
 * Created by zsmirnova on 4/6/18.
 */
public interface Calendar extends ExtendedMineWebElement<Calendar> {

    @Description("Calendar day {{ day }}")
    @FindBy(".//span[contains(@class, 'c2-day') and text() = '{{ day }}']")
    MineWebElement dayOfMonth(@Param("day") String day);

}
