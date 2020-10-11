package com.selenide.tasks;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WelcomePageTest extends BasePage {

    @Test
    public void userCanOpenTaskPageFromWelcomePage() {
        open(welcomeUrl);
        $(byXpath("//a[contains(text(), 'Products')]")).shouldBe();
        $(byXpath("//a[contains(text(), 'About')]")).shouldBe();
        $(byXpath("//a[contains(text(), 'Delivery')]")).shouldBe();
        $(byXpath("//a[contains(text(), 'Products')]")).click();
        WebDriverRunner.url().equals(aboutUrl);
    }
}