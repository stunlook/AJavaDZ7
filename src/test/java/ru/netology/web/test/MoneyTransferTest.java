package ru.netology.web.test;

import ru.netology.web.data.DataHelper;
import ru.netology.web.page.TransferPage;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import org.junit.jupiter.api.Test;

import static ru.netology.web.data.DataHelper.getCardNumber2;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var dashboardPage = new DashboardPage();
        var cardNumber = dashboardPage.clicksOnCard();
        var cardTopUpPage = new TransferPage();
        cardTopUpPage.shouldTransferMoney(getCardNumber2());
    }
}