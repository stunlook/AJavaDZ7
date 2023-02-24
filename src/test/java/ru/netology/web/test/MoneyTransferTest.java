package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.CardInfo;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.*;


class MoneyTransferTest {

    @BeforeEach
    public void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsFirstCard() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new TransferPage().transferCard(CardInfo.Cards.getFirstCard().getCard(), "5000");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsSecondCard() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new TransferPage().transferCard(CardInfo.Cards.getSecondCard().getCard(), "5000");
    }

    @Test
    void shouldBeVisibleFirstCardBalance() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage()
                .getCardBalance(0);
    }

    @Test
    void shouldBeVisibleSecondCardBalance() {
        var authInfo = DataHelper.getAuthInfo();
        new LoginPage()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        new DashboardPage()
                .getCardBalance(1);
    }
}