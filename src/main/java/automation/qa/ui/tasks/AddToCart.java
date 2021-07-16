package automation.qa.ui.tasks;

import automation.qa.ui.user_interface.HomePage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.apache.commons.lang3.StringUtils;

public class AddToCart implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.CATEGORY),
                Click.on(HomePage.PRODUCT));

    }

    public static AddToCart addToCartProcess() {
        return Instrumented.instanceOf(AddToCart.class).withProperties(StringUtils.EMPTY);
    }
}
