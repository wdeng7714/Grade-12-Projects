#include "player.h"

#ifndef POKERGAME_H_
#define POKERGAME_H_

class PokerGame {
private:
	Dealer m_dealer;
	Player m_player;
	Player m_cpu;

public:
	void initialize();
	PokerGame();
	~PokerGame();
};

#endif /* POKERGAME_H_ */
