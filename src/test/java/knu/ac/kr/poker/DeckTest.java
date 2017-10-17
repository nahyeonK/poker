package knu.ac.kr.poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeckTest {
    @Test
    public void Deck_1개의_총카드수는_52개이다(){
        Deck deck = new Deck(1);
        assertTrue(deck.getTotalCard() == 52);
    }

    @Test
    public void Deck_3개의_총카드수는_52곱하기3개이다(){
        Deck deck = new Deck(3);
        assertTrue(deck.getTotalCard() == 52*3);
    }

    @Test
    public void Deck_1개에서_카드한장을뽑으면_총카드수는_51개이다(){
        Deck deck = new Deck(1);

        Card card = deck.drawCard();

        assertTrue(deck.getTotalCard() == 51);
    }

    @Test(expected = NoMoreCardException.class)
    public void Deck_1개에서_카드가없을때뽑으면_에러발생(){
        Deck deck = new Deck(1);

        for(int i = 0; i < 52; i++) {
            Card card = deck.drawCard();
            System.out.println(card.getRank() + " : " + card.getSuit());

        }

        deck.drawCard();
    }
}
