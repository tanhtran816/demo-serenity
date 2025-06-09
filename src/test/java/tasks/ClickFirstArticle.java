package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.ClickOnElement;
import ui.VNExpressPageElements;

public class ClickFirstArticle implements Task {
    @Override
    @Step("{0} clicks on the first article from search results")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOnElement.located(VNExpressPageElements.FIRST_ARTICLE)
        );
    }

    public static ClickFirstArticle fromSearchResults() {
        return Tasks.instrumented(ClickFirstArticle.class);
    }
}
