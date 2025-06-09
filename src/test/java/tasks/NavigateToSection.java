package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.ClickOnElement;
import ui.VNExpressPageElements;

public class NavigateToSection implements Task {
    private final String sectionName;

    public NavigateToSection(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    @Step("{0} navigates to '#sectionName' section")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOnElement.located(VNExpressPageElements.THOI_SU_SECTION)
        );
    }

    public static NavigateToSection named(String sectionName) {
        return Tasks.instrumented(NavigateToSection.class, sectionName);
    }
}
