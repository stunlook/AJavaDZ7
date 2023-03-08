package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement card1TopUpButton = $x("//*[@data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']/button");
    private SelenideElement card2TopUpButton = $x("//*[@data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']/button");
    private SelenideElement yourCardsHeading = $x("//h1");



    public DashboardPage() {
        heading.shouldBe(visible);}

    public TransferPage clicksOnCard() {
        card1TopUpButton.click();
        return new TransferPage();
    }


}