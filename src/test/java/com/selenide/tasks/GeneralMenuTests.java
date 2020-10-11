package com.selenide.tasks;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.selenide.tasks.Colors.GREY;

public class GeneralMenuTests extends BasePage {

    @Test
    public void userCanOpenDifferentPagesFromTopBarMenu() {
        open(aboutUrl);
        $(byText("About")).getAttribute("class").contains("active");
        $(byText("About")).getCssValue("background-color").equals(GREY.rgba);

        $(byText("Products")).click();
        $(byText("Products")).getAttribute("class").contains("active");
        $(byText("Products")).getCssValue("background-color").equals(GREY.rgba);
        WebDriverRunner.url().equals(productUrl);

        $(byText("Delivery")).click();
        $(byText("Delivery")).getAttribute("class").contains("active");
        $(byText("Delivery")).getCssValue("background-color").equals(GREY);
        WebDriverRunner.url().equals(deliveryUrl);
    }
}
