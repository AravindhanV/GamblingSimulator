package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
	static final int DAILY_STAKE = 100;
	static final int BET_EVERY_GAME = 1;
	static final int LOSE = 0;
	static final int WIN = 1;
	
	public static void main(String[] args) {
		int currentBalance = DAILY_STAKE;
		currentBalance = simulateBet(currentBalance);
	}
	
	public static int simulateBet(int currentBalance) {
		int randomNumber = (int)Math.floor(Math.random() * 2);
		
		if(randomNumber == 0) {
			currentBalance--;
		} else {
			currentBalance++;
		}
		
		return currentBalance;
	}
}
