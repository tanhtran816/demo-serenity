package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.TypeTextAndPressEnter;
import ui.GooglePageElements;
import abilities.SearchOnWebsite;

public class SearchForOnGoogle implements Task {
    private final String searchTerm;

    public SearchForOnGoogle(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    @Step("{0} searches for '#searchTerm' on Google")
    public <T extends Actor> void performAs(T actor) {
        SearchOnWebsite searchAbility = SearchOnWebsite.as(actor);

        if (searchAbility.canSearchOn("Google")) {
            actor.attemptsTo(
                    TypeTextAndPressEnter.withText(searchTerm)
                            .into(GooglePageElements.SEARCH_BOX)
            );
        }
    }

    public static SearchForOnGoogle withTerm(String searchTerm) {
        return Tasks.instrumented(SearchForOnGoogle.class, searchTerm);
    }
}
