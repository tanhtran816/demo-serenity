package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class WaitForSeconds implements Interaction {
    private final int seconds;

    public WaitForSeconds(int seconds) {
        this.seconds = seconds;
    }

    public static WaitForSeconds of(int seconds) {
        return Tasks.instrumented(WaitForSeconds.class, seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
