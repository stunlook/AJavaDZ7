package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    private SelenideElement buttonPress = $("[data-test-id=action-deposit]");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private ElementsCollection transfer = $$("[data-test-id='action-deposit']");

    public DashboardPage transferCard(String cardNumber, String sum) {
        buttonPress.click();
        amountField.setValue(sum);
        fromField.setValue(cardNumber);
        transferButton.click();
        return new DashboardPage();
    }

    public String getErrorMsg() {
        return $(".notification__content").getText();
    }

    public TransferPage buttonPress(int index) {
        transfer.get(index).click();
        return new TransferPage();
    }
}