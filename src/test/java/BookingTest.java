import booking.steps.ResultPageSteps;
import io.qameta.htmlelements.annotation.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import booking.steps.MainBookingPageSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zsmirnova on 4/6/18.
 */

public class BookingTest {

    private static WebDriver webDriver;
    private String lastDayOfCurrentMonth;
    private String currentMonth;
    private MainBookingPageSteps mainBookingPageSteps;
    private ResultPageSteps resultPageSteps;

    @Before
    public void setupTest() {
        webDriver = new ChromeDriver();
        mainBookingPageSteps = new MainBookingPageSteps(webDriver);
        resultPageSteps = new ResultPageSteps(webDriver);

        Calendar calendar = Calendar.getInstance();
        String year = new SimpleDateFormat("YYYY").format(calendar.getTime());
        lastDayOfCurrentMonth = String.valueOf(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        currentMonth = new SimpleDateFormat("MMMM").format(calendar.getTime()) + " " + year;
    }

    @Test
    @Description("Verify hotels displayed in the result")
    public void openTest(){
        mainBookingPageSteps
                .openBooking()
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

    @After
    public void close(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
