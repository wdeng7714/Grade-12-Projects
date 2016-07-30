#include <iostream>
#include <ctime>
#include <cstdlib>

#include "PokerGame.h"

int main() {
	srand(static_cast<unsigned int>(time(0)));
	cout << "Discover. Fearless. mOtivation." << endl;

	PokerGame pokerGame;

	pokerGame.initialize();

	return 0;
}
