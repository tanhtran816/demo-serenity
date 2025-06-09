package interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenUrl implements Interaction {
    private final String url;

    public OpenUrl(String url) {
        this.url = url;
    }

    @Override
    @Step("{0} opens URL: #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static OpenUrl at(String url) {
        return new OpenUrl(url);
    }
}
