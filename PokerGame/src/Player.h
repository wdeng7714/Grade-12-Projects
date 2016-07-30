/*
 * Player.h
 *
 *  Created on: Mar 1, 2016
 *      Author: Angela
 */
#include "Hand.h"

#ifndef PLAYER_H_
#define PLAYER_H_

class Player {
private:
	Hand m_playerHand;
public:
	Player();
	virtual ~Player();
	void dealHand(Dealer &dealer);
	void dealCard(Dealer &dealer,int num);

};

#endif /* PLAYER_H_ */
