package com.selenide.tasks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    String aboutUrl = "https://testautoqa.000webhostapp.com/about.html";
    String deliveryUrl = "https://testautoqa.000webhostapp.com/delivery.html";
    String productUrl = "https://testautoqa.000webhostapp.com/products.html";
    String welcomeUrl = "https://testautoqa.000webhostapp.com/welcome.html";

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    protected static void waitUntilPagesIsLoaded() {
        $(byText("Loading")).waitUntil(disappears, 20000);
    }
}