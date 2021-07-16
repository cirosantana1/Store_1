package automation.qa.ui.tasks;


import automation.qa.ui.user_interface.ContactPopUpPage;
import automation.qa.ui.user_interface.HomePage;
import lombok.Data;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


@Data
public class Contact implements Task {

    private final String contactEmail;
    private final String contactName;
    private final String message;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_CONTACT),
                Click.on(ContactPopUpPage.EMAIL_CONTACT),
                Enter.theValue(contactEmail).into(ContactPopUpPage.EMAIL_CONTACT),
                Click.on(ContactPopUpPage.NAME_CONTACT),
                Enter.theValue(contactName).into(ContactPopUpPage.NAME_CONTACT),
                Click.on(ContactPopUpPage.MESSAGE),
                Enter.theValue(message).into(ContactPopUpPage.MESSAGE),
                Click.on(ContactPopUpPage.BTN_SENDM)
        );
    }


    public static Performable withContactData(
            String contactEmail,
            String contactName,
            String message) {
        return Instrumented.instanceOf(Contact.class)
                .withProperties(
                        contactEmail,
                        contactName,
                        message);
    }
}
