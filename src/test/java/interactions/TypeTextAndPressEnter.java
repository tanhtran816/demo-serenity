package interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TypeTextAndPressEnter implements Interaction {
    private final String text;
    private Target target;

    public TypeTextAndPressEnter(String text) {
        this.text = text;
    }

    @Override
    @Step("{0} types '#text' and presses Enter")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(text).into(target).thenHit(Keys.ENTER)
        );
    }

    public static TypeTextAndPressEnter withText(String text) {
        return new TypeTextAndPressEnter(text);
    }

    public TypeTextAndPressEnter into(Target target) {
        this.target = target;
        return this;
    }
}
