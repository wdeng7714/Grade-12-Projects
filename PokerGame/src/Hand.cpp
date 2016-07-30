#include "Hand.h"
#include <algorithm>

Hand::Hand() {
	m_rank = TWO;
	m_status = ONLY_SINGLES;
}

Hand::~Hand() {
	m_hand.erase(m_hand.begin(), m_hand.begin() + SIZE_POKER_HAND);
}

void Hand::dealHand(Dealer &dealer) {
	m_hand.erase(m_hand.begin(), m_hand.begin() + SIZE_POKER_HAND);
	for (int i = 0; i < SIZE_POKER_HAND; i++) {
		m_hand.push_back(dealer.dealNextCard());
	}

	for (int i = 0; i < 13; i++) {
		frequencies[i] = 0;
	}

	m_rank = TWO;
	m_status = ONLY_SINGLES;
}

void Hand::dealCard(Dealer &dealer, int num) {
	for (int i = 0; i < num; i++) {
		m_hand.push_back(dealer.dealNextCard());
	}
}

void Hand::printHand() {
	sortHand();
	for (int i = 0; i < SIZE_POKER_HAND; i++) {
		cout << m_hand[i].toString() << endl;
	}
}

void Hand::updateStatus() {
	updateFrequencies();
	sortHand();

	int numSingles = OneOfAKind();
	int numPairs = TwoOfAKind();
	int numTriples = ThreeOfAKind();
	int numQuadruples = FourOfAKind();

	bool flush = isFlush();
	bool straight = isStraight();

	if (numSingles == 5) {
		m_status = ONLY_SINGLES;
		if (flush)
			m_status = (straight) ? STRAIGHT_FLUSH : ONLY_FLUSH;
		else if (straight)
			m_status = ONLY_STRAIGHT;
	} else {
		if (numPairs == 1)
			m_status = (numTriples == 1) ? FULL_HOUSE : ONE_PAIR;
		else if (numPairs == 2)
			m_status = TWO_PAIRS;
		else {
			if (numTriples == 1)
				m_status = THREE_OF_A_KIND;
			else if (numQuadruples == 1)
				m_status = FOUR_OF_A_KIND;
		}
	}
}
void Hand::sortHand() {
	int minIndex;
	Cards temp;

	for (int i = 0; i < static_cast<signed int>(m_hand.size()); i++) {
		minIndex = i;

		for (int j = i; j < static_cast<signed int>(m_hand.size()); j++) {
			if (m_hand[j].getRank() < m_hand[minIndex].getRank())
				minIndex = j;
		}

		swap(m_hand[minIndex], m_hand[i]);
	}
}
void Hand::updateFrequencies() {
	for (int i = 0; i < static_cast<signed int>(m_hand.size()); i++) {
		frequencies[m_hand[i].getFace()]++;
	}
}
int Hand::FourOfAKind() {
	int counter = 0;
	for (int i = 0; i < 13; i++) {
		if (frequencies[i] == 4) {
			counter++;
		}
	}
	return counter;
}
int Hand::ThreeOfAKind() {
	int counter = 0;
	for (int i = 0; i < 13; i++) {
		if (frequencies[i] == 3) {
			counter++;
		}
	}
	return counter;
}
int Hand::TwoOfAKind() {
	int counter = 0;
	for (int i = 0; i < 13; i++) {
		if (frequencies[i] == 2) {
			counter++;
		}
	}
	return counter;
}
int Hand::OneOfAKind() {
	int counter = 0;
	for (int i = 0; i < 13; i++) {
		if (frequencies[i] == 1) {
			counter++;
		}
	}
	return counter;
}

bool Hand::isFlush() {
	if (m_hand.size() == 5) {
		int commonSuit = m_hand[0].getSuit();
		for (int i = 0; i < static_cast<signed int>(m_hand.size()); i++) {
			if (m_hand[i].getSuit() != commonSuit)
				return false;
		}
		return true;
	}

	return false;
}
bool Hand::isStraight() {
	if (m_hand.size() == 5) {
		int lowestNumber = m_hand[0].getFace();
		for (int i = 0; i < static_cast<signed int>(m_hand.size()); i++) {
			if (m_hand[i].getFace() != lowestNumber + i) {
				if (lowestNumber == 0 && i == 4) {
					if (m_hand[i].getFace() != 12)
						return false;
				} else {
					return false;
				}

			}
		}

		return true;
	}
	return false;
}

int Hand::getSizeOfHand() {
	return static_cast<signed int>(m_hand.size());
}
string Hand::getStatus() {

	updateStatus();

	switch (m_status) {
	case STRAIGHT_FLUSH:
		return "Straight-Flush";
	case FOUR_OF_A_KIND:
		return ("Four of a Kind");
	case FULL_HOUSE:
		return ("Full House");
	case ONLY_FLUSH:
		return ("Flush");
	case ONLY_STRAIGHT:
		return ("Straight");
	case THREE_OF_A_KIND:
		return "Three of a Kind";
	case TWO_PAIRS:
		return "Two Pairs";
	case ONE_PAIR:
		return "One Pair";
	default:
		return "Only Singles";
	}
}
