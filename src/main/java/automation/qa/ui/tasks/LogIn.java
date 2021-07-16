package automation.qa.ui.tasks;

import automation.qa.ui.user_interface.HomePage;
import automation.qa.ui.user_interface.LogInPage;
import automation.qa.ui.user_interface.SingUpPage;
import lombok.Data;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import sun.rmi.runtime.Log;

@Data
public class LogIn implements Task {

    private final String userNameL;
    private final String userPasswordL;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_LOGIN),
                Click.on(LogInPage.USER_NAME),
                Enter.theValue(userNameL).into(LogInPage.USER_NAME),
                Click.on(LogInPage.USER_PASSWORD),
                Enter.theValue(userPasswordL).into(LogInPage.USER_PASSWORD),
                Click.on(LogInPage.BTN_LOGIN)
        );
    }
    public static Performable withLogInData(
            String userNameL,
            String userPasswordL) {
        return Instrumented.instanceOf(LogIn.class)
                .withProperties(
                        userNameL,
                        userPasswordL);
    }

}
