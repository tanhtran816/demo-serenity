package ui;

import net.serenitybdd.screenplay.targets.Target;

public class GooglePageElements {

    public static final Target SEARCH_BOX = Target.the("Google search box")
            .locatedBy("//textarea[@class='gLFyf']");

    public static final Target SEARCH_BUTTON = Target.the("Google search button")
            .locatedBy("input[value='Google Search']");

    public static final Target VNEXPRESS_LINK = Target.the("VNExpress link in search results")
            .locatedBy("//a[contains(@href, 'vnexpress.net')]");
}
