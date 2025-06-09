package steps;
import interactions.WaitForSeconds;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.*;
import questions.ArticleContentQuestion;
import abilities.SearchOnWebsite;
import ui.VNExpressPageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static org.hamcrest.Matchers.containsString;

public class VNExpressSteps {
    @Managed
    WebDriver driver;

    private Actor actor;

    @Given("{actor} can browse the web")
    public void actor_can_browse_the_web(Actor actor) {
        this.actor = actor;
        actor.whoCan(BrowseTheWeb.with(driver));
        actor.whoCan(SearchOnWebsite.effectively());
    }

    @When("he opens Google homepage")
    public void he_opens_google_homepage() {
        actor.attemptsTo(OpenGoogleHomepage.successfully());
    }

    @When("he searches for {string} on Google")
    public void he_searches_for_on_google(String searchTerm) {
        actor.attemptsTo(SearchForOnGoogle.withTerm(searchTerm));
    }

    @When("he clicks on VNExpress website")
    public void he_clicks_on_vnexpress_website() {
        actor.attemptsTo(ClickVNExpressLink.fromSearchResults());
    }

    @When("he navigates to {string} section")
    public void he_navigates_to_section(String section) {
        actor.attemptsTo(NavigateToSection.named(section));
    }

    @When("he scrolls down {int} times")
    public void he_scrolls_down_times(int times) {
        actor.attemptsTo(ScrollPageDown.times(times));
    }

    @When("he opens search function")
    public void he_opens_search_function() {
        actor.attemptsTo(OpenSearchFunction.onVNExpress());
    }

    @When("he searches for {string} on VNExpress")
    public void he_searches_for_on_vnexpress(String searchTerm) {
        actor.attemptsTo(SearchForOnVNExpress.withTerm(searchTerm));
    }

    @When("he clicks on the first article")
    public void he_clicks_on_the_first_article() {
        actor.attemptsTo(WaitForSeconds.of(5000),
                ClickFirstArticle.fromSearchResults());
    }

    @Then("he should see {string} mentioned in the article")
    public void he_should_see_mentioned_in_the_article(String expectedText) {
        actor.attemptsTo(WaitForSeconds.of(5000));
        actor.should(seeThat(
                ArticleContentQuestion.fromXPath("(//h3[contains(@class, 'title-news')])[1]"),
                containsString(expectedText)
        ));
    }
}
