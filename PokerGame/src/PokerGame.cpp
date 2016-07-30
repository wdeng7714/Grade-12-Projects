#include <iostream>
#include <ctime>
#include <cstdlib>

#include "PokerGame.h"
using namespace std;

PokerGame::PokerGame() {

}

PokerGame::~PokerGame() {
	// TODO Auto-generated destructor stub
}

void PokerGame::initialize() {
	m_player.dealCard(m_dealer, 2);
	m_cpu.dealCard(m_dealer,2);
}


