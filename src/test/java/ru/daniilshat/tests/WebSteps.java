package ru.daniilshat.tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open GitHub main page")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Search {repo}")
    public void searchContent(String value) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(value);
        $(".header-search-input").submit();
        $(linkText("daniilshat/daniilshat")).click();
        $(partialLinkText("Issues")).click();
    }

    @Step("Check results")
    public void someChecks() {
        $(".container-md").shouldHave(text("Welcome to issues!"));
    }
}
