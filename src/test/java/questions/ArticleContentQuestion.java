package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticleContentQuestion implements Question<String> {
    private final String xpath;

    public ArticleContentQuestion(String xpath) {
        this.xpath = xpath;
    }

    @Override
    @Step("{0} reads the content from XPath: #xpath")
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText();
    }

    public static Question<String> fromXPath(String xpath) {
        return new ArticleContentQuestion(xpath);
    }
}
