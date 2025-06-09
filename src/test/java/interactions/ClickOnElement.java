package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickOnElement implements Interaction {
    private final Target target;

    public ClickOnElement(Target target) {
        this.target = target;
    }

    @Override
    @Step("{0} clicks on element: #target")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(target)
        );
    }

    public static ClickOnElement located(Target target) {
        return new ClickOnElement(target);
    }
}
