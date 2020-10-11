package com.selenide.tasks;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DeliveryPageTest extends BasePage {

    @Test
    public void userCanSelectDeliveryType() {
        open(deliveryUrl);

        $(byXpath("//a[contains(text(), 'Delivery')]")).getAttribute("class").contains("active");
        $("img[src*='plane']").shouldBe();
        $(byXpath("//option[contains(text(),'plane')]")).getAttribute("selected").contains("true");

        $(By.id("picDD")).click();
        $(byXpath("//option[contains(text(),'car')]")).click();
        $("img[src*='car']").shouldBe();
        $(byXpath("//option[contains(text(),'car')]")).getAttribute("selected").contains("true");

        $(By.id("picDD")).click();
        $(byXpath("//option[contains(text(),'plane')]")).click();
        $("img[src*='plane']").shouldBe();
        $(byXpath("//option[contains(text(),'plane')]")).getAttribute("selected").contains("true");
    }

    @Test
    public void userCanOpenBestAndNewProductFromDeliveryPage() {
        open(deliveryUrl);

        $(byText("Best products")).shouldBe();
        $(byText("New products")).shouldBe();

        $(byText("Best products")).click();

        waitUntilPagesIsLoaded();
        WebDriverRunner.url().equals("https://bit.ly/2NhHZwe");
        $("input[class*='gLFyf gsfi']").getAttribute("value").contains("best products");

        getWebDriver().navigate().back();
        $(byText("New products")).click();
        waitUntilPagesIsLoaded();
        WebDriverRunner.url().equals("https://bit.ly/37O2ytt");
        $("input[class*='gLFyf gsfi']").getAttribute("value").contains("new products");
    }
}
