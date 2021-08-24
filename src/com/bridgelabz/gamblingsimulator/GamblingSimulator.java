package com.bridgelabz.gamblingsimulator;

public class GamblingSimulator {
	static final int DAILY_STAKE = 100;
	static final int BET_EVERY_GAME = 1;
	static final int LOSE = 0;
	static final int WIN = 1;
	static final int NO_OF_DAYS = 20;

	public static void main(String[] args) {
		int currentBalance = 0;
		for(int day=0;day<NO_OF_DAYS;day++) {
			int dailyAmount = DAILY_STAKE;
			while (willContinueGamble(dailyAmount)) {
				dailyAmount = play(dailyAmount);
			}
			calculateDailyGainorLoss(dailyAmount, day);
			currentBalance += dailyAmount;
		}
		calculateTotalGainOrLoss(currentBalance);
	}
	
	public static void calculateDailyGainorLoss(int dailyAmount,int day) {
		int dailyNet = dailyAmount-DAILY_STAKE;
		System.out.println("$"+(dailyNet>0?dailyNet:-dailyNet)+" "+(dailyNet>0?"Gained":"Lost")+" on day "+(day+1));
	}
	
	public static void calculateTotalGainOrLoss(int currentBalance) {
		int netChange = currentBalance-(NO_OF_DAYS * DAILY_STAKE);
		System.out.println("Total amount won or lost = $"+(netChange>0?netChange:-netChange)+" "+(netChange>0?"Gained":"Lost"));
	}
	
	public static boolean willContinueGamble(int dailyAmount) {
		return dailyAmount > 0.5 * DAILY_STAKE && dailyAmount < 1.5 * DAILY_STAKE;
	}

	public static int play(int currentBalance) {
		int randomNumber = (int) Math.floor(Math.random() * 2);

		if (randomNumber == 0) {
			currentBalance--;
		} else {
			currentBalance++;
		}

		return currentBalance;
	}
}
