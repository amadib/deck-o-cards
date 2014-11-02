package com.appian.decks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.appian.cards.Card;
import com.appian.cards.Face;
import com.appian.cards.Suit;
import com.appian.cards.utils.Utils;

public class DeckArrayList implements IDeck{

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
		for (int numberOfCards = deck.size()+1; numberOfCards >= 0; numberOfCards--){
			Card c = deck.remove(Utils.randomPostionBtw(numberOfCards));
			if (first){
				deck.add(c);				
				first = false;
			} else {
				int i = Utils.randomPostionBtw((deck.size())-numberOfCards);
				deck.add((numberOfCards - 1) + i, c);
			}
		}
	}

	public Card dealOneCard() {
		if(deck.size() > 0){
			return deck.remove(0);
		}
		else {
			System.err.println("Deck has no more cards.");
			return null;
		}
	}

	public void printSuitFirst() {
		for(Card c : deck){
			System.out.println(c.toStringBackwards());
		}
	}

	public void printSuitFirstBackwards() {
		for(int i = deck.size(); i >= 0; i--){
			System.out.println(deck.get(i).toStringBackwards());
		}
	}

	public void printBackwards() {
		for(int i = deck.size(); i >= 0; i--){
			System.out.println(deck.get(i).toString());
		}
	}

	public void print() {
		for(Card c : deck){
			System.out.println(c.toString());
		}		
	}
}
