package webElements;

import io.qameta.htmlelements.element.ExtendedWebElement;
import org.hamcrest.Matcher;

/**
 * Created by zsmirnova on 4/6/18.
 */
//It is used for adding new methods {is(), selectValue()} that are not available in the interface ExtendedWebElement
public interface ExtendedMineWebElement<FluentType>  extends ExtendedWebElement<FluentType> {

    @IsMethod
    boolean is(Matcher matcher);

    @SelectValue
    void selectValue(String value);
}
