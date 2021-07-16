package automation.qa.ui.questions;

import automation.qa.ui.user_interface.HomePage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class HomeQuestions {

    public static Question<String> title() {
        return actor -> Text.of(HomePage.TITLE)
                .viewedBy(actor).asString();
    }
}
