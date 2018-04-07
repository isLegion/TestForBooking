package booking.steps;

import booking.blocks.HotelItem;
import booking.pages.ResultPage;
import io.qameta.htmlelements.WebPageFactory;
import io.qameta.htmlelements.element.ExtendedList;
import org.openqa.selenium.WebDriver;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by zsmirnova on 4/6/18.
 */
public class ResultPageSteps {

    private ResultPage resultPage;

    public ResultPageSteps(WebDriver webDriver){
        WebPageFactory factory = new WebPageFactory();
        resultPage = factory.get(webDriver, ResultPage.class);
    }

    public ResultPageSteps setBudgetInFilter(String price) {
        resultPage.filterPrices()
                .filter(filterPrice->filterPrice.getText().contains(price))
                .get(0)
                .click();
        return this;
    }

    public ResultPageSteps setScoreInFilter(String score) {
        resultPage.filterScores()
                .filter(filterScore->filterScore.getText().contains(score))
                .get(0)
                .click();
        return this;
    }

    public ResultPageSteps checkHotelsDisplayedInResult() {
        resultPage.overlayMessage().waitUntil(not(displayed()));
        ExtendedList<HotelItem> hotels = resultPage.hotelList().should(everyItem(displayed()));
        String firstHotelName = hotels.get(0).hotelName().getText();
        System.out.println(firstHotelName);
        return this;
    }
}
