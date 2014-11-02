package com.appian.cards;

import com.appian.cards.utils.Utils;

public class Card {
	private Suit suit;
	private Face face;
	
	protected Card(Suit suit, Face face) {
		this.suit = suit;
		this.face = face;
	}
	public Card(Suit suit, Face face, Card previous, Card next) {
		this.suit = suit;
		this.face = face;
		this.previous = previous;
		this.next = next;
	}
	@Override
	public String toString(){
		if (face.ordinal() == 0 || face.ordinal() >= 10 ){
			return face.name() + " of " + suit.name();
		} else {
			return (face.ordinal()+1) + " of " + suit.name();
		}
	}
	
	public String printFaceFirst(){
		return Utils.padRight(face.name(), 5) + " " + suit.name();
	}
	public String printSuitFirst() {
		return Utils.padRight(suit.name(), 8) + " " + face.name();
	}
	
	/**
	 * Deprecated methods  
	 */
	@Deprecated
	private Card next = null;
	@Deprecated
	private Card previous = null;

	@Deprecated
	public Card getNext() {
		return next;
	}
	@Deprecated
	public void setNext(Card next) {
		this.next = next;
	}
	@Deprecated
	public Card getPrevious() {
		return previous;
	}
	@Deprecated
	public void setPrevious(Card previous) {
		this.previous = previous;
	}
	
	@Deprecated
	public void addToLeft(Card process) 
	{
		this.setPrevious(process);
		process.setPrevious(null);
		process.setNext(this);
	}
	@Deprecated
	public void addToRight(Card process) 
	{
		this.setNext(process);
		process.setPrevious(this);
		process.setNext(null);
	}
	@Deprecated
	public Card removeAndLinkCards() {
		if (getPrevious() != null || getNext() != null){
			if (getPrevious() == null){
				getNext().setPrevious(null);
			} 
			else if (getNext() == null){
				getPrevious().setNext(null);
			} 
			else {
				getPrevious().setNext(getNext());		
				getNext().setPrevious(getPrevious());
			}
			setNext(null);
			setPrevious(null);
		}
		return this;
	}
}
