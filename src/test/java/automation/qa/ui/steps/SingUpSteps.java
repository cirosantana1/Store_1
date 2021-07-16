package automation.qa.ui.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import automation.qa.ui.dtos.SingUpData;
import automation.qa.ui.questions.HomeQuestions;
import automation.qa.ui.tasks.SingUp;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import java.util.List;
import java.util.Map;


public class SingUpSteps {

    @DataTableType
    public SingUpData convertSingUp (Map<String, String> entry){
        return new SingUpData(
                entry.get("nombre"),
                entry.get("password"));
    }

    @Cuando("Digita la informacion para registrarse")
    public void digitaLaInformacionParaRegistrarse(List<SingUpData> singUpDataList) {
        theActorInTheSpotlight()
                .attemptsTo(
                        SingUp.withSingUpData(
                                singUpDataList.get(0).userName,
                                singUpDataList.get(0).userPassword));
    }

    @Entonces("El sistema le mostrara un mensaje exitoso")
    public void elSistemaLeMostraraUnMensajeExitoso() {
        theActorInTheSpotlight().should(seeThat(HomeQuestions.title()));
    }
}
