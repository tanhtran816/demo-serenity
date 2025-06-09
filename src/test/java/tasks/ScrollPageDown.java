package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.ScrollPage;

public class ScrollPageDown implements Task {
    private final int numberOfTimes;

    public ScrollPageDown(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    @Override
    @Step("{0} scrolls page down #numberOfTimes times")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollPage.down(numberOfTimes)
        );
    }

    public static ScrollPageDown times(int numberOfTimes) {
        return Tasks.instrumented(ScrollPageDown.class, numberOfTimes);
    }
}
