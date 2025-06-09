package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollPage implements Interaction {
    private final int numberOfTimes;

    public ScrollPage(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    @Override
    @Step("{0} scrolls page down #numberOfTimes times")
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();

        for (int i = 0; i < numberOfTimes; i++) {
            js.executeScript("window.scrollBy(0, 800);");
            try {
                Thread.sleep(1000); // Wait between scrolls
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static ScrollPage down(int numberOfTimes) {
        return new ScrollPage(numberOfTimes);
    }
}
