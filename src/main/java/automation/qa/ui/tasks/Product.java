package automation.qa.ui.tasks;

import automation.qa.ui.user_interface.HomePage;
import automation.qa.ui.user_interface.ProductsPage;
import lombok.Data;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.StringUtils;

@Data
public class Product implements Task{

    private final String userName;
    private final String userCountry;
    private final String userCity;
    private final String userCreditCard;
    private final String month;
    private final String year;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.CATEGORY),
                Click.on(HomePage.PRODUCT));

        actor.attemptsTo(
                Click.on(ProductsPage.BTN_ORDER),
                Click.on(ProductsPage.NAME),
                Enter.theValue(userName).into(ProductsPage.NAME),
                Click.on(ProductsPage.COUNTRY),
                Enter.theValue(userCountry).into(ProductsPage.COUNTRY),
                Click.on(ProductsPage.CITY),
                Enter.theValue(userCity).into(ProductsPage.CITY),
                Click.on(ProductsPage.CREDIT_CARD),
                Enter.theValue(userCreditCard).into(ProductsPage.CREDIT_CARD),
                Click.on(ProductsPage.MONTH),
                Enter.theValue(month).into(ProductsPage.MONTH),
                Click.on(ProductsPage.YEAR),
                Enter.theValue(year).into(ProductsPage.YEAR),
                Click.on(ProductsPage.BTN_PURCHASE)
        );


    }

    public static Performable withProductsData(
            String userName,
            String userCountry,
            String userCity,
            String userCreditCard,
            String month,
            String year) {
        return Instrumented.instanceOf(Product.class)
                .withProperties(
                        userName,
                        userCountry,
                        userCity,
                        userCreditCard,
                        month,
                        year);
    }

}
