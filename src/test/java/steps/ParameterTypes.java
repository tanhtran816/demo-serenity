package steps;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;

public class ParameterTypes {
    @ParameterType(".*")
    public Actor actor(String actorName) {
        return Actor.named(actorName);
    }
}
