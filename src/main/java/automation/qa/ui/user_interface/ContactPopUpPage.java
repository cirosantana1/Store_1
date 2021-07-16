package automation.qa.ui.user_interface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class ContactPopUpPage {
    public static final Target EMAIL_CONTACT = Target
            .the("Correo Contacto")
            .located(By.xpath("//input[@id='recipient-email']"));
    public static final Target NAME_CONTACT = Target
            .the("Nombre Contacto")
            .located(By.xpath("//input[@id='recipient-name']"));
    public static final Target MESSAGE = Target
            .the("Mensaje")
            .located(By.xpath("//textarea[@id='message-text']"));
    public static final Target BTN_SENDM = Target
            .the("Registro")
            .located(By.xpath("//button[contains(text(),'Send message')]"));
}
