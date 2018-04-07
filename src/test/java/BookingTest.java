import booking.steps.BaseTest;
import booking.steps.ResultPageSteps;
import io.qameta.htmlelements.annotation.Description;
import org.junit.Before;
import org.junit.Test;
import booking.steps.MainBookingPageSteps;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zsmirnova on 4/6/18.
 */

public class BookingTest extends BaseTest {

    private MainBookingPageSteps mainBookingPageSteps = new MainBookingPageSteps(getWebDriver());
    private ResultPageSteps resultPageSteps = new ResultPageSteps(getWebDriver());

    private String lastDayOfCurrentMonth;
    private String currentMonth;

    @Before
    public void setupTest() {
        Calendar calendar = Calendar.getInstance();
        String year = new SimpleDateFormat("YYYY").format(calendar.getTime());
        lastDayOfCurrentMonth = String.valueOf(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        currentMonth = new SimpleDateFormat("MMMM").format(calendar.getTime()) + " " + year;
        mainBookingPageSteps.openBooking();
    }

    @Test
    @Description("Verify hotels displayed in the result")
    public void openTest(){
        mainBookingPageSteps
                .setCurrency("Euro")
                .setLanguage("English (US)")
                .inputDestination("Málaga, Andalucía, Spain")
                .setCheckInDate(currentMonth, lastDayOfCurrentMonth)
                .openGroupSettings()
                .selectCountOfRooms("2")
                .selectGroup("1")
                .selectCountOfChild("1")
                .selectAgeOfChild("5")
                .setCheckboxTravelingForWork()
                .clickToSearchButton();
        resultPageSteps
                .setBudgetInFilter("€ 0 - € 50")
                .setBudgetInFilter("€ 50 - € 100")
                .setBudgetInFilter("€ 100 - € 150")
                .setBudgetInFilter("€ 150 - € 200")
                .setScoreInFilter("8+")
                .checkHotelsDisplayedInResult();
    }

}
