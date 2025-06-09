package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.ClickOnElement;
import ui.GooglePageElements;

public class ClickVNExpressLink implements Task {
    @Override
    @Step("{0} clicks on VNExpress link from search results")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOnElement.located(GooglePageElements.VNEXPRESS_LINK)
        );
    }

    public static ClickVNExpressLink fromSearchResults() {
        return Tasks.instrumented(ClickVNExpressLink.class);
    }
}
