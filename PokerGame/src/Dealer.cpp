/*
 * Dealer.cpp
 *
 *  Created on: Feb 29, 2016
 *      Author: Angela
 */

#include "Dealer.h"

Dealer::Dealer() {
	m_dealerDeck.shuffle();
}

void Dealer::dealDeck() {
	for (int i = 0; i < m_dealerDeck.getSizeOfDeck(); i++) {
		Cards newCard = m_dealerDeck.dealCard();
		cout << newCard.toString();
		cout << endl;
	}
}

Cards Dealer::dealNextCard(){
	return m_dealerDeck.dealCard();
}

