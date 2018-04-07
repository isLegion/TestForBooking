package booking.pages;

import booking.blocks.HeaderPanel;
import booking.blocks.SearchBlock;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.extension.page.BaseUrl;

/**
 * Created by zsmirnova on 4/6/18.
 */
@BaseUrl("https://www.booking.com/")
public interface BookingMainPage extends WebPage {

    @Description("Header panel")
    @FindBy("//div[contains(@class, 'header-wrapper')]")
    HeaderPanel headerPanel();

    @Description("Search Block")
    @FindBy("//form[contains(@class, 'sb-searchbox')]")
    SearchBlock searchBlock();



}
