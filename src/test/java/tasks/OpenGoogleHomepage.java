package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.OpenUrl;

public class OpenGoogleHomepage implements Task {
    @Override
    @Step("{0} opens Google homepage")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenUrl.at("https://www.google.com")
        );
    }

    public static OpenGoogleHomepage successfully() {
        return Tasks.instrumented(OpenGoogleHomepage.class);
    }
}
