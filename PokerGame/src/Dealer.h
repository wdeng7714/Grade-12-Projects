/*
 * Dealer.h
 *
 *  Created on: Feb 29, 2016
 *      Author: Angela
 */
#include "DeckOfCards.h"

#ifndef DEALER_H_
#define DEALER_H_

class Dealer {
private:
	DeckOfCards m_dealerDeck;
public:
	Dealer();

	void dealDeck();
	Cards dealNextCard();
};

#endif /* DEALER_H_ */
