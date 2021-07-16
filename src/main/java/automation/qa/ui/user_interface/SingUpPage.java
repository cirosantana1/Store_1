package automation.qa.ui.user_interface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class SingUpPage {
    public static final Target USER_NAME = Target
            .the("Nombre Usuario")
            .located(By.xpath("//input[@id='sign-username']"));
    public static final Target USER_PASSWORD = Target
            .the("Contraseña")
            .located(By.xpath("//input[@id='sign-password']"));
    public static final Target BTN_SINGUP = Target
            .the("Registro")
            .located(By.xpath("//button[contains(text(),'Sign up')]"));
}
