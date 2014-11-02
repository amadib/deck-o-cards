package com.appian.decks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.appian.cards.Card;
import com.appian.cards.Face;
import com.appian.cards.Suit;
import com.appian.cards.utils.Utils;

public class DeckArrayList implements IDeck{

	private static final Logger logger = Logger.getLogger(DeckArrayList.class);	
	private List<Card> deck;
	static Card[] deckOfCards = new Card[52];
	static {
		Card previous = null;
		int i = 0;
		for (Suit suit : Suit.values()){
			for (Face face : Face.values()){
				Card card = new Card(suit, face, previous, null);
				deckOfCards[i++] = card;
			}
		}
	}
	
	public static DeckArrayList getNewDeck(){
		return new DeckArrayList();
	}
	
	private DeckArrayList(){
		deck = new ArrayList<Card>(Arrays.asList(deckOfCards));
	}
	
	public void shuffle() {
		boolean first = true;
		for (int numberOfCards = deck.size() + 1; numberOfCards >= 0; numberOfCards--) 
		{
			Card c = deck.remove(Utils.randomPostionBtw(numberOfCards));
			if (first) {
				deck.add(c);
				first = false;
			}
			else {
				int index = -1;
				do {
					index = (numberOfCards - 1) + Utils.randomPostionBtw((deck.size()) - numberOfCards);
				} while (index < 0);
				deck.add(index, c);
			}
		}
	}

	public Card dealOneCard() {
		if(deck.size() > 0){
			return deck.remove(0);
		}
		else {
			logger.warn("Deck has no more cards.");
			return null;
		}
	}

	public void printSuitFirst() {
		for(Card c : deck){
			logger.info(c.toStringBackwards());
		}
	}

	public void printSuitFirstBackwards() {
		for(int i = deck.size(); i >= 0; i--){
			logger.info(deck.get(i).toStringBackwards());
		}
	}

	public void printBackwards() {
		for(int i = deck.size(); i >= 0; i--){
			logger.info(deck.get(i).toString());
		}
	}

	public void print() {
		for(Card c : deck){
			logger.info(c.toString());
		}		
	}
}
