/*
 * PokerHand.h
 *
 *  Created on: Feb 29, 2016
 *      Author: Angela
 */
#include "Dealer.h"

#include <vector>

#ifndef HAND_H_
#define HAND_H_

class Hand {
	enum Rank{
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE
	};
	enum Status{
		ONLY_SINGLES,
		ONE_PAIR,
		TWO_PAIRS,
		THREE_OF_A_KIND,
		ONLY_STRAIGHT,
		ONLY_FLUSH,
		FULL_HOUSE,
		FOUR_OF_A_KIND,
		STRAIGHT_FLUSH

	};

private:
	vector<Cards> m_hand;
	static const int SIZE_POKER_HAND = 5;
	int frequencies[13];
	Status m_status;
	Rank m_rank;

	void updateFrequencies();
	void updateStatus();
	void sortHand();

	int FourOfAKind();
	int ThreeOfAKind();
	int TwoOfAKind();
	int OneOfAKind();

	bool isFlush();
	bool isStraight();

public:
	Hand();
	~Hand();
	void dealHand(Dealer &dealer);
	void dealCard(Dealer &dealer,int num);
	void printHand();
	int getSizeOfHand();
	string getStatus();

};

#endif /* HAND_H_ */
