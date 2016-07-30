#include <iostream>
#include <string>

using namespace std;

#ifndef CARDS_H
#define CARDS_H

class Cards {
private:
	int m_face, m_suit;

	static string m_faces[13];
	static string m_suits[4];

public:
	Cards();
	Cards(int face, int suit);
	int getFace();
	int getSuit();
	int getRank();
	void setFace(int);
	void setSuit(int);
	string toString();
};

#endif
