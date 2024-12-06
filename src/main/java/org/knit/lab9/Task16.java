package org.knit.lab9;

public class Task16 {
    public static void execute() {
        String[] cards = new String[52];
        int count = 0;
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards[count] = rank + " OF " + suit;
                count += 1;
            }
        }
        for (String card : cards) {
            System.out.println(card);
        }
    }
}
