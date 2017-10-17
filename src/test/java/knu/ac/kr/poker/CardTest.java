package knu.ac.kr.poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CardTest {

    @Test
    public void 카드_다이아몬드_5생성_성공(){
        Card card = new Card(5, Suit.DIAMOND);
        int rank = card.getRank();
        Suit suit = card.getSuit();
        assertTrue(rank == 5);
        assertTrue(suit == Suit.DIAMOND);
    }

    @Test(expected = NoSuchRankException.class)
    public void 카드_랭크_14이상_생성시_에러발생(){
        Card card = new Card(14, Suit.HEART);

    }

    @Test(expected = NoSuchRankException.class)
    public void 카드_랭크_음수값_생성시_에러발생(){
        Card card = new Card(-1, Suit.HEART);

    }
}
