package automation.qa.ui.tasks;

import automation.qa.ui.user_interface.HomePage;
import automation.qa.ui.user_interface.SingUpPage;
import lombok.Data;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


@Data
public class SingUp implements Task {

    private final String userName;
    private final String userPassword;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_SINGUP),
                Click.on(SingUpPage.USER_NAME),
                Enter.theValue(userName).into(SingUpPage.USER_NAME),
                Click.on(SingUpPage.USER_PASSWORD),
                Enter.theValue(userPassword).into(SingUpPage.USER_PASSWORD),
                Click.on(SingUpPage.BTN_SINGUP)
        );
    }

    public static Performable withSingUpData(
            String userName,
            String userPassword) {
        return Instrumented.instanceOf(SingUp.class)
                .withProperties(
                        userName,
                        userPassword);
    }

}
