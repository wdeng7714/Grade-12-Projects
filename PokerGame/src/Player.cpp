/*
 * Player.cpp
 *
 *  Created on: Mar 1, 2016
 *      Author: Angela
 */

#include "Player.h"

Player::Player() {
	// TODO Auto-generated constructor stub

}

Player::~Player() {
	// TODO Auto-generated destructor stub
}

void Player::dealHand(Dealer &dealer) {
	m_playerHand.dealHand(dealer);
}
void Player::dealCard(Dealer &dealer, int num) {
	m_playerHand.dealCard(dealer, num);
}
