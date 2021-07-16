package automation.qa.ui.user_interface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class ProductsPage {
    public static final Target BTN_ORDER = Target
            .the("Ordenar")
            .located(By.xpath("//button[contains(text(),'Place Order')]"));
    public static final Target NAME = Target
            .the("Nombre")
            .located(By.xpath("//input[@id='name']"));
    public static final Target COUNTRY = Target
            .the("Pais")
            .located(By.xpath("//input[@id='country']"));
    public static final Target CITY = Target
            .the("Ciudad")
            .located(By.xpath("//input[@id='city']"));
    public static final Target CREDIT_CARD = Target
            .the("Tarjeta Credito")
            .located(By.xpath("//input[@id='card']"));
    public static final Target MONTH = Target
            .the("Mes")
            .located(By.xpath("//input[@id='month']"));
    public static final Target YEAR = Target
            .the("Año")
            .located(By.xpath("//input[@id='year']"));
    public static final Target BTN_PURCHASE = Target
            .the("Compra")
            .located(By.xpath("//button[contains(text(),'Purchase')]"));
    public static final Target BTN_OK = Target
            .the("Ok")
            .located(By.xpath("//button[contains(text(),'OK')]"));
}
