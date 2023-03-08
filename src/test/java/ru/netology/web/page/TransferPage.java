package ru.netology.web.page;

import ru.netology.web.data.DataHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TransferPage {

    private SelenideElement topUpHeading = $x("//h1");
    private SelenideElement amount = $("[data-test-id='amount'] input");
    private SelenideElement cardFrom = $("[data-test-id='from'] input");
    private SelenideElement topUpButton = $("[data-test-id='action-transfer']");

    public TransferPage() {
        topUpHeading.shouldBe(Condition.visible);
    }

    public DashboardPage shouldTransferMoney(DataHelper.CardNumber cardNumber) {
        amount.setValue("100");
        cardFrom.setValue(cardNumber.getCardNumber());
        topUpButton.click();
        return new DashboardPage();

    }
}