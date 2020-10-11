package com.selenide.tasks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProductPageTest extends BasePage {

    @Test
    public void eachProductsShouldContainImageTitleAndCheckbox() {
        open(productUrl);
        ElementsCollection productsList = $$("div[class='container']");
        productsList.shouldHaveSize(8);
        for (SelenideElement el : productsList) {
            el.findElement(By.cssSelector("img[src*='image']")).isEnabled();
            el.findElement(By.cssSelector("input[type*='checkbox']")).isEnabled();
            el.findElement(By.xpath("//div[contains(text(),'LG')]")).isEnabled();
        }
    }

    @Test
    public void verifyCheckboxes() {
        open(productUrl);
        $(By.xpath("//span[contains(text(),'Selected:')]//following-sibling::span ")).text().equals(0);
        ElementsCollection productsList = $$("div[class='container']");
        productsList.shouldHaveSize(8);
        for (int i = 0; i < productsList.size(); i++) {
            productsList.get(i).findElement(By.cssSelector("input[type*='checkbox']")).click();
            for (int j = i; j <= i; j++) {
                $(By.xpath("//span[contains(text(),'Selected:')]//following-sibling::span ")).text().equals(j++);
            }
        }
        $(byText("Reset selection")).click();
        $(By.xpath("//span[contains(text(),'Selected:')]//following-sibling::span ")).text().equals(0);
    }


    @Test
    public void checkSelectUHDValues() {
        open(productUrl);
        $(By.xpath("//span[contains(text(),'Selected:')]//following-sibling::span ")).text().equals(0);

        $(byText("Select only UHD")).click();
        $(By.xpath("//span[contains(text(),'Selected:')]//following-sibling::span ")).text().equals(2);
        $$("div[class='container']").filterBy(text("UHD")).shouldHaveSize(2);

        $(byText("Reset selection")).click();
        $(By.xpath("//span[contains(text(),'Selected:')]//following-sibling::span ")).text().equals(0);
    }

    @Test
    public void userCanOpenIOSAndAndroidPageForProducts() {
        open(productUrl);

        $("img[src*='ios']").shouldBe();
        $(byText("iOS")).click();
        waitUntilPagesIsLoaded();
        WebDriverRunner.url().equals("https://www.apple.com/");
        getWebDriver().navigate().back();

        $("img[src*='android']").shouldBe();
        $(byText("Android")).click();
        waitUntilPagesIsLoaded();
        WebDriverRunner.url().equals("https://www.google.com/ ");
    }

    @Test
    public void userCanOpenBestAndNewProductPages() {
        open(productUrl);

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

