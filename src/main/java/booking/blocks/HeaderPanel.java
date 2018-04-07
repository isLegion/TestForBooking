package booking.blocks;

import webElements.ExtendedMineWebElement;
import webElements.MineWebElement;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;

/**
 * Created by zsmirnova on 4/6/18.
 */
public interface HeaderPanel extends ExtendedMineWebElement<HeaderPanel> {

    @Description("Currency button")
    @FindBy(".//a[contains(@data-title, 'Choose your currency')]")
    MineWebElement openCurrencyButton();

    @Description("Currency {{ currency }}")
    @FindBy("//div[@class= 'select_foldout_wrap']//a[contains(@aria-label, '{{ currency }}')]")
    MineWebElement currency(@Param("currency") String currency);

    @Description("Language button")
    @FindBy(".//a[contains(@data-title, 'Select your language')]")
    MineWebElement openLanguageButton();

    @Description("Currency {{ text }}")
    @FindBy("//h4[text()='All languages']//ancestor::div[@class='select_foldout_wrap']//span[contains(., '{{ text }}')]")
    MineWebElement language(@Param("text") String text);
}
