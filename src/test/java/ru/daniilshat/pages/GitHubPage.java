package ru.daniilshat.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GitHubPage {
    //locators
    SelenideElement searchBar = $(".header-search-input");
    SelenideElement linkTxtSearchBar = $(linkText("daniilshat/daniilshat"));
    SelenideElement issuesBar = $(partialLinkText("Issues"));
    SelenideElement repoBlock = $(".container-md");

    // actions
    public GitHubPage openPage() {
        open(baseUrl);
        return this;
    }

    public GitHubPage searchQueryExecution(String query) {
        searchBar.click();
        searchBar.sendKeys(query);
        searchBar.submit();
        linkTxtSearchBar.click();
        issuesBar.click();
        return this;
    }

    public GitHubPage checkContent() {
        repoBlock.shouldHave(text("Welcome to issues!"));
        return this;
    }
}
