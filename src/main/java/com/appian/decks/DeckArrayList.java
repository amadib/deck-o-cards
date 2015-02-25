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
	
	/**
	 * Randomly reorders cards in deck using in memory technique over a single pass.
	 * 
	 * Each card will be randomly selected and inserted at random at the end of the deck. 
	 */
	public void shuffle() {
		if (deck.size() == 0){
			logger.warn("Deck is empty.");
			return;
		}
		boolean first = true;
		for (int numberOfCards = deck.size()-1; numberOfCards >= 0; numberOfCards--) 
		{
			Card c = deck.remove(Utils.randomPostionBtwn(numberOfCards));
			if (first) {
				deck.add(c);
				first = false;
			}
			else {
				int index = -1;
				index = (numberOfCards - 1) + Utils.randomPostionBtwn((deck.size()) - numberOfCards);
				if(index < 0){
					index *= index;
				}
				deck.add(index, c);
			}
		}
	}
	/**
	 * Returns one card from deck
	 * 
	 * @return the topmost card; null if the deck is empty
	 */
	public Card dealOneCard() {
		if(deck.size() > 0){
			return deck.remove(0);
		}
		else {
			logger.warn("Deck has no more cards.");
			return null;
		}
	}
	
	@Override
	public String toString(){
		if (deck.size() == 0 ){
			logger.warn("Deck is empty.");
			return "Deck is empty.";
		}
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(Card c : deck){
			sb.append(c.toString() + ((count < deck.size()) ? ", " : ""));
			count++;
		}
		return sb.toString();
	}

	public void printSuitFirst() {
		for(Card c : deck){
			System.out.println(c.printSuitFirst());
		}
	}

	public void printBackwardsSuitFirst() {
		for(int i = deck.size(); i >= 0; i--){
			System.out.println(deck.get(i).printSuitFirst());
		}
	}

	public void printBackwardsFaceFirst() {
		for(int i = deck.size(); i >= 0; i--){
			System.out.println(deck.get(i).printFaceFirst());
		}
	}

	public void printFaceFirst() {
		for(Card c : deck){
			System.out.println(c.printFaceFirst());
		}		
	}
}
