package com.appian.players;

import com.appian.cards.Card;
import com.appian.decks.DeckArrayList;
import com.appian.decks.IDeck;

public class Dealer {
	static IDeck deck = DeckArrayList.getNewDeck();
	
	public static void main(String[]args){
		deck.print();
		System.out.println("============Shuffle==============");
		deck.shuffle();
		deck.printSuitFirst();
		System.out.println("============Empty The Deck==============");
		int i = 54;
		while(i-- != 0){
			Card card = deck.dealOneCard();
			System.out.println("Drew " + card);
		}
	}
}
