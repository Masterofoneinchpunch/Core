package com.mooip.code.util;

import java.util.Random;

/**
 * A deck of cards for various card games.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">Fisher-Yates shuffle</a>
 * @see <a href="https://bit.ly/40O0hsu">Inspired By</a>
 */
public final class DeckOfCards {
    private final int[] cards;
    private int cardPosition;
    private final Random random = new Random();
    
    public DeckOfCards(int sizeOfDeck) {
        cards = new int[sizeOfDeck];
        //assign values for each card in numerical order
        for (int i = 0; i < sizeOfDeck; i++) {
            cards[i] = i;
        }
        cardPosition = sizeOfDeck;
    }
    
    /**
     * Gets the next card from this desk.
     * 
     * @return nextCard An integer representing the card position.
     */
    public int getNextCard() {
        if (cardPosition == cards.length) {
            //Fisher-Yates shuffle
            for (int i = cards.length - 1; i >= 0; i--) {
                final int ranCardPos = random.nextInt(i + 1);
                final int temp = cards[i];
                cards[i] = cards[ranCardPos];
                cards[ranCardPos] = temp;
            }
            cardPosition = 0;
        }
        
        int nextCard = cards[cardPosition];
        cardPosition++; //get ready for the next card after this card
        return nextCard;
    }
    
    public static void main(String[] args) {
        DeckOfCards dc = new DeckOfCards(52);
        for (int i = 0; i < 10; i++) {
            System.out.println("nextCard: " + dc.getNextCard());
        }
    }
}

