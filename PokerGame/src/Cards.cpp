#include "Cards.h"

using namespace std;

Cards::Cards() {
	m_face = 0;
	m_suit = 0;
}

Cards::Cards(int face, int suit) {
	setFace(face);
	setSuit(suit);
}

int Cards::getFace() {
	return m_face;
}

int Cards::getSuit() {
	return m_suit;
}

int Cards::getRank() {
	return m_face * 4 + m_suit;
}

void Cards::setFace(int face) {
	if (face >= 0 && face < 13)
		m_face = face;
	else
		m_face = 0;
}

void Cards::setSuit(int suit) {
	if (suit >= 0 && suit < 4)
		m_suit = suit;
	else
		m_suit = 0;
}

string Cards::toString() {
	string m_faces[13] = { "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
	string m_suits[4] = { "Diamonds", "Clubs", "Hearts", "Spades" };
	return m_faces[m_face] + " of " + m_suits[m_suit];
}
