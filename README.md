# TestForBooking

Using testing tools: **Selenium + htmlelemnts2 (https://github.com/eroshenkoam/htmlelements) + jUnit4 + hamcrest + maven.** 

### Project contains:
1. Two pages : BookingMainPage(page when we open booking.com) and ResultPage(page after click 'search')
2. Two step classes : MainBookingPageSteps and ResultPageSteps
3. Folder 'blocks' which contains blocks in pages
4. Instance of webdriver is in BaseTest

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

4. ***Fluent*** - used in steps classes. methods return a reference to the step class for the ability to invoke methods sequentially in tests. 
##### Example from project:
```
 mainBookingPageSteps
                .setCurrency("Euro")
                .setLanguage("English (US)")
                .inputDestination("Málaga, Andalucía, Spain")
```

### What else could I use to improve the project?

1. **WebDriverManager** (https://github.com/bonigarcia/webdrivermanager) - for more convenient work with the webdriver 
2. **Spring** (http://www.baeldung.com/spring-autowire) - for using @Autowired for inject WebDriverManage, steps classes in test classes
3. **Allure** (https://github.com/allure-framework/allure2) - for creating reports
4. **Value object pattern** - for senting value Object instead set of parameters in method (if you using method with many paramenters)
5. **Object pool pattern** - for creating  instanse of DB, browser, pages before running tests (if we have a lot of tests)
6. **Add config file** - for setup different parameters for size of browser, environment
7. **Log4j** (https://github.com/apache/log4j) - for logging a steps


