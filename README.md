# TestForBooking

Using testing tools: framework htmlelemnts (https://github.com/eroshenkoam/htmlelements)  + jUnit4 + hamcrest + maven. 

### Patterns in project: 
1. ***Page Object*** - htmlelements easily allows you to organize a structure page object. Pages is devided on blocks in which used relative xpath.
##### Example from project:
```
@BaseUrl("https://www.booking.com/")
public interface BookingMainPage extends WebPage {

    @Description("Header panel")
    @FindBy("//div[contains(@class, 'header-wrapper')]")
    HeaderPanel headerPanel();

    @Description("Search Block")
    @FindBy("//form[contains(@class, 'sb-searchbox')]")
    SearchBlock searchBlock();
}
```
2. ***Steps*** - the entire business logic of the test is transferred to the folder of the step. All actions are taken in the methods

3. ***Page Factory*** - it was implemented as WebPageFactory() by htmlelements. It allows returning WebPage instances that are wrapped around the given driver.
##### Example from project:
```
public MainBookingPageSteps(WebDriver webDriver){
        WebPageFactory factory = new WebPageFactory();
        bookingMainPage = factory.get(webDriver, BookingMainPage.class);
    }
```

4. ***Fluent*** - using in steps classes. methods return a reference to the step class for the ability to invoke methods sequentially in tests. 
##### Example from project:
```
 mainBookingPageSteps
                .setCurrency("Euro")
                .setLanguage("English (US)")
                .inputDestination("Málaga, Andalucía, Spain")
```




