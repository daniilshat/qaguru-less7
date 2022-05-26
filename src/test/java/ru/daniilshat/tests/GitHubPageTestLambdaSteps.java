package ru.daniilshat.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.daniilshat.pages.GitHubPage;

import static io.qameta.allure.Allure.step;

public class GitHubPageTestLambdaSteps {
    // variables
    String searchQuery = "daniilshat/daniilshat";

    GitHubPage ghp = new GitHubPage();

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

        step("Open GitHub main page", () -> {
           ghp.openPage();
        });

        step("Search " + searchQuery, () -> {
            ghp.searchQueryExecution(searchQuery);
        });

        step("Check results", () -> {
            ghp.checkContent();
        });
    }
}
