package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	public static int dealCard() {// Generates a random card to deal.
		int[] cards = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
		Random generator = new Random();
		int randomIndex = generator.nextInt(cards.length);
		// int randomIndex = (int) (Math.random() * (cards.length + 1));
		return cards[randomIndex];
	}

	public static int calculateScore(List<Integer> cards) {// Takes an Array of cards, sums and returns the total
		int sum = 0;

		for (int i = 0; i < cards.size(); i++) {
			sum += cards.get(i);
		}

		if (sum == 21 && cards.size() == 2) {
			return 0;
		}

		if (cards.contains(11) && cards.size() > 21) {
			cards.remove(11);
			cards.add(1);
		}
		return sum;
	}

	public static String compareScores(int userScore, int computerScore) {
		if (userScore > 21 && computerScore > 21) {
			return "House Wins!";
		} else if (userScore == computerScore) {
			return "Draw!";
		} else if (computerScore == 0) {
			return "House has Blackjack. House Wins!";
		} else if (userScore == 0) {
			return "You have Blackjack. You win!";
		} else if (userScore > 21) {
			return "Bust, you lose!";
		} else if (computerScore > 21) {
			return "House bust, you win!";
		} else if (userScore > computerScore) {
			return "You win!";
		} else {
			return "You lose!";
		}
	}

	public static int computerHand(int computerScore, List<Integer> computerCards) {
		while (computerScore != 0 && computerScore < 17) {
			computerCards.add(dealCard());
			computerScore = calculateScore(computerCards);
		}
		return computerScore;
	}

	public static void calculateFinalScore(int userScore, int computerScore) {
		System.out.println("Your final score: " + userScore);
		System.out.println("computers final score: " + computerScore);
		System.out.println(compareScores(userScore, computerScore));
	}

	public static void generateFirstHand(List<Integer> userCards, List<Integer> computerCards) {
		for (int i = 0; i < 2; i++) {// initial hand
			userCards.add(dealCard());
			computerCards.add(dealCard());
		}
	}

	public static void game() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int computerScore = 0;
		int userScore = 0;
		String userInput;
		String shouldUserHit;
		List<Integer> userCards = new ArrayList<>();
		List<Integer> computerCards = new ArrayList<>();
		boolean loopRelay = true;

		generateFirstHand(userCards, computerCards);

		while (loopRelay) {
			userScore = calculateScore(userCards);
			computerScore = calculateScore(computerCards);

			System.out.println(
					"Your cards are: " + userCards.get(0) + ", " + userCards.get(1) + ". Your score is: " + userScore);
			System.out.println("Computers first card is: " + computerCards.get(0));

			if (userScore == 0 || computerScore == 0 || userScore > 21) {
				loopRelay = false;
			} else {
				System.out.println("Do you wish to hit? Type hit to continue or no to stay.");
				userInput = scanner.next();
				shouldUserHit = userInput.toLowerCase();
				if (shouldUserHit.contains("hit")) {
					userCards.add(dealCard());
				} else if (shouldUserHit.contains("no")) {
					loopRelay = false;
				} else {
					System.out.println("Please enter hit or no");
				}
			}
		}
		computerHand(computerScore, computerCards);
		calculateFinalScore(userScore, computerScore);
	}

	public static void play() {
		Scanner scnr = new Scanner(System.in);
		String option;
		String userInput;
		boolean tooPlay = true;
		while (tooPlay) {
			System.out.println("Do you want to play Blackjack? Type yes to play or exit to quit program.");
			userInput = scnr.nextLine();
			option = userInput.toLowerCase();
			if (option.contains("yes")) {
				game();
			} else if (option.contains("exit")) {
				System.out.println("Come back soon, ya hear?!");
				tooPlay = false;
				scnr.close();
			} else {
				System.out.println("Please enter yes or exit");
			}
		}
	}
}
