package VvssUiAutomation.features.search;

import VvssUiAutomation.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void search_by_keyword_that_does_not_exist() {
        anna.is_the_home_page();
        anna.looks_for("hgkhjmnb");

        Assert.assertTrue(webdriver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[3]")).getText().equals("There were no results matching the query."));
    }

    @Test
    public void search_by_keyword_recipe() {
        anna.is_the_home_page();
        anna.looks_for("recipe");

        anna.should_see_definition("Now especially, a set of instructions for making or preparing food dishes. [from 18th c.]");
    }

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }
} 
