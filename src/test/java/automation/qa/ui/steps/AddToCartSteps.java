package automation.qa.ui.steps;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import automation.qa.ui.dtos.ContactData;
import automation.qa.ui.dtos.ProductData;
import automation.qa.ui.dtos.SingUpData;
import automation.qa.ui.questions.HomeQuestions;
import automation.qa.ui.tasks.AddToCart;
import automation.qa.ui.tasks.Contact;
import automation.qa.ui.tasks.Product;
import automation.qa.ui.tasks.SingUp;
import automation.qa.ui.user_interface.ContactPopUpPage;
import automation.qa.ui.user_interface.HomePage;
import automation.qa.ui.user_interface.ProductDetailPage;
import automation.qa.ui.user_interface.ProductsPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;


public class AddToCartSteps {

    @DataTableType
    public ProductData convertProduct (Map<String, String> entry){
        return new ProductData(
                entry.get("nombre"),
                entry.get("pais"),
                entry.get("ciudad"),
                entry.get("tarjeta"),
                entry.get("mes"),
                entry.get("año"));
    }

    @Cuando("{} selecciona el producto a comprar")
    public void joseSeleccionaElProductoAComprar(String username) {
        theActorInTheSpotlight().attemptsTo(AddToCart.addToCartProcess());
    }

    @Entonces("El sistema le muestra el detalle del producto")
    public void elSistemaLeMuestraElDetalleDelProducto() {
        WaitUntil.the(ProductDetailPage.NAME_PRODUCT, isPresent()).forNoMoreThan(30).seconds();
        theActorInTheSpotlight().attemptsTo(Click.on(ProductDetailPage.BTN_TO_CARD));
    }


    @Cuando("{} seleccione la opcion para agregar al carrito")
    public void joseSeleccioneLaOpcionParaAgregarAlCarrito(List<ProductData> productDataList) {

        theActorInTheSpotlight()
                .attemptsTo(
                        Product.withProductsData(
                                productDataList.get(0).userName,
                                productDataList.get(0).userCountry,
                                productDataList.get(0).userCity,
                                productDataList.get(0).userCreditCard,
                                productDataList.get(0).month,
                                productDataList.get(0).year));
    }

    @Entonces("Podra continuar a registrar la informacion de la compra")
    public void podraContinuarARegistrarLaInformacionDeLaCompra() {
        WaitUntil.the(ProductsPage.BTN_OK, isPresent()).forNoMoreThan(30).seconds();
    }
}
