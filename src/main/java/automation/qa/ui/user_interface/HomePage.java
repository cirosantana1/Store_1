package automation.qa.ui.user_interface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class HomePage {
    public static final Target BTN_CONTACT = Target
            .the("Contacto")
            .located(By.xpath("//a[contains(text(),'Contact')]"));
    public static final Target BTN_LOGIN = Target
            .the("Autenticacion")
            .located(By.xpath("//a[@id='login2']"));
    public static final Target BTN_SINGUP = Target
            .the("Registro")
            .located(By.xpath("//a[@id='signin2']"));
    public static final Target BTN_CART = Target
            .the("Carrito")
            .located(By.xpath("//a[@id='cartur']"));
    public static final Target TITLE = Target
            .the("Titulo")
            .located(By.xpath("//a[@id='nava']"));
    public static final Target CATEGORY = Target
            .the("Categoria")
            .located(By.xpath("//a[contains(text(),'Monitors')]"));
    public static final Target PRODUCT = Target
            .the("Producto")
            .located(By.xpath("//a[contains(text(),'Apple monitor 24')]"));
}
