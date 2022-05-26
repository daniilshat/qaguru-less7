package ru.daniilshat.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.daniilshat.pages.GitHubPage;

public class GitHubPageTestStepAnnotation {
    // variables
    String searchQuery = "daniilshat/daniilshat";


    //preparing
    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    public void testGitHubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchContent(searchQuery);
        steps.someChecks();

    }

}
