package ui;

import net.serenitybdd.screenplay.targets.Target;

public class VNExpressPageElements {

    public static final Target THOI_SU_SECTION = Target.the("Thời sự section")
            .locatedBy("//a[contains(text(), 'Thời sự') or contains(@title, 'Thời sự')]");

    public static final Target SEARCH_ICON = Target.the("Search icon")
            .locatedBy("//i[@class='ic ic-search'] | //span[contains(@class, 'search')] | //button[contains(@class, 'search')]");

    public static final Target SEARCH_INPUT = Target.the("Search input field")
            .locatedBy("//input[@placeholder='Tìm kiếm' or @name='q' or contains(@class, 'search')]");

    public static final Target FIRST_ARTICLE = Target.the("First article in search results")
            .locatedBy("(//h3[contains(@class, 'title-news')])[1]");

    public static final Target ARTICLE_CONTENT = Target.the("Article content")
            .locatedBy("//article//p | //div[@class='Normal']//p | //div[contains(@class, 'fck_detail')]");

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .locatedBy("//button[contains(@class,'btn-search-vne')]");
}
