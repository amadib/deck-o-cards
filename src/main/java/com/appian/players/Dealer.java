package com.appian.players;

import org.apache.log4j.Logger;

import com.appian.cards.Card;
import com.appian.decks.DeckArrayList;
import com.appian.decks.IDeck;

public class Dealer {
	private static final Logger logger = Logger.getLogger(Dealer.class);	

	static IDeck deck = DeckArrayList.getNewDeck();
	
	public static void main(String[]args){
		deck.print();
		logger.info("============Shuffle==============");
		deck.shuffle();
		deck.printSuitFirst();
		logger.info("============Empty The Deck==============");
		int i = 54;
		while(i-- != 0){
			Card card = deck.dealOneCard();
			logger.info("Drew " + card);
		}
	}
}
