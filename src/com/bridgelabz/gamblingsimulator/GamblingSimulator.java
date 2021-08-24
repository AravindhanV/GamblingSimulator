package com.bridgelabz.gamblingsimulator;

import java.util.ArrayList;

public class GamblingSimulator {
	static final int DAILY_STAKE = 100;
	static final int BET_EVERY_GAME = 1;
	static final int LOSE = 0;
	static final int WIN = 1;
	static final int NO_OF_DAYS = 20;

	public static void main(String[] args) {
		int currentBalance = 0;
		ArrayList<Integer> gainDays = new ArrayList<>();
		ArrayList<Integer> lossDays = new ArrayList<>();
		
		for(int day=0;day<NO_OF_DAYS;day++) {
			int dailyAmount = DAILY_STAKE;
			while (willContinueGamble(dailyAmount)) {
				dailyAmount = play(dailyAmount);
			}
			boolean isGain = calculateDailyGainorLoss(dailyAmount, day);
			
			if(isGain) {
				gainDays.add(day+1);
			} else {
				lossDays.add(day+1);
			}
			currentBalance += dailyAmount;
		}
		calculateTotalGainOrLoss(currentBalance);
		System.out.println("The lucky days are:");
		for(int item : gainDays) {
			System.out.print(item+" ");
		}
		System.out.println("\nThe unlucky days are:");
		for(int item : lossDays) {
			System.out.print(item+" ");
		}
	}
	
	public static boolean calculateDailyGainorLoss(int dailyAmount,int day) {
		int dailyNet = dailyAmount-DAILY_STAKE;
		System.out.println("$"+(dailyNet>0?dailyNet:-dailyNet)+" "+(dailyNet>0?"Gained":"Lost")+" on day "+(day+1));
		return dailyNet>0;
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
