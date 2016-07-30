/*
 * DeckOfCards.cpp
 *
 *  Created on: Feb 29, 2016
 *      Author: Angela
 */

#include "DeckOfCards.h"
#include <cstdlib>

using namespace std;

DeckOfCards::DeckOfCards() {
	m_deck = new Cards[SIZE_OF_DECK];
	m_currentCard = 0;
	for (int i = 0; i < SIZE_OF_DECK; i++) {
		m_deck[i].setFace(i % 13); // assigns face in systematic order
		m_deck[i].setSuit(i / 13); // assigns suit in systematic order
	}
}

DeckOfCards::~DeckOfCards() {
	delete[] m_deck;
}

void DeckOfCards::shuffle() {
	Cards tempCard;
	int randomNumber;

	for (int i = 0; i < SIZE_OF_DECK; i++) {
		randomNumber = rand() % SIZE_OF_DECK;
		tempCard = m_deck[randomNumber];
		m_deck[randomNumber] = m_deck[i];
		m_deck[i] = tempCard;
	}
}

Cards DeckOfCards::dealCard() {
	m_currentCard++;
	return m_deck[m_currentCard - 1];
}

bool DeckOfCards::moreCards() {
	if(m_currentCard>=SIZE_OF_DECK){
		return false;
	}
	else{
		return true;
	}
}

int DeckOfCards::getSizeOfDeck(){
	return SIZE_OF_DECK;
}

