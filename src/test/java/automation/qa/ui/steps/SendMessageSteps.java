package automation.qa.ui.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import automation.qa.ui.dtos.ContactData;
import automation.qa.ui.questions.HomeQuestions;
import automation.qa.ui.tasks.*;
import automation.qa.ui.user_interface.ContactPopUpPage;
import automation.qa.ui.user_interface.HomePage;



import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class SendMessageSteps {

        @DataTableType
        public ContactData convertContact (Map<String, String> entry){
            return new ContactData(
                    entry.get("email"),
                    entry.get("nombre"),
                    entry.get("mensaje"));
        }

    @Managed public WebDriver hisBrowser;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("Que {} es un usuario que ingresa al portal")
    public void queJuanEsUnUsuarioQueIngresaAlPortal(String userName) {
        hisBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       theActorCalled(userName).can(BrowseTheWeb.with(hisBrowser));
        theActorInTheSpotlight().attemptsTo(StartFlow.a("INICIO"));
        theActorInTheSpotlight().should(seeThat(
                "Titulo",
                HomeQuestions.title()));

    }

    @Cuando("Digita la informacion para enviar el mensaje")
    public void digitaLaInformacionParaEnviarElMensaje(List<ContactData> contactDataList) {
        theActorInTheSpotlight()
                .attemptsTo(
                        Contact.withContactData(
                                contactDataList.get(0).ContactEmail,
                                contactDataList.get(0).ContactName,
                                contactDataList.get(0).Message));
    }

    @Entonces("El sistema le mostrara un mensaje indicando el estado de la transaccion")
    public void elSistemaLeMostraraUnMensajeIndicandoElEstadoDeLaTransaccion() {
        WaitUntil.the(ContactPopUpPage.BTN_SENDM, isPresent()).forNoMoreThan(30).seconds();
        theActorInTheSpotlight().should(seeThat(HomeQuestions.title()));
    }


    }
