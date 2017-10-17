package knu.ac.kr.poker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EvaluatorTest {

    @Test
    public void 로열스트레이트_플러쉬_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(10, Suit.SPADE));
        hand.addCard(new Card(11, Suit.SPADE));
        hand.addCard(new Card(12, Suit.SPADE));
        hand.addCard(new Card(13, Suit.SPADE));
        hand.addCard(new Card(1, Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);

        assertTrue(result.equals("ROYAL_STRAIGHT_FLUSH"));
    }

    @Test
    public void 플러쉬_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(7, Suit.CLUB));
        hand.addCard(new Card(8, Suit.CLUB));
        hand.addCard(new Card(10, Suit.CLUB));
        hand.addCard(new Card(13, Suit.CLUB));
        hand.addCard(new Card(2, Suit.CLUB));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);

        assertTrue(result.equals("FLUSH"));
    }

    @Test
    public void 스트레이트_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(10, Suit.HEART));
        hand.addCard(new Card(11, Suit.SPADE));
        hand.addCard(new Card(12, Suit.CLUB));
        hand.addCard(new Card(13, Suit.HEART));
        hand.addCard(new Card(9, Suit.SPADE));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);

        assertTrue(result.equals("STRAIGHT"));
    }

    @Test
    public void 포카드_검증_성공(){
        Hand hand = new Hand();
        hand.addCard(new Card(7, Suit.HEART));
        hand.addCard(new Card(1, Suit.SPADE));
        hand.addCard(new Card(7, Suit.DIAMOND));
        hand.addCard(new Card(7, Suit.CLUB));
        hand.addCard(new Card(7, Suit.HEART));

        Evaluator evaluator = new Evaluator();
        String result = evaluator.evaluate(hand);

        assertTrue(result.equals("FOUR_CARD"));
    }
}
