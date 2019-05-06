package VvssUiAutomation.features.search;

import VvssUiAutomation.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("C:\\Users\\Alexandra\\Desktop\\VvssUiAutomation\\src\\test\\resources\\words.csv")
public class SearchByKeywordStoryDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    public String name;
    public String description;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Test
    public void search_by_keywords_ddt() {
        anna.is_the_home_page();
        anna.looks_for(getName());

        anna.should_see_definition(getDescription());
    }
}
