package booking.blocks;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;

/**
 * Created by zsmirnova on 4/6/18.
 */
public interface WithCalendar {

    @Description("Calendar block")
    @FindBy("//th[@class='c2-month-header-monthname' and contains(.,'{{ month }}') ]//ancestor::table//tbody")
    Calendar calendarMonth(@Param("month") String month);
}
