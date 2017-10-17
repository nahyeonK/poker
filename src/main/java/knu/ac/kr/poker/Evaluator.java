package knu.ac.kr.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Evaluator {
    public String evaluate(Hand hand) {
        if(hand.getCardCount() != 5){
            throw new NotFullHAndException();
        }

        // check royal straight flush
        boolean isRoyalStraightFlush = true;

        List<Integer> royalRank = new ArrayList<Integer>();
        int[] rank = {1, 10, 11, 12, 13};
        for(int r : rank)
            royalRank.add(r);

        for(Card card : hand.getHandList()){
            if(card.getSuit() != Suit.SPADE) {
                isRoyalStraightFlush = false;
                break;
            }
            if(!royalRank.contains(card.getRank())){
                isRoyalStraightFlush = false;
                break;
            }
        }
        if(isRoyalStraightFlush)
            return "ROYAL_STRAIGHT_FLUSH";


        // check flush
        boolean isFlush = true;

        Suit suit = null;
        for(Card card : hand.getHandList()){
            if(suit == null)
                suit = card.getSuit();

            if(suit != card.getSuit()) {
                isFlush = false;
                break;
            }
        }
        if(isFlush)
            return "FLUSH";


        // check straight
        boolean isStraight = true;

        PriorityQueue<Integer> ranks = new PriorityQueue<Integer>();
        for(Card card : hand.getHandList())
            ranks.add(card.getRank());

        int r = ranks.poll();
        while(!ranks.isEmpty()){
            int temp = ranks.poll();
            if(temp - r != 1){
                isStraight = false;
                break;
            }
            r = temp;
        }
        if(isStraight)
            return "STRAIGHT";


        // check four card
        boolean isFourCard = true;

        int sameCardCount = 0;
        List<Card> handList = hand.getHandList();

        for(int i = 0 ; i < 2; i++) {
            int comparisonTarget = handList.get(i).getRank();

            for (Card card : handList){
                if(card.getRank() == comparisonTarget)
                    sameCardCount += 1;
            }

            if(i == 0 && sameCardCount == 4)
                break;
            if(i == 1 && sameCardCount < 4)
                isFourCard = false;

            sameCardCount = 0;
        }
        if(isFourCard)
            return "FOUR_CARD";

        return null;
    }
}
