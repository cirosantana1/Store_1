package automation.qa.ui.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import automation.qa.ui.utils.UtlManageConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class StartFlow implements Task {

    private String homePage;
    public StartFlow(String initPage) {
        switch (initPage.toUpperCase()) {
            case "INICIO":
                homePage = UtlManageConfig.INICIO_PAGE;
                break;
        }
    }

    @Step("{0}Se inicia el proceso de tarjeta de credito por el canal escogido")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(homePage));
    }

    public static Performable a(String initPage) {
        return instrumented(StartFlow.class, initPage);
    }
}
