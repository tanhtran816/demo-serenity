package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.ClickOnElement;
import ui.VNExpressPageElements;

public class OpenSearchFunction implements Task {

    @Override
    @Step("{0} opens search function on VNExpress")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOnElement.located(VNExpressPageElements.SEARCH_ICON)
        );
    }

    public static OpenSearchFunction onVNExpress() {
        return Tasks.instrumented(OpenSearchFunction.class);
    }
}
