/*
 * DeckOfCards.h
 *
 *  Created on: Feb 29, 2016
 *      Author: Angela
 */
#include <iostream>
#include <string>
#include "Cards.h"

using namespace std;

#ifndef DECKOFCARDS_H_
#define DECKOFCARDS_H_

class DeckOfCards {
private:
	static const int SIZE_OF_DECK = 52;
	int m_currentCard;
	Cards *m_deck;
public:
	DeckOfCards();
	~DeckOfCards();
	void shuffle();
	Cards dealCard();
	bool moreCards();
	int getSizeOfDeck();

};

#endif /* DECKOFCARDS_H_ */
