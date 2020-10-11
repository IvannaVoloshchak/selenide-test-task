package com.selenide.tasks;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.selenide.tasks.Colors.RED;

public class AboutPageTest extends BasePage {

    @Test
    public void pageMarkerTextAdvertisementImageAndMessageShouldBe() {
        open(aboutUrl);
        $(byXpath("//*[contains(text(),'Lorem Ipsum')]")).text().contains("PageMaker");
        $("*[class='ad']").getCssValue("background-image").contains("ad.png");
        $("div[data-id*='contactMessage']").getCssValue("background-color").equals(RED.rgba);
        $("div[data-id*='contactMessage']").text().equals("If you have any further questions, please do not hesitate to contact us.");
    }

    @Test
    public void userCanOpenIOSAndAndroidPage() {
        open(aboutUrl);

        $("img[src*='ios']").shouldBe();
        $(byText("iOS")).click();
        waitUntilPagesIsLoaded();
        WebDriverRunner.url().equals("https://www.apple.com/");
        getWebDriver().navigate().back();

        $("img[src*='android']").shouldBe();
        $(byText("Android")).click();
        waitUntilPagesIsLoaded();
        WebDriverRunner.url().equals("https://www.google.com/");
    }
}