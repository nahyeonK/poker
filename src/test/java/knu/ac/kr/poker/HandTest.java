package knu.ac.kr.poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HandTest {
    @Test
    public void 한장의_카드를_덱에서뽑으면_핸드는_1개이다(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();
        hand.addCard(deck.drawCard());

        assertTrue(hand.getCardCount() == 1);
    }

    @Test
    public void 다섯장의_카드를_덱에서뽑으면_핸드는_5개이다(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();

        for(int i = 0; i < 5; i++)
            hand.addCard(deck.drawCard());

        assertTrue(hand.getCardCount() == 5);
    }

    @Test(expected = NoMoreHandException.class)
    public void 핸드에_5장이있는채로_카드를_더뽑으면_에러발생(){
        Deck deck = new Deck(1);
        Hand hand = new Hand();

        for(int i = 0; i < 5; i++)
            hand.addCard(deck.drawCard());

        hand.addCard(deck.drawCard());
    }
}
