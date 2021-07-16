package automation.qa.ui.user_interface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class ProductDetailPage {
    public static final Target NAME_PRODUCT = Target
            .the("Nombre Producto")
            .located(By.xpath("//font[contains(text(),'Monitor Apple 24')]"));
    public static final Target BTN_TO_CARD = Target
            .the("Agregar Carrito")
            .located(By.xpath("//a[contains(text(),'Add to cart')]"));
}
