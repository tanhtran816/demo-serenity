package tasks;
import interactions.TypeTextAndClickSearch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import interactions.TypeTextAndPressEnter;
import ui.VNExpressPageElements;
import abilities.SearchOnWebsite;

public class SearchForOnVNExpress implements Task {
    private final String searchTerm;

    public SearchForOnVNExpress(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    @Step("{0} searches for '#searchTerm' on VNExpress")
    public <T extends Actor> void performAs(T actor) {
        SearchOnWebsite searchAbility = SearchOnWebsite.as(actor);

        if (searchAbility.canSearchOn("VNExpress")) {
            actor.attemptsTo(
                    TypeTextAndClickSearch.withText(searchTerm)
                            .into(VNExpressPageElements.SEARCH_INPUT)
            );
        }
    }

    public static SearchForOnVNExpress withTerm(String searchTerm) {
        return Tasks.instrumented(SearchForOnVNExpress.class, searchTerm);
    }
}
