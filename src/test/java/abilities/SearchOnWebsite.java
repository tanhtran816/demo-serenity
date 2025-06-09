package abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RefersToActor;

public class SearchOnWebsite implements Ability, RefersToActor {
    private Actor actor;

    public SearchOnWebsite() {}

    public static SearchOnWebsite effectively() {
        return new SearchOnWebsite();
    }

    public static SearchOnWebsite as(Actor actor) {
        if (actor.abilityTo(SearchOnWebsite.class) == null) {
            throw new IllegalStateException(actor.getName() + " does not have the ability to search on websites");
        }
        return actor.abilityTo(SearchOnWebsite.class);
    }

    public boolean canSearchOn(String website) {
        return website.equals("Google") || website.equals("VNExpress");
    }

    public String getSearchStrategy(String website) {
        switch (website) {
            case "Google":
                return "direct_search";
            case "VNExpress":
                return "site_search";
            default:
                return "unknown";
        }
    }

    @Override
    public <T extends Ability> T asActor(Actor actor) {
        if (actor instanceof Ability) {
            this.actor = actor;
            return (T) actor;
        }
        return null;
    }
}
