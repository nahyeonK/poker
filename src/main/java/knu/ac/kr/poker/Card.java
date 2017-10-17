package knu.ac.kr.poker;

public class Card {
    private Suit suit;
    private int rank;

    public Card(int rank, Suit suit){
        if(rank > 13 || rank < 0) {
            throw new NoSuchRankException();
        }

        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
