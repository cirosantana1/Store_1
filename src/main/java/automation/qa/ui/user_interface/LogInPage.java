package automation.qa.ui.user_interface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class LogInPage {
    public static final Target USER_NAME = Target
            .the("Nombre Usuario")
            .located(By.xpath("//input[@id='loginusername']"));
    public static final Target USER_PASSWORD = Target
            .the("Contraseña")
            .located(By.xpath("//input[@id='loginpassword']"));
    public static final Target BTN_LOGIN = Target
            .the("Log In")
            .located(By.xpath("//button[contains(text(),'Log in')]"));
    public static final Target LABEL_NAME= Target
            .the("Bienvenido")
            .located(By.xpath("//a[@id='nameofuser']"));
}
