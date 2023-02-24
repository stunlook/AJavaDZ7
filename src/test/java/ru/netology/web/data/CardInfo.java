package ru.netology.web.data;

import lombok.Value;

public class CardInfo {

    private CardInfo() { }

        @Value
        public static class Cards {

            private String card;

            public static CardInfo.Cards getFirstCard() {
                return new CardInfo.Cards("5559 0000 0000 0001");
            }

            public static CardInfo.Cards getSecondCard() {
                return new CardInfo.Cards("5559 0000 0000 0002");
            }
        }
    }
