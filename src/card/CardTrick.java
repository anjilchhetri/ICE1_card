/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author Anjil Chhetri 991719685
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
// Adding new card:luckyCard
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Hearts");

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            do {
                c.setValue(rand.nextInt(13) + 1);
                c.setSuit(Card.SUITS[rand.nextInt(4)]);
            } while (containsCard(magicHand, c));

            magicHand[i] = c;
        }

        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        boolean foundLuckyCard = containsCard(magicHand, luckyCard);

        if (foundLuckyCard) {
            System.out.println("Congratulations! The lucky card is in the magic hand!");
        } else {
            System.out.println("Sorry, the lucky card is not in the magic hand.");
        }
    }

    private static boolean containsCard(Card[] hand, Card card) {
        for (Card c : hand) {
            if (c != null && c.getValue() == card.getValue() && c.getSuit().equals(card.getSuit())) {
                return true;
            }
        }
        return false;
    }
}