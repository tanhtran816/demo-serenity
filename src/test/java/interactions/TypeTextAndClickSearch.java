package interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import ui.VNExpressPageElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TypeTextAndClickSearch implements Interaction {
    private final String text;
    private Target target;

    public TypeTextAndClickSearch(String text) {
        this.text = text;
    }

    @Override
    @Step("{0} types '#text' and presses Enter")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(text).into(target),
                Click.on(VNExpressPageElements.SEARCH_BUTTON)
        );
    }

    public static TypeTextAndClickSearch withText(String text) {
        return new TypeTextAndClickSearch(text);
    }

    public TypeTextAndClickSearch into(Target target) {
        this.target = target;
        return this;
    }
}
