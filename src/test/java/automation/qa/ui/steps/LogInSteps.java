package automation.qa.ui.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import automation.qa.ui.dtos.LogInData;
import automation.qa.ui.dtos.SingUpData;
import automation.qa.ui.questions.HomeQuestions;
import automation.qa.ui.tasks.LogIn;
import automation.qa.ui.tasks.SingUp;
import automation.qa.ui.user_interface.LogInPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import java.util.List;
import java.util.Map;

public class LogInSteps {

    @DataTableType
    public LogInData convertLogIn (Map<String, String> entry){
        return new LogInData(
                entry.get("nombre"),
                entry.get("password"));
    }

    @Cuando("Digita la informacion para autenticarse")
    public void digitaLaInformacionParaAutenticarse(List<LogInData> logInDataList) {
        theActorInTheSpotlight()
                .attemptsTo(
                        LogIn.withLogInData(
                                logInDataList.get(0).userNameL,
                                logInDataList.get(0).userPasswordL));
    }

    @Entonces("El sistema le mostrara un mensaje exitoso al autenticarse")
    public void elSistemaLeMostraraUnMensajeExitosoAlAutenticarse() {
        theActorInTheSpotlight().should(seeThat(HomeQuestions.title()));
        theActorInTheSpotlight()
                .should(seeThat(the(LogInPage.LABEL_NAME), WebElementStateMatchers.isVisible()));
    }

}
