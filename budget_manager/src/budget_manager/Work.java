package budget_manager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Work {
	static Scanner scnr = new Scanner(System.in);
	private static boolean loopRelayOne = true;
	protected static boolean loopRelayTwo = true;
	static String path = "purchases.txt";
	
	static ArrayList<String> purchasesList = new ArrayList<>();
	static ArrayList<Purchase> foodPurchases = new ArrayList<>();
	static ArrayList<Purchase> clothingPurchases = new ArrayList<>();
	static ArrayList<Purchase> entertainmentPurchases = new ArrayList<>();
	static ArrayList<Purchase> otherPurchases = new ArrayList<>();
	static ArrayList<Purchase> allPurchases = new ArrayList<>();
	
	static DecimalFormat decimalFormat = new DecimalFormat("#.00");

	public static void addIncome(){
		System.out.println("\nEnter income:");//Potentially change this too just taking in an int and warning user to not use commas or decimals)
		try{
			Balance.setBalance(Double.parseDouble(scnr.next().replaceAll(",",".")));
			System.out.println("Income was added.\n");
		} catch (Throwable e) {
			System.out.println("Incorrect input.");
		}
	}

	public static void showBalance() {
		System.out.println("\nBalance: $" + Balance.getBalance() + "\n");
		startMenu();
	}

	public static void back() {
		loopRelayTwo = false;
		System.out.println();
		startMenu();
	}

	public static void exit() {
		loopRelayOne = false;
		System.out.print("Exiting program.");
	}

	public static void startMenu() {
		System.out.println("Please pick from the menu below.");
		System.out.println("1) Add income.");
		System.out.println("2) Add purchase.");
		System.out.println("3) Show list of purchases.");
		System.out.println("4) Show Balance.");
		System.out.println("5) Save.");
		System.out.println("6) Load items.");
		System.out.println("7) Sort & analyze.");
		System.out.println("0) Exit.");

		String userInput = scnr.next();
	while(loopRelayOne){
		switch(userInput){
			case "1":
				addIncome();
				break;
			case "2":
				Purchases.showPurchaseMenu();
				break;
			case "3":
				ListPurchases.showListPurchaseMenu();
				break;
			case "4":
				showBalance();
				break;
			case "5":
				Save.save();
				break;
			case "6":
				Load.load();
				break;
			case "7":
				Analyze.analyzeAll();
				break;
			case "0":
				exit();
				break;
			default:
				System.out.println("Please enter a number between 0 and 7.");
			}
		}
	}
}
