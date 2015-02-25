package com.appian.players;

import org.apache.log4j.Logger;

import com.appian.cards.Card;
import com.appian.decks.DeckArrayList;
import com.appian.decks.IDeck;
/**
 * Main class of Deck-o-Cards
 * 
 * Dealer will get a deck of cards and proceed to shuffle twice
 * before dealing out the entire deck.  
 * 
 */
public class Dealer {
	private static final Logger logger = Logger.getLogger(Dealer.class);	

	public static void main(String[]args){
		IDeck deck = DeckArrayList.getNewDeck();
		deck.printFaceFirst();
		System.out.println("============First Shuffle===============");
		deck.shuffle();
		deck.printSuitFirst();
		System.out.println("============Second Shuffle==============");
		deck.shuffle();
		System.out.println(deck);
		System.out.println("============Empty The Deck==============");
		int i = 54;
		while(i-- != 0){
			Card card = deck.dealOneCard();
			if (card == null){
				System.out.println("No Jokers here!");
			} else {
				System.out.println("Drew " + card);
			}
		}
		System.out.println(deck);
		System.out.println("========Shuffle an Empty Deck========");		
		deck.shuffle();
		System.out.println(deck);
	}
}
